package com.thiagobrito.authenticationapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagobrito.authenticationapi.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, String> {    
}
