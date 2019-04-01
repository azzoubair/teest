package com.cgi.fic.api;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class FilterConfiguration {
	
    /**
     * Cors filter registration configuration
     * 
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {

        CorsFilter corsFilter = new CorsFilter((r) -> {
            CorsConfiguration config = new CorsConfiguration();
                config.setAllowCredentials(true);
                config.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
                config.setAllowedMethods(Arrays.asList("GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE", "PATCH"));
                config.setAllowedHeaders(
                        Arrays.asList(HttpHeaders.ACCEPT, HttpHeaders.ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.LAST_MODIFIED,
                                "X-Requested-With"));
            return config;
        });

        FilterRegistrationBean<CorsFilter> registration = new FilterRegistrationBean<CorsFilter>(corsFilter);
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }


}


