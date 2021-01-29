package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.dto.view.TagTypeViewDto;
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
public class TagTypeController extends AbstractController {

    @PostMapping("/tagType")
    public int add(@Valid @RequestBody GeneralTypeValidator validator) {
        return tagTypeService.addC(validator);
    }

    @PutMapping("/tagType/update/{id}")
    public void update(@Valid @RequestBody GeneralTypeValidator validator, @PathVariable("id") int id) {
        tagTypeService.update(validator, id);
    }

    @GetMapping("/dto/tagType")
    public List<TagTypeViewDto> getAllDto() {
        return tagTypeService.getAllDto();
    }

    @GetMapping("/dto/tagTypeHaveNotBeAssignedToAParatag")
    public List<TagTypeViewDto> getAllDtoHaveNotBeAssignedToAParatag() {
        return tagTypeService.getAllDtoHaveNotBeAssignedToAParatag();
    }

    @GetMapping("/dto/tagType/{id}")
    public TagTypeViewDto getDto(@PathVariable("id") int id) {
        return tagTypeService.getDto(id);
    }

}
