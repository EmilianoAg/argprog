package com.ap.ap;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig {

    @EnableWebMvc
    @Configuration
    public class WebConfigure implements WebMvcConfigurer{
        public void addCorsMapping(CorsRegistry registry){
            registry.addMapping("/**");
        }
    }
}
