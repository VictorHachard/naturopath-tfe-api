package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.dto.view.ParagraphTypeViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/paragraphType/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParagraphTypeController extends AbstractController {

    @PostMapping("")
    public int add(@Valid @RequestBody GeneralTypeValidator generalTypeValidator) {
        return paragraphTypeService.addC(generalTypeValidator);
    }

    @PutMapping("update/{id}")
    public void update(@Valid @RequestBody GeneralTypeValidator generalTypeValidator, @PathVariable("id") int id) {
        paragraphTypeService.update(generalTypeValidator, id);
    }

    @GetMapping("dto")
    public List<ParagraphTypeViewDto> getAllDto() {
        return paragraphTypeService.getAllDto();
    }

    @GetMapping("dto/{id}")
    public ParagraphTypeViewDto getDto(@PathVariable("id") int id) {
        return paragraphTypeService.getDto(id);
    }

}
