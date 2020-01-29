package com.example.project.service;

import java.util.List;
import java.util.Optional;
import com.example.project.domain.entities.Ordeer;
import com.example.project.exception.DataNotFoundException;
import com.example.project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Ordeer> list() {
        return orderRepository.findAll();
    }

    public Ordeer findById(Integer Id) {
        Optional<Ordeer> evento = orderRepository.findById(Id);
        return evento.orElseThrow(() -> new DataNotFoundException("Id Not found"));
    }
}