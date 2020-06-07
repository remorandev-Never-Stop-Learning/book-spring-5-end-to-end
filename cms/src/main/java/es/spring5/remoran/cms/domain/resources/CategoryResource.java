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

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Api(tags = "category", description = "Catagory API")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find category",  notes = "Find the Category by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 400, message = "Category not found")
    })
    public ResponseEntity<Category> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.categoryService.findOne(id));
    }

    @GetMapping
    @ApiOperation(value = "List categories", notes = "List all categories")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Categories found"),
            @ApiResponse(code = 400, message = "Categories not found")
    })
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(this.categoryService.findAll());
    }

    @PostMapping
    @ApiOperation(value = "Create category", notes = "It permits to create a new category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category created successfully"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Category> newCategory(@RequestBody CategoryRequest category) {
        return new ResponseEntity<>(this.categoryService.create(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove category", notes = "It permit to update a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category remove"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public void removeCategory (@PathVariable("id") String id) {
        this.categoryService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update category", notes = "It permit to update a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category update"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, @RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }
}
