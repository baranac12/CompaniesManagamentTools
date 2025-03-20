package com.bca.cmt.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
    @Value("${api.cors.allowed-origins:http://localhost:8000}")
    private String allowedOrigins;
    @Value("${api.cors.allowed-methods:POST,PUT,GET,OPTIONS,DELETE,HEAD}")
    private String allowedMethods;
    @Value("${api.cors.allowed-headers:Authorization,Cache-Control,Content-Type}")
    private String allowedHeaders;
    @Value("${api.cors.exposed-headers:Access-Control-Allow-Headers,Authorization,x-xsrf-token,Access-Control-Allow-Headers,Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers}")
    private String exposedHeaders;
    @Value("${api.cors.max-age:3600}")
    private String maxAge;
    @Value("${api.cors.allow-credentials:true}")
    private String allowCredentials;

    private List<String> strToList(String stringList) {
        String[] splitStr = stringList.split(",");
        return Arrays.asList(splitStr);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedOrigins(strToList(allowedOrigins));
        configuration.setAllowedMethods(strToList(allowedMethods));
        configuration.setAllowedHeaders(strToList(allowedHeaders));
        configuration.setExposedHeaders(strToList(exposedHeaders));
        configuration.setMaxAge(Long.parseLong(maxAge));
        configuration.setAllowCredentials(Boolean.parseBoolean(allowCredentials));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}