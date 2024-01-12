package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Category;
import com.mycompany.myapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public Category readById(Long id) {
        return repository.findById(id).get();
    }

    public List<Category> readAll() {
        Iterable<Category> allCategory = repository.findAll();
        List<Category> categoryList = new ArrayList<>();
        allCategory.forEach(categoryList::add);
        return categoryList;
    }

    public Category update(Long id, Category newCategoryData) {
        Category categoryInDatabase = this.readById(id);
        categoryInDatabase.setId(newCategoryData.getId());
        categoryInDatabase.setCategoryName(newCategoryData.getCategoryName());
        categoryInDatabase.setVideos(newCategoryData.getVideos());
        categoryInDatabase = repository.save(categoryInDatabase);
        return categoryInDatabase;
    }

    public Category deleteById(Long id) {
        Category categoryToBeDeleted = this.readById(id);
        repository.delete(categoryToBeDeleted);
        return categoryToBeDeleted;
    }
}
