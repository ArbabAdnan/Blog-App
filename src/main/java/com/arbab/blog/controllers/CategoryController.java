package com.arbab.blog.controllers;

import com.arbab.blog.payloads.ApiResponse;
import com.arbab.blog.payloads.CategoryDto;
import com.arbab.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto)
    {
        CategoryDto category = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId)
    {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId)
    {
       this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new  ApiResponse("Category is deleted Successfully",true), HttpStatus.OK);
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId)
    {
        CategoryDto categoryById = this.categoryService.getCategoryById(categoryId);

        return new ResponseEntity<CategoryDto>(categoryById,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory()
    {
        List<CategoryDto> allCategories = this.categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }


}
