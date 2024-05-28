package com.neobis.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello, Admin!";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "Hello, User!";
    }

}
