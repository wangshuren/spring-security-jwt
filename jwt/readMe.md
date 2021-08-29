SpringBoot + SpringSecurity+jwt


建议工程创建流程
创建 JwtTokenUtils
创建 jwtAccessDeniedHandler 和 JwtAuthenticationEntryPoint
创建 UserDetailsServiceImpl
创建 JwtAuthenticationFilter
配置 Security信息
启动类的信息

配置了权限校验

/test接口没有在SecurityConfig中配置
所有需要校验token

如果加上权限校验，还需要相应的权限







————————————————
版权声明：本文为CSDN博主「南归客_Kdream」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_38579100/article/details/108655008
