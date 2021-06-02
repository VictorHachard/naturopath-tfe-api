package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.app.LikeValidator;
import be.heh.app.controller.validators.app.update.CategoryUpdateValidator;
import be.heh.app.controller.validators.app.update.LikeUpdateValidator;
import be.heh.app.dto.edit.CategoryEditDto;
import be.heh.app.dto.view.CategoryViewDto;
import be.heh.app.dto.view.LikeViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/like/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class LikeController extends AbstractController {

	@GetMapping("dto/{pageId}")
	@PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
	public LikeViewDto getDto(@PathVariable("pageId") int pageId) {
		return likeService.getDto(pageId);
	}

	@PostMapping("")
	@PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
	public void add(@Valid @RequestBody LikeValidator validator) {
		likeService.addC(validator);
	}

	@PutMapping("update/{id}")
	@PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
	public void update(@Valid @RequestBody LikeUpdateValidator validator, @PathVariable("id") int id) {
		likeService.update(validator, id);
	}

}
