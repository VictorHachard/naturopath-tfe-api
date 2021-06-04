package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/parapage/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParapageController extends AbstractController {

    /*@GetMapping("dto")
    public List<ParapageViewDto> getAllDto() {
        return parapages.getAllDto();
    }

    @GetMapping("dto/{id}")
    public ParapageViewDto getDto(@PathVariable("id") int id) {
        return paragraphService.getDto(id);
    }*/

}
