package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.TagValidator;
import be.heh.app.dto.edit.ImageEditDto;
import be.heh.app.dto.edit.TagEditDto;
import be.heh.app.dto.view.TagByTagTypeViewDto;
import be.heh.app.dto.view.TagViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/tag/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagController extends AbstractController {

    @GetMapping("dto")
    public List<TagViewDto> getAllDto() {
        return tagService.getAllDto();
    }

    @GetMapping("dto/user")
    public List<TagEditDto> getAllUserDto() {
        return tagService.getAllUserDto();
    }

    @GetMapping("dto/{id}")
    public TagViewDto getDto(@PathVariable("id") int id) {
        return tagService.getDto(id);
    }

    @GetMapping("dto/edit")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public List<TagEditDto> getAllEditDto() {
        return tagService.getAllEditDto();
    }

    @GetMapping("dto/edit/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public TagEditDto getEditDto(@PathVariable("id") int id) {
        return tagService.getEditDto(id);
    }

    @GetMapping("allTagByTagType/dto/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public List<TagByTagTypeViewDto> getAllTagByTagTypeDto(@PathVariable("id") int id) {
        return tagService.getAllTagByTagTypeDto(id);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public int add(@Valid @RequestBody TagValidator tagValidator) {
        return tagService.addC(tagValidator);
    }

}
