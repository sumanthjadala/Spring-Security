package com.Sumanth.SpringSecurityPractice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/account")
    public String getAccountDetails(){
        return "Welcome your Account details are this";
    }
}
