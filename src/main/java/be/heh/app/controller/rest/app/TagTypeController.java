package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.dto.view.TagTypeViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/tagType/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagTypeController extends AbstractController {

    @PostMapping("")
    @PreAuthorize("hasRole('OWNER')")
    public int add(@Valid @RequestBody GeneralTypeValidator validator) {
        return tagTypeService.addC(validator);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER')")
    public void update(@Valid @RequestBody GeneralTypeValidator validator, @PathVariable("id") int id) {
        tagTypeService.update(validator, id);
    }

    @GetMapping("dto")
    @PreAuthorize("hasRole('USER')")
    public List<TagTypeViewDto> getAllDto() {
        return tagTypeService.getAllDto();
    }

    @GetMapping("dto/tagTypeHaveNotBeAssignedToAParatag")
    @PreAuthorize("hasRole('OWNER')")
    public List<TagTypeViewDto> getAllDtoHaveNotBeAssignedToAParatag() {
        return tagTypeService.getAllDtoHaveNotBeAssignedToAParatag();
    }

    @GetMapping("dto/{id}")
    @PreAuthorize("hasRole('USER')")
    public TagTypeViewDto getDto(@PathVariable("id") int id) {
        return tagTypeService.getDto(id);
    }

}
