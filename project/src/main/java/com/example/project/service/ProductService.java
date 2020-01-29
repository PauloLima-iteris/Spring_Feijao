package com.example.project.service;

import java.util.List;
import java.util.Optional;

import com.example.project.domain.entities.Product;
import com.example.project.exception.DataNotFoundException;
import com.example.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product findById(Integer Id) {
        Optional<Product> evento = productRepository.findById(Id);
        return evento.orElseThrow(() -> new DataNotFoundException("Id Not found"));
    }

    
}