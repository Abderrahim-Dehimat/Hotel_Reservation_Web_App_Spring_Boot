package com.webservice1.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
        "com.webservice1.models"
})
@EnableJpaRepositories(basePackages  = {
        "com.webservice1.repositories"
})
@SpringBootApplication(scanBasePackages = {
        "com.webservice1.data",
        "com.webservice1.controllers"
})
public class WebService1Application {

    public static void main(String[] args) {
        SpringApplication.run(WebService1Application.class, args);
    }

}
