package be.heh.app.controller.app;

import be.heh.app.controller.services.PageService;
import be.heh.app.controller.validators.PageValidator;
import be.heh.app.dto.PageDto;
import be.heh.app.model.entities.app.Page;
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
public class PageController {

	@Autowired
	PageService pageService;

	@GetMapping("/page")
	public List<Page> getAllPage() {
		return pageService.getAllPage();
	}

	@GetMapping("/page/{id}")
	public Page getPage(@PathVariable("id") int id) {
		return pageService.getPage(id);
	}

	@PostMapping("/page")
	public PageDto insertPage(@Valid @RequestBody PageValidator pageValidator) {
		Page p = pageService.insertPage(pageValidator);
		return new PageDto(p,"Bien crée");
	}

	@DeleteMapping("/page/{id}")
	public Page deletePage(@PathVariable("id") int id) {
		return pageService.deletePage(id);
	}

}
