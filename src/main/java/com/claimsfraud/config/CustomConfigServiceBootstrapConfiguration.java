package com.claimsfraud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SuppressWarnings("unused")
@Configuration
public class CustomConfigServiceBootstrapConfiguration {


    private RestTemplate restTemplateBuilder() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList((new CustomClientHttpRequestInterceptor())));

        return restTemplate;
    }

    @Bean
    public ConfigServicePropertySourceLocator configServicePropertySourceLocator(@Autowired Environment env) {
        ConfigClientProperties clientProperties = new ConfigClientProperties(env);
        ConfigServicePropertySourceLocator configServicePropertySourceLocator = new ConfigServicePropertySourceLocator(clientProperties);
        configServicePropertySourceLocator.setRestTemplate(restTemplateBuilder());
        return configServicePropertySourceLocator;
    }

}
