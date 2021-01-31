package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.dto.view.ParagraphViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/paragraph/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParagraphController extends AbstractController {

    @GetMapping("dto")
    public List<ParagraphViewDto> getAllDto() {
        return paragraphService.getAllDto();
    }

    @GetMapping("dto/{id}")
    public ParagraphViewDto getDto(@PathVariable("id") int id) {
        return paragraphService.getDto(id);
    }

    /*@GetMapping("/dto/edit/tag")
    public List<TagEditDto> getAllEditDto() {
        return tagService.getAllEditDto();
    }

    @GetMapping("/dto/edit/tag/{id}")
    public TagEditDto getEditDto(@PathVariable("id") int id) {
        return tagService.getEditDto(id);
    }*/

    /*@PostMapping("/paragraph")
    public void add(@Valid @RequestBody ParagraphValidator paragraphValidator) {
        paragraphService.add(paragraphValidator);
    }

    @PutMapping("/paragraph/update/{id}")
    public void update(@Valid @RequestBody ParagraphUpdateValidator paragraphUpdateValidator, @PathVariable("id") int id) {
        paragraphService.update(paragraphUpdateValidator, id);
    }*/

}
