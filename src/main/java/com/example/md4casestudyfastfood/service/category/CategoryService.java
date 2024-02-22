package com.example.md4casestudyfastfood.service.category;

import com.example.md4casestudyfastfood.model.Category;
import com.example.md4casestudyfastfood.model.dto.req.CategoryReqDto;
import com.example.md4casestudyfastfood.model.dto.res.CategoryResDto;
import com.example.md4casestudyfastfood.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;


    @Override
    public void save(CategoryReqDto CateReqDto) {
        Category category = new Category(CateReqDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryResDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(Category::toCategoryDto).collect(Collectors.toList());
    }
}
