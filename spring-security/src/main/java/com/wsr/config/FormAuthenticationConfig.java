package com.wsr.config;

import com.wsr.handler.CustomAuthenticationFailureHandler;
import com.wsr.handler.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * @author ：wangsr
 * @description： SpringSecurityConfig中调用此处方法
 * @date ：Created in 2021/8/27 0027 18:34
 */
@Component
public class FormAuthenticationConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 可以设置自定义的登录页面 或者登录接口
                // 注意1：一般来说设置成登录接口后，该接口会配置成无权限即可访问，所以会走匿名filter，也就意味着不会走认证过程了，所以我们一般不会设置成接口地址
                // 注意2：这里配置的 地址一定要配置成有权限访问 否则将出现一直重定向问题 因为无权限访问后又会重定向到这里配置的登录页
                .loginPage(securityProperties.getLogin().getLoginPage())
                // .loginPage("/loginRequire")
                // 指定验证凭据的URL（默认为/login）
                // 注意1：这里修改后的 url 会意味着  UsernamePasswordAuthenticationFilter 将 验证此处的 url
                // 注意2： 与 loginPage设置的接口地址是有 区别, 一但 loginPage 设置了的是访问接口url，那么此处配置将无任何意义
                // 注意3： 这里设置的 Url 是默认有权限访问的
                // 这里修改后的 url 会意味着 UsernamePasswordAuthenticationFilter 将 验证此处的 url
                .loginProcessingUrl(securityProperties.getLogin().getLoginUrl())
                // 分别设置成功和失败的处理器
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler);
    }
}
