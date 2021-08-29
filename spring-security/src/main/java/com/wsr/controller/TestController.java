package com.wsr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：wangsr
 * @description：
 * @date ：Created in 2021/8/27 0027 17:55
 */
@Controller
public class TestController {
    @GetMapping("/get_user/{username}")
    @ResponseBody
    public String getUser(@PathVariable String username){
        return username;
    }

//    @PostMapping("/loginUp")
    @PostMapping(value = "/loginUp", produces="application/json;charset=UTF-8")
    public String getUser( LoginParam param){
        return "loginSuccess";
    }

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
