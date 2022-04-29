package com.hyc.demo.demosentinel;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Filter;

@SpringBootApplication
@RestController("/")
public class DemoSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSentinelApplication.class, args);
    }

    @RequestMapping
    public String greet() {
        return "Hello World";
    }

    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sentinelFilter");
        registration.setOrder(1);
        return registration;
    }
}
