package com.example.md4casestudyfastfood.service.product;

import com.example.md4casestudyfastfood.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
}
