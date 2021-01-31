package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.ParatagTypeValidator;
import be.heh.app.dto.view.ParatagTypeViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/paratagType/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParatagTypeController extends AbstractController {

    @PostMapping("")
    @PreAuthorize("hasRole('OWNER')")
    public int add(@Valid @RequestBody ParatagTypeValidator validator) {
        return paratagTypeService.addC(validator);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER')")
    public void update(@Valid @RequestBody ParatagTypeValidator validator, @PathVariable("id") int id) {
        paratagTypeService.update(validator, id);
    }

    @GetMapping("dto")
    public List<ParatagTypeViewDto> getAllDto() {
        return paratagTypeService.getAllDto();
    }

    @GetMapping("dto/{id}")
    public ParatagTypeViewDto getDto(@PathVariable("id") int id) {
        return paratagTypeService.getDto(id);
    }

}
