package com.todo.demo.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class TimestampJacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer(){
        return build -> build.simpleDateFormat("yyyy:MM:dd HH:mm:ss");
    }
}
