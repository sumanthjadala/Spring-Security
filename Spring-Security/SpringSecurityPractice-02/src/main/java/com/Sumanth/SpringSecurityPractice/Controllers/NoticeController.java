package com.Sumanth.SpringSecurityPractice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @GetMapping("/notice")
    public String getNoticeDetails(){
        return "Welcome your notice details are this";
    }
}
