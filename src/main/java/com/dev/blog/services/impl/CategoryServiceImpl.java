package com.dev.blog.services.impl;

import com.dev.blog.domain.entities.Category;
import com.dev.blog.repositories.CategoryRepository;
import com.dev.blog.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        if (categoryRepository.existsByNameIgnoreCase(category.getName()) ){
            throw new IllegalArgumentException(" category already exist");
        }else {
            return categoryRepository.save(category);
        }

    }


}
