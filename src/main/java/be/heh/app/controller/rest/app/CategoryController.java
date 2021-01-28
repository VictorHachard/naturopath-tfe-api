package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.app.update.CategoryUpdateValidator;
import be.heh.app.dto.edit.CategoryEditDto;
import be.heh.app.dto.view.CategoryViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CategoryController extends AbstractController {

	@GetMapping("/dto/category")
	public List<CategoryViewDto> getAllDto() {
		return categoryService.getAllDto();
	}

	@GetMapping("/dto/getAllParent")
	public List<CategoryViewDto> getAllParentDto() {
		return categoryService.getAllParentDto();
	}

	@GetMapping("/dto/category/{id}")
	public CategoryViewDto getDto(@PathVariable("id") int id) {
		return categoryService.getDto(id);
	}

	@GetMapping("/dto/edit/category")
	public List<CategoryEditDto> getAllEditDto() {
		return categoryService.getAllEditDto();
	}

	@GetMapping("/dto/edit/category/{id}")
	public CategoryEditDto getEditDto(@PathVariable("id") int id) {
		return categoryService.getEditDto(id);
	}

	@PostMapping("/category")
	public int add(@Valid @RequestBody CategoryValidator categoryValidator) {
		return categoryService.addC(categoryValidator);
	}

	@PostMapping("/category/update/{id}")
	public void update(@Valid @RequestBody CategoryUpdateValidator validator, @PathVariable("id") int id) {
		categoryService.update(validator, id);
	}

}
