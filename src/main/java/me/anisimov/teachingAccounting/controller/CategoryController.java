package me.anisimov.teachingAccounting.controller;

import io.swagger.annotations.Api;
import me.anisimov.teachingAccounting.domain.Category;
import me.anisimov.teachingAccounting.dto.CategoryDto;
import me.anisimov.teachingAccounting.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(value = "CategoryController",tags = {"Методы для работы с категориями"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public CategoryDto create(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Category category){
        categoryService.updateCategory(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Category getById(Long id){
        return categoryService.getById(id);
    }

    @GetMapping()
    public List<Category> getAll(){
        return categoryService.getAll();
    }
}
