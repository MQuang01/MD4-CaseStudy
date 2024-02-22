package com.example.md4casestudyfastfood.service.category;

import com.example.md4casestudyfastfood.model.dto.req.CategoryReqDto;
import com.example.md4casestudyfastfood.model.dto.res.CategoryResDto;

import java.util.List;

public interface ICategoryService {
    void save(CategoryReqDto reqDto);

    List<CategoryResDto> findAll();
}
