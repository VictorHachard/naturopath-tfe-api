package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.ParagraphTypeValidator;
import be.heh.app.dto.view.ParapageTypeViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/parapageType/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParapageTypeController extends AbstractController {

    @PostMapping("")
    @PreAuthorize("hasRole('OWNER')")
    public int add(@Valid @RequestBody ParagraphTypeValidator validator) {
        return parapageTypeService.addC(validator);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER')")
    public void update(@Valid @RequestBody ParagraphTypeValidator validator, @PathVariable("id") int id) {
        parapageTypeService.update(validator, id);
    }

    @GetMapping("dto")
    @PreAuthorize("hasRole('OWNER')")
    public List<ParapageTypeViewDto> getAllDto() {
        return parapageTypeService.getAllDto();
    }

    @GetMapping("dto/{id}")
    @PreAuthorize("hasRole('OWNER')")
    public ParapageTypeViewDto getDto(@PathVariable("id") int id) {
        return parapageTypeService.getDto(id);
    }

}
