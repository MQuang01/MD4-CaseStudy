package com.example.md4casestudyfastfood.repository;

import com.example.md4casestudyfastfood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
