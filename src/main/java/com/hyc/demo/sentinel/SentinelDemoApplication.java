package com.hyc.demo.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/")
public class SentinelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelDemoApplication.class, args);
    }

    @RequestMapping
    public String greet() {
        return "Hello World";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, nice to meet you";
    }
}
