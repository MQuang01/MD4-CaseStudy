package com.example.md4casestudyfastfood.model.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResDto {
    private Long id;
    private String name;
    private String image;
    private String description;
    private double price;
    private Integer quantity;
    private CategoryResDto category;
}
