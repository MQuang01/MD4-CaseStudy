package com.example.md4casestudyfastfood.model.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountResDto {
    private Long id;
    private String name;
    private double value;
    private String description;

}
