package be.heh.app.controller;

import be.heh.app.model.entities.app.Page;
import be.heh.app.model.repositories.PageRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class PageController {

	@Autowired
	PageRepository pageRepository;

	@GetMapping("/pages")
	public List<Page> getAllPages() {
		return pageRepository.findAll();
	}

	@GetMapping("/pages/{id}")
	public Page getPage(@PathVariable("id") int id) {
		return pageRepository.findById(id).isPresent() ? pageRepository.findById(id).get() : null;
	}

	@PostMapping("/pages")
	public Page getPage() {
		return null;
	}

}
