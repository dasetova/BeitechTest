package com.dasetova.beitech_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.dasetova.beitech_test.configuration.JpaConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.dasetova.beitech_test"})
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
    @Bean
    @Primary
    public ObjectMapper jacksonBuilder() {
        return new ObjectMapper()
			.registerModule(new ParameterNamesModule())
			.registerModule(new Jdk8Module())
			.registerModule(new JavaTimeModule()); 
    }

}
