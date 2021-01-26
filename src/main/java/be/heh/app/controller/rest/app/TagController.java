package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.TagValidator;
import be.heh.app.dto.edit.TagEditDto;
import be.heh.app.dto.view.TagViewDto;
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
public class TagController extends AbstractController {

    @GetMapping("/dto/tag")
    public List<TagViewDto> getAllDto() {
        return tagService.getAllDto();
    }

    @GetMapping("/dto/tag/{id}")
    public TagViewDto getDto(@PathVariable("id") int id) {
        return tagService.getDto(id);
    }

    @GetMapping("/dto/edit/tag")
    public List<TagEditDto> getAllEditDto() {
        return tagService.getAllEditDto();
    }

    @GetMapping("/dto/edit/tag/{id}")
    public TagEditDto getEditDto(@PathVariable("id") int id) {
        return tagService.getEditDto(id);
    }

    @PostMapping("/tag")
    public int add(@Valid @RequestBody TagValidator tagValidator) {
        return tagService.addC(tagValidator);
    }

}
