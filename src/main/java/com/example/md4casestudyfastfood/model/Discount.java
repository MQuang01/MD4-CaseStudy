package com.example.md4casestudyfastfood.model;

import com.example.md4casestudyfastfood.model.dto.res.DiscountResDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private double value;
    private String description;

    @ManyToOne
    private Product product;

    public DiscountResDto toDiscountResDto(){
        return new DiscountResDto(id, code, value, description);
    }

}
