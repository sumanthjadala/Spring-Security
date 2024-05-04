package com.Sumanth.SpringSecurityPractice.Controllers;

import com.Sumanth.SpringSecurityPractice.Model.Customer;
import com.Sumanth.SpringSecurityPractice.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepo customerRepo;
    @PostMapping("/register")
    public String createCustomer(@RequestBody Customer customer){
        String encrptPwd=passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encrptPwd);
        customerRepo.save(customer);
        return "Registered Successfully";

    }
}
