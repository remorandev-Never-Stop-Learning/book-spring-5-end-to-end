package es.spring5.remoran.cms.domain.resources;

import es.spring5.remoran.cms.domain.model.Category;
import es.spring5.remoran.cms.domain.service.CategoryService;
import es.spring5.remoran.cms.domain.vo.CategoryRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Category>> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.categoryService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<Flux<Category>> findAll() {
        return ResponseEntity.ok(this.categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Mono<Category>> newCategory(@RequestBody CategoryRequest category) {
        return new ResponseEntity<>(this.categoryService.create(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCategory (@PathVariable("id") String id) {
        this.categoryService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, @RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }
}
