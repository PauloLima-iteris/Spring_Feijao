package com.example.project.controller;

import java.io.FileNotFoundException;
import java.util.List;
import javax.validation.Valid;
import com.example.project.domain.dto.request.ProductRequest;
import com.example.project.domain.entities.Product;
import com.example.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PutMapping;

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

	@PutMapping(value = "/upload/{id}")
	public ResponseEntity<Product> upload(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
		String s = productService.upload(file, id);
		System.out.println(s);
		Product p = productService.putImagem(id, s);
		return ResponseEntity.ok(p);
	}

	@PutMapping(value = "/upload_Excel")
	public void criar() throws FileNotFoundException {
	productService.grava(productService.criar());
	}

}
