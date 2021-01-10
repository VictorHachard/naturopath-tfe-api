package be.heh.app.controller;

import be.heh.app.controller.validators.AbstractController;
import be.heh.app.controller.validators.CategoryValidator;
import be.heh.app.mapper.CategoryMapper;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.repositories.CategoryRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CategoryController extends AbstractController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/category")
	public List<Category> getAllCategory() {
		this.getAll(categoryRepository, this.getClass().getSimpleName());
		return categoryRepository.findAll();
	}

	@PostMapping("/category")
	public Category insertCategory(@Valid @RequestBody CategoryValidator categoryValidator) {
		Category category = CategoryMapper.map(categoryValidator);
		categoryRepository.save(category);
		return category;
	}

}
