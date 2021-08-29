package com.wsr.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author ：wangsr
 * @description：
 * @date ：Created in 2021/8/28 0028 9:50
 */

@Data
@Configuration
@EnableConfigurationProperties({LoginProperties.class})
public class SecurityProperties {
    @Autowired
    private LoginProperties login;

}
