package com.Sumanth.SpringSecurityPractice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/contact")
    public String getContactDetails(){
        return "Contact details are 32975237";
    }
}
