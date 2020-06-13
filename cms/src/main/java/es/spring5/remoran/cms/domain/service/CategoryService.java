package es.spring5.remoran.cms.domain.service;

import es.spring5.remoran.cms.domain.exception.CategoryNotFoundException;
import es.spring5.remoran.cms.domain.model.Category;
import es.spring5.remoran.cms.domain.repository.CategoryRepository;
import es.spring5.remoran.cms.domain.vo.CategoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category update(Category category) {
        return this.categoryRepository.save(category);
    }

    @Transactional
    public Category create(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    @Transactional
    public void delete(String id) {
        final Optional<Category> categoryOpt = this.categoryRepository.findById(id);
        categoryOpt.ifPresent(this.categoryRepository::delete);
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public List<Category> findByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    public List<Category> findByNameStartingWith(String name) {
        return this.categoryRepository.findByNameIgnoreCaseStartingWith(name);
    }

    public Category findOne(String id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryNotFoundException(id);
        }
    }
}
