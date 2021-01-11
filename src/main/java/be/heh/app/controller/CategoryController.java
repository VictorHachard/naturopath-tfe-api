package be.heh.app.controller;

import be.heh.app.controller.services.CategoryService;
import be.heh.app.controller.validators.CategoryValidator;
import be.heh.app.model.entities.app.Category;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/category")
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable("id") int id) {
		return categoryService.getCategory(id);
	}

	@PostMapping("/category")
	public Category insertCategory(@Valid @RequestBody CategoryValidator categoryValidator) {
		return categoryService.insertCategory(categoryValidator);
	}

	@DeleteMapping("/category/{id}")
	public Category deleteCategory(@PathVariable("id") int id) {
		return categoryService.deleteCategory(id);
	}

}
