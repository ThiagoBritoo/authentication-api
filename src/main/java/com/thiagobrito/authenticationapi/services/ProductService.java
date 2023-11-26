package com.thiagobrito.authenticationapi.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.thiagobrito.authenticationapi.domain.product.Product;
import com.thiagobrito.authenticationapi.domain.product.ProductRequestDTO;
import com.thiagobrito.authenticationapi.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findProduct(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }

    public Product saveProduct(ProductRequestDTO data) {
        var newProduct = new Product(data);
        return repository.save(newProduct);
    }

    public void deleteProduct(String id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
        repository.deleteById(id);
    }

    public Product updateProduct(String id, ProductRequestDTO data) {
        Product prod = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
        var updProduct = new Product(data);
        updProduct.setId(prod.getId());
        return repository.save(updProduct);
    }
}