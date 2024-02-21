package com.example.md4casestudyfastfood.model;

import com.example.md4casestudyfastfood.model.dto.res.CategoryResDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
    public Category(String name){
        this.name = name;
    }

    public CategoryResDto toCategoryDto(){
        return new CategoryResDto(id, name);
    }
}
