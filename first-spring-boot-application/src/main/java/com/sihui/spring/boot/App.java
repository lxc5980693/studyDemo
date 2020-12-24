package com.sihui.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@SpringBootApplication
@RestController
public class App {

    @RequestMapping("/")
    public String index() {
        return "Welcome My baby!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
