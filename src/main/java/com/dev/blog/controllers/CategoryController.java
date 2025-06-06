package com.dev.blog.controllers;

import com.dev.blog.domain.dtos.CategoryDto;
import com.dev.blog.domain.dtos.CreateCategoryRequest;
import com.dev.blog.domain.entities.Category;
import com.dev.blog.mappers.CategoryMapper;
import com.dev.blog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.listCategories()
                .stream().map(categoryMapper::toCategoryDto)
                .toList();
                return ResponseEntity.ok(categories);


    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @Valid @RequestBody CreateCategoryRequest createCategoryRequest) {

        Category categoryToCreate =  categoryMapper.toEntity(createCategoryRequest);
        Category savedCategory = categoryService.createCategory(categoryToCreate);
        return new ResponseEntity<>(categoryMapper.toCategoryDto(savedCategory), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "{id}")

    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
