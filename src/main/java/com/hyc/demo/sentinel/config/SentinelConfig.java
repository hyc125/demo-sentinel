package com.hyc.demo.sentinel.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author hyc
 * @since 2022/4/29
 */
@Configuration
public class SentinelConfig {
    
    /** 配置Servlet Filter,首次访问url时,会把对应url当做资源注册到sentinel控制台 */
    @Bean
    public FilterRegistrationBean<Filter> sentinelFilterRegistration() {
        setUrlBlocker();

        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sentinelFilter");
        registration.setOrder(1);
        return registration;
    }

    private void setUrlBlocker(){
        WebCallbackManager.setUrlBlockHandler((req, resp, ex) -> {
            resp.setContentType("application/json;charset=UTF-8");
            resp.setStatus(200);
            resp.getWriter().write("{\"code\":\"-1\",\"msg\":\"资源不可用\"}");
        });
    }

}
