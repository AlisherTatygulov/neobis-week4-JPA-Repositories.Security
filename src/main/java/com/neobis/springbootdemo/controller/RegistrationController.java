package com.neobis.springbootdemo.controller;

import com.neobis.springbootdemo.entity.User;
import com.neobis.springbootdemo.sevice.CustomUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class RegistrationController {

    @Autowired
    private CustomUserDetailsService userService;

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword) {
        if (password.equals(confirmPassword)) {
            User newUser = new User(username, password);
                userService.saveUser(newUser);
            return "redirect:/login?registered";
        } else {
            return "redirect:/register?error";
        }
    }
}