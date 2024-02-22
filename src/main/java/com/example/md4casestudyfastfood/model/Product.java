package com.example.md4casestudyfastfood.model;

import com.example.md4casestudyfastfood.model.dto.res.ProductResDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String description;
    private double price;
    private Integer quantity;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Discount> discounts = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    public Product(String name, String image, String description, double price, Integer quantity, Category category){
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public ProductResDto toProductResDto(){
        return new ProductResDto(id, name, image, description, price, quantity, category.toCategoryDto());
    }
}
