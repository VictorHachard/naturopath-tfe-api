package be.heh.app.controller;

import be.heh.app.controller.validators.PageValidator;
import be.heh.app.mapper.PageMapper;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.repositories.CategoryRepository;
import be.heh.app.model.repositories.PageRepository;
import be.heh.app.model.repositories.UserRepository;
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
public class PageController {

	@Autowired
	PageRepository pageRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/page")
	public List<Page> getAllPage() {
		if (pageRepository.findAll().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page in the database");
		} else {
			return pageRepository.findAll();
		}
	}

	@GetMapping("/page/{id}")
	public Page getPage(@PathVariable("id") int id) {
		if (!pageRepository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this pageId");
		} else {
			return pageRepository.findById(id).get();
		}
	}

	@PostMapping("/page")
	public Page insertPage(@Valid @RequestBody PageValidator pageValidator) {
		if (!categoryRepository.findById(pageValidator.getCategoryId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
		} else if (!userRepository.findById(pageValidator.getUserId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
		} else {
			Page page = PageMapper.map(pageValidator, categoryRepository.findById(pageValidator.getCategoryId()).get(), userRepository.findById(pageValidator.getUserId()).get());
			pageRepository.save(page);
			return page;
		}
	}

	@DeleteMapping("/page/{id}")
	public Page deletePage(@PathVariable("id") int id) {
		//TODO delete link
		if (!pageRepository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this pageId");
		} else {
			Page page = pageRepository.findById(id).get();
			pageRepository.delete(page);
			return page;
		}
	}

}
