package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.PageSearchValidator;
import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.view.PagesByCategoryDtoValidator;
import be.heh.app.dto.edit.PageEditDto;
import be.heh.app.dto.view.PageByCategoryViewDto;
import be.heh.app.dto.view.PageSearchDto;
import be.heh.app.dto.view.PageViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/page/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class PageController extends AbstractController {

	@GetMapping("dto/{id}")
	public PageViewDto getDto(@PathVariable("id") int id) {
		return pageService.getDto(id);
	}

	@PostMapping("dto/search")
	public List<PageSearchDto> getSearchAllDto(@Valid @RequestBody PageSearchValidator pageSearchValidator) {
		return pageService.getSearchAllDto(pageSearchValidator.getSearch(), pageSearchValidator.getLimit());
	}

	@PostMapping("dto/search/exact")
	public List<PageSearchDto> getExactSearchAllDto(@Valid @RequestBody PageSearchValidator pageSearchValidator) {
		return pageService.getExactSearchAllDto(pageSearchValidator.getSearch(), pageSearchValidator.getLimit());
	}

	@PostMapping("dto/search/recommended")
	public List<PageSearchDto> getRecommendedSearchAllDto(@Valid @RequestBody PageSearchValidator pageSearchValidator) {
		return pageService.getRecommendedSearchAllDto(pageSearchValidator.getSearch(), pageSearchValidator.getLimit());
	}

	@GetMapping("dto/favorite")
	@PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
	public List<PageSearchDto> getFavoriteAllDto() {
		return pageService.getFavoriteAllDto();
	}

	@GetMapping("dto/edit/{id}")
	@PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
	public PageEditDto getEditDto(@PathVariable("id") int id) {
		return pageService.getEditDto(id);
	}

	@GetMapping("dto")
	public List<PageViewDto> getAllDto() {
		return pageService.getAllDto();
	}

	@GetMapping("dto/edit")
	public List<PageEditDto> getAllEditDto() {
		return pageService.getAllEditDto();
	}

	@PostMapping("dto/pageByCategory")
	public PageByCategoryViewDto getAllPageByCategoryDto(@Valid @RequestBody PagesByCategoryDtoValidator validator) {
		return pageService.getAllPageByCategoryDto(validator);
	}

	@PostMapping("")
	@PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
	public int add(@Valid @RequestBody PageValidator pageValidator) {
		return pageService.addC(pageValidator);
	}

}
