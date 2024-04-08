package com.example.webserviceclient.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.example.webserviceclient.models",
        "com.example.webserviceclient.client",
        "com.example.webserviceclient.cli"
})
public class WebServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceClientApplication.class, args);
    }

}
