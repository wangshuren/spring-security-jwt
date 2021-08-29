package com.wsr.controller;

import com.wsr.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：wangsr
 * @description：
 * @date ：Created in 2021/8/28 0028 23:58
 */
@RestController
public class JwtController {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @GetMapping("/")
    public String index(){
        return "security jwt";
    }

    @PostMapping("/login")
    public String login(@RequestParam String u, @RequestParam String p){
        // 登陆验证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(u, p);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //创建jwt信息
        String token1 = JwtTokenUtils.createToken(u,"bxsheng", true);
        return token1;
    }

    @GetMapping("/role")
    @PreAuthorize("hasAnyAuthority('bxsheng')")
    public String roleInfo(){
        return "需要获得bxsheng权限，才可以访问";
    }

    @GetMapping("/roles")
    @PreAuthorize("hasAnyAuthority('kdream')")
    public String rolekdream(){
        return "需要获得kdream权限，才可以访问";
    }

    @GetMapping("/test")
    public String roleInfos(){
        return "roleInfos";
    }
}
