package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.PageUpdateValidator;
import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.dto.PageDto;
import be.heh.app.model.entities.app.Page;
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

	@GetMapping("/dto/page")
	public List<PageDto> getAllDto() {
		return pageService.getAllDto();
	}

	@GetMapping("/dto/page/{id}")
	public PageDto getDto(@PathVariable("id") int id) {
		return pageService.getDto(id);
	}

	@PostMapping("/page")
	public void add(@Valid @RequestBody PageValidator pageValidator) {
		pageService.add(pageValidator);
	}

	@PostMapping("/page/update/{id}")
	public Page update(@Valid @RequestBody PageUpdateValidator pageUpdateValidator, @PathVariable("id") int id) {
		return pageService.updatePage(pageUpdateValidator, id);
	}

}
