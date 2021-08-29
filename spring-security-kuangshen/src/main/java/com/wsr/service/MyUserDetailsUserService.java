package com.wsr.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

/**
 * @author ：wangsr
 * @description：
 * @date ：Created in 2021/8/27 0027 17:33
 */
@Component
public class MyUserDetailsUserService implements UserDetailsService {
    /**
     * 简单返回一个spring security提供的User对象。为了后面方便演示spring security的权限控制，这里设置了
     * user账号有一个admin的角色权限信息。实际项目中可以在这里通过访问数据库获取到用户及其角色、权限信息
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 不能直接使用 创建 BCryptPasswordEncoder 对象来加密， 这种加密方式 没有 {bcrypt}  前缀，
        // 会导致在  matches 时导致获取不到加密的算法出现
        // java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"  问题
        // 问题原因是 Spring Security5 使用 DelegatingPasswordEncoder(委托)  替代 NoOpPasswordEncoder，
        // 并且 默认使用  BCryptPasswordEncoder 加密（注意 DelegatingPasswordEncoder 委托加密方法BCryptPasswordEncoder  加密前  添加了加密类型的前缀）  https://blog.csdn.net/alinyua/article/details/80219500
        return new User("user",  PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
