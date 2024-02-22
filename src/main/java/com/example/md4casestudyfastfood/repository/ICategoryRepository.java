package com.example.md4casestudyfastfood.repository;

import com.example.md4casestudyfastfood.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
