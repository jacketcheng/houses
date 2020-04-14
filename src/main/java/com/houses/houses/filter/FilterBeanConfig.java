package com.houses.houses.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterBeanConfig {

    /**
     * 1.构造Filter
     * 2.配置拦截urlPattern
     * 3.利用FilterRegistrationBean进行包装
     * @return
     */
    @Bean
    public FilterRegistrationBean logFilter(){

    }

}
