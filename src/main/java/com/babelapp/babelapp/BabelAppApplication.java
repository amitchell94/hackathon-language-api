package com.babelapp.babelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BabelAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BabelAppApplication.class, args);
    }

}

