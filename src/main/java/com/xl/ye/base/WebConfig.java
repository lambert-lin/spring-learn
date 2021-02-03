//package com.xl.ye.base;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.FilterChainProxy;
//
//
//@Configuration
//public class WebConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        System.out.println("web security ");
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                    .antMatchers().permitAll()
//                    .and()
//                .logout();
//
//
//
//    }
//}
