package com.thiagobrito.authenticationapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagobrito.authenticationapi.domain.product.Product;
import com.thiagobrito.authenticationapi.domain.product.ProductRequestDTO;
import com.thiagobrito.authenticationapi.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok().body(productService.findProduct(id));
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody @Valid ProductRequestDTO data) {
        return new ResponseEntity<>(productService.saveProduct(data), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> putProduct(@PathVariable(name = "id") String id,
            @RequestBody @Valid ProductRequestDTO data) {
        return ResponseEntity.ok().body(productService.updateProduct(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}