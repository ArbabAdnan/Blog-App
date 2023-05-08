package com.arbab.blog.services;

import com.arbab.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
     CategoryDto createCategory(CategoryDto categoryDto);
    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    //delete
    void deleteCategory(Integer categoryId);

    //get single user
    CategoryDto getCategoryById(Integer categoryId);

    //get all user
    List<CategoryDto> getAllCategories();
}
