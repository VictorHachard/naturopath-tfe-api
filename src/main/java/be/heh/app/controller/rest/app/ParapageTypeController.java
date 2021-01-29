package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.dto.view.ParapageTypeViewDto;
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
public class ParapageTypeController extends AbstractController {

    @PostMapping("/parapageType")
    public int add(@Valid @RequestBody GeneralTypeValidator generalTypeValidator) {
        return parapageTypeService.addC(generalTypeValidator);
    }

    @PutMapping("/parapageType/update/{id}")
    public void update(@Valid @RequestBody GeneralTypeValidator generalTypeValidator, @PathVariable("id") int id) {
        parapageTypeService.update(generalTypeValidator, id);
    }

    @GetMapping("/dto/parapageType")
    public List<ParapageTypeViewDto> getAllDto() {
        return parapageTypeService.getAllDto();
    }

}
