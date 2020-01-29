package com.example.project.service;

import java.util.List;
import java.util.Optional;

import com.example.project.domain.entities.Customer;
import com.example.project.exception.DataNotFoundException;
import com.example.project.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> list() {
        return customerRepository.findAll();
    }

    public Customer findById(Integer Id) {
        Optional<Customer> evento = customerRepository.findById(Id);
        return evento.orElseThrow(() -> new DataNotFoundException("Id Not found"));
    }
}