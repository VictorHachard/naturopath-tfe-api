package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.update.PageUpdateValidator;
import be.heh.app.controller.validators.app.view.PagesByCategoryDtoValidator;
import be.heh.app.dto.view.PageByCategoryViewDto;
import be.heh.app.dto.view.PageViewDto;
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
public class PageController extends AbstractController {

	@GetMapping("/dto/page/{id}")
	public PageViewDto getDto(@PathVariable("id") int id) {
		return pageService.getDto(id);
	}

	@GetMapping("/dto/page")
	public List<PageViewDto> getAllDto() {
		return pageService.getAllDto();
	}

	@PostMapping("/dto/pageByCategory")
	public List<PageByCategoryViewDto> getAllPageByCategoryDto(@Valid @RequestBody PagesByCategoryDtoValidator validator) {
		return pageService.getAllPageByCategoryDto(validator);
	}

	@PostMapping("/page")
	public void add(@Valid @RequestBody PageValidator pageValidator) {
		pageService.add(pageValidator);
	}

	@PostMapping("/page/update/{id}")
	public void update(@Valid @RequestBody PageUpdateValidator validator, @PathVariable("id") int id) {
		pageService.update(validator, id);
	}

}
