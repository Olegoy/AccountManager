package com.simbirsoft.yashkin.accountmanager.entity.config;


import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ProjectManagerClientConfiguration {

        @Primary
        @Bean
        public ErrorDecoder projectManagerErrorDecoder() {
            return new ProjectManagerErrorDecoder();
        }

    }
