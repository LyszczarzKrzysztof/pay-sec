package com.example.paysec;

import org.aspectj.lang.annotation.Before;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.swing.*;

@SpringBootApplication
public class PaySecApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaySecApplication.class, args);
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver mulitpartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        commonsMultipartResolver.setMaxUploadSizePerFile(400000002);
        return commonsMultipartResolver;
    }

}
