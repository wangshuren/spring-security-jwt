package com.wsr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ：wangsr
 * @description：@EnableWebSecurity引用了WebSecurityConfiguration配置类和@EnableGlobalAuthentication注解
 * 其中WebSecurityConfiguration就是授权相关的配置   @EnableGlobalAuthentication配置了认证相关的
 * @date ：Created in 2021/8/27 0027 17:48
 */
@Configuration
@EnableWebSecurity // 开启Security功能
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        formAuthenticationConfig.configure(http);

        // 最基础版本
        http.formLogin()  // 使用表单登录（默认请求地址为/login），在spring security5里其实已经将旧版本默认的httpBasic更换成fromLogin了，这里为了表明表单登录还是配置了一次
                .and()
                .authorizeRequests() // 开始请求权限配置
                .antMatchers("/", "/loginUp","/index2.html","/loginError.html").permitAll() // 使用Ant风格的路径匹配，这里配置匹配 / 和 /index
                .anyRequest().authenticated() // 用户登录后可访问
                .and().csrf().disable();


    }
}
