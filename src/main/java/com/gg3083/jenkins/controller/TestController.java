package com.gg3083.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GG
 * @date 2019/2/26 20:39
 */
@RestController
public class TestController {


    @GetMapping("/")
    public String test() {
        return "master";
    }

    @GetMapping("/get")
    public String get() {
        return "get";
    }
    
    @PostMapping("/post")
    public String post() {
        return "post";
    }
}
