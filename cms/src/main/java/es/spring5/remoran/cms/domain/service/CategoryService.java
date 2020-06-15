package es.spring5.remoran.cms.domain.service;

import es.spring5.remoran.cms.domain.model.Category;
import es.spring5.remoran.cms.domain.repository.CategoryRepository;
import es.spring5.remoran.cms.domain.vo.CategoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Mono<Category> update(Category category) {
        return this.categoryRepository.save(category);
    }

    @Transactional
    public Mono<Category> create(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    @Transactional
    public void delete(String id) {
        this.categoryRepository.deleteById(id);
    }

    public Flux<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Mono<Category> findOne(String id) {
        return this.categoryRepository.findById(id);
    }
}
