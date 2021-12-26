package com.curseproject.alex.requestparser.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;

@Configuration
public class IntegrationConfig {

    @Value("${calculator.url}")
    private String url;
    @Value("${calculator.user}")
    private String user;
    @Value("${calculator.password}")
    private String password;

    @Bean("customRestTemplate")
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofSeconds(1))
                .setReadTimeout(Duration.ofSeconds(1))
                .basicAuthentication(user, password)
                .uriTemplateHandler(new DefaultUriBuilderFactory(url))
                .build();
    }

}
