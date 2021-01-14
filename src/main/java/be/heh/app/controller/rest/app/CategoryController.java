package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.dto.CategoryDto;
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
	public List<CategoryDto> getAllDto() {
		return categoryService.getAllDto();
	}

	@GetMapping("/dto/category/{id}")
	public CategoryDto getDto(@PathVariable("id") int id) {
		return categoryService.getDto(id);
	}

	@PostMapping("/category")
	public void add(@Valid @RequestBody CategoryValidator categoryValidator) {
		categoryService.add(categoryValidator);
	}

	@PostMapping("/category/update/{id}")
	public void update(@Valid @RequestBody CategoryValidator categoryValidator, @PathVariable("id") int id) {
		categoryService.update(categoryValidator, id);
	}

}
