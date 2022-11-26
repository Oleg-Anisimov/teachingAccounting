package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Category;
import me.anisimov.teachingAccounting.dto.CategoryDto;
import me.anisimov.teachingAccounting.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;

    public CategoryDto createCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return mapper.map(category, CategoryDto.class);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getById(Long id) {
        return categoryRepository.getReferenceById(id);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
