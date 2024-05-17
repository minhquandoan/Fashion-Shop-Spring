package com.minhquan.product.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhquan.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}
