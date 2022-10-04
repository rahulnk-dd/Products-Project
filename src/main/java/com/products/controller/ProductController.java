package com.products.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.products.entity.ProductEntity;
import com.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/products")
	public List<ProductEntity> list() {
		return service.listAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductEntity> get(@PathVariable Integer id) {
	    try {
	    	ProductEntity product = service.get(id);
	        return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<ProductEntity>(HttpStatus.NOT_FOUND);
	    }      
	}

	// RESTful API method for Create operation
	@PostMapping("/products")
	public ResponseEntity<ProductEntity> add(@RequestBody ProductEntity product) {
	    service.save(product);
	    System.out.println("Products:"+product);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	// RESTful API method for Update operation
	@PutMapping("/products/{id}")
	public ResponseEntity<ProductEntity> update(@RequestBody ProductEntity product, @PathVariable Integer id) {
	    try {
	    	ProductEntity existProduct = service.get(id);
	        service.save(product);
	        return ResponseEntity.status(HttpStatus.OK).body(product);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}
}
