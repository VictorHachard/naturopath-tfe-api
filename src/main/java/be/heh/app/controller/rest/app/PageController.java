package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.update.PageUpdateValidator;
import be.heh.app.dto.view.PageViewDto;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.User;
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

	@GetMapping("/dto/page/test/test")
	public User getAfllDto() {
		System.out.println(innerPageRepository.findById(45).get().getVoteList().get(0).getUser());
		System.out.println(innerPageRepository.findVote(45, userRepository.findById(1).get()));
		return innerPageRepository.findVote(45, userRepository.findById(1).get());
	}

	@GetMapping("/dto/page")
	public List<PageViewDto> getAllDto() {
		return pageService.getAllDto();
	}

	@GetMapping("/dto/page/{id}")
	public PageViewDto getDto(@PathVariable("id") int id) {
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
