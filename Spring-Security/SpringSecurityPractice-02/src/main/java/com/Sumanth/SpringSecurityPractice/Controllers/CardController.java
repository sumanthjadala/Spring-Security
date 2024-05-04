package com.Sumanth.SpringSecurityPractice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/card")
    public String getCardDetails(){
        return "Welcome your card details are this";
    }

}
