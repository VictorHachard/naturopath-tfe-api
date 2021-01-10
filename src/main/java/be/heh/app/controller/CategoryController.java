package be.heh.app.controller;

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
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/category")
	public List<Category> getAllCategory() {
		if (categoryRepository.findAll().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category in the database");
		} else {
			return categoryRepository.findAll();
		}
	}

	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable("id") int id) {
		if (categoryRepository.findById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
		} else {
			return categoryRepository.findById(id).get();
		}
	}

	@PostMapping("/category")
	public Category insertCategory(@Valid @RequestBody CategoryValidator categoryValidator) {
		Category category = CategoryMapper.map(categoryValidator);
		categoryRepository.save(category);
		return category;
	}

	@DeleteMapping("/category/{id}")
	public Category deleteCategory(@PathVariable("id") int id) {
		//TODO delete link
		if (categoryRepository.findById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
		} else {
			Category category = categoryRepository.findById(id).get();
			categoryRepository.delete(category);
			return category;
		}
	}

}
