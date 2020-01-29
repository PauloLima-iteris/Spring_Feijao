package com.example.project.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.project.domain.dto.request.ProductRequest;
import com.example.project.domain.entities.Product;
import com.example.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/list")
	public ResponseEntity<List<Product>> list() {
		return ResponseEntity.ok(productService.list());
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
         return ResponseEntity.ok(productService.findById(id));
	}

	// @PostMapping(value = "/upload")
	// public void upload(@RequestParam MultipartFile imagem){
	// 	productService.salvarFoto(imagem);
	// }

}
