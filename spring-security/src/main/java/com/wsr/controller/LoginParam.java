package com.wsr.controller;

import lombok.Data;

/**
 * @author ：wangsr
 * @description：
 * @date ：Created in 2021/8/28 0028 13:49
 */
@Data
public class LoginParam {

    private String username;

    private String password;

    private String rememberMe;
}
