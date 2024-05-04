package com.Sumanth.SpringSecurityPractice.CustomConfigurations;

import com.Sumanth.SpringSecurityPractice.Model.Customer;
import com.Sumanth.SpringSecurityPractice.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerUserdatilsManager implements UserDetailsService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String name=null;
        String password=null;
        List<GrantedAuthority> authorities;
        List<Customer> customers=customerRepo.findByEmail(username);
        if(customers.size()>0){
            name=customers.get(0).getEmail();
            password=customers.get(0).getPassword();
            authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));

        }else{
            throw new UsernameNotFoundException("User doesn't exist with email "+ username);
        }
        return new User(name,password,authorities);
     }
}
