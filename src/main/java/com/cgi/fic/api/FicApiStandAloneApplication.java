package com.cgi.fic.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FilterConfiguration.class)
public class FicApiStandAloneApplication extends SpringBootServletInitializer {
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FicApiStandAloneApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(FicApiStandAloneApplication.class, args);
	}
}


