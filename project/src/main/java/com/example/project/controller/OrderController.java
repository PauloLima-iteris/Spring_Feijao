package com.example.project.controller;

import java.util.List;
import com.example.project.domain.entities.Ordeer;
import com.example.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordeer")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/list")
	public ResponseEntity<List<Ordeer>> list() {
		return ResponseEntity.ok(orderService.list());
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<Ordeer> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(orderService.findById(id));
    }
}