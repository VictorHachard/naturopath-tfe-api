package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.app.update.CategoryUpdateValidator;
import be.heh.app.dto.edit.CategoryEditDto;
import be.heh.app.dto.view.CategoryViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/category/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CategoryController extends AbstractController {

	@GetMapping("dto")
	public List<CategoryViewDto> getAllDto() {
		return categoryService.getAllDto();
	}

	@GetMapping("dto/allInAList")
	public List<CategoryViewDto> getAllInAList() {
		return categoryService.getAllInAList();
	}

	@GetMapping("dto/getAllParent")
	public List<CategoryViewDto> getAllParentDto() {
		return categoryService.getAllParentDto();
	}

	@GetMapping("dto/getAllChild")
	public List<CategoryViewDto> getAllChildDto() {
		return categoryService.getAllChildDto();
	}

	@GetMapping("dto/{id}")
	public CategoryViewDto getDto(@PathVariable("id") int id) {
		return categoryService.getDto(id);
	}

	@GetMapping("dto/edit")
	@PreAuthorize("hasRole('OWNER')")
	public List<CategoryEditDto> getAllEditDto() {
		return categoryService.getAllEditDto();
	}

	@GetMapping("dto/edit/{id}")
	@PreAuthorize("hasRole('OWNER')")
	public CategoryEditDto getEditDto(@PathVariable("id") int id) {
		return categoryService.getEditDto(id);
	}

	@PostMapping("")
	@PreAuthorize("hasRole('OWNER')")
	public int add(@Valid @RequestBody CategoryValidator validator) {
		return categoryService.addC(validator);
	}

	@PutMapping("update/{id}")
	@PreAuthorize("hasRole('OWNER')")
	public void update(@Valid @RequestBody CategoryUpdateValidator validator, @PathVariable("id") int id) {
		categoryService.update(validator, id);
	}

}
