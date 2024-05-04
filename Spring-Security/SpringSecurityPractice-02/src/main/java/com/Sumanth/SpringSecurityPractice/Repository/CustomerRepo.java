package com.Sumanth.SpringSecurityPractice.Repository;

import com.Sumanth.SpringSecurityPractice.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    List<Customer> findByEmail(String email);
}
