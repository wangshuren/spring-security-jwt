package com.wsr.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：wangsr
 * @description：
 * @date ：Created in 2021/8/28 0028 11:42
 */

@Data
@ConfigurationProperties(prefix = "wsr.security.authentication")
public class LoginProperties {
    private String loginPage;

    private String loginUrl;

    private String loginSuccessUrl;

    private String loginErrorUrl;
}
