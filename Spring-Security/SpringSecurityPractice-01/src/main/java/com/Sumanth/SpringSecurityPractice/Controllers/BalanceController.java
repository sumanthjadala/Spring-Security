package com.Sumanth.SpringSecurityPractice.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/balance")
    public String getBalanceDetails(){
        return "Welcome your Balance details are this";
    }
}
