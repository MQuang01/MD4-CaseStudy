package com.example.md4casestudyfastfood.controller.restcontroller;


import com.example.md4casestudyfastfood.model.dto.req.CategoryReqDto;
import com.example.md4casestudyfastfood.service.category.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryRestController {
    private final ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CategoryReqDto categoryReqDto) {
        categoryService.save(categoryReqDto);
        return ResponseEntity.ok().build();
    }
}
