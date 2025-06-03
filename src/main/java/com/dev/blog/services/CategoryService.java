package com.dev.blog.services;

import com.dev.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> listCategories();
    public Category createCategory(Category category);
}
