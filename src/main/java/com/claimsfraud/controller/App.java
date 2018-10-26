package com.claimsfraud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Slf4j
@SpringBootApplication
@SuppressWarnings("unused")
public class App {

    @RefreshScope
    @EnableScheduling
    @EnableAutoConfiguration
    @Configuration
    @ComponentScan({"com.claimsfraud.controller"})
    public static class Config {

        @Bean
        public String foobar(@Value("${test.local.property}") String testValue) {
            return testValue;
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
