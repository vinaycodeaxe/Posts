package com.studyroom.posts.config;

import com.google.api.client.util.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Value("${spring.restTemplate.timeout}")
    private Long timeOut;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(timeOut))
                .setReadTimeout(Duration.ofMillis(timeOut))
                .build();
    }
}
