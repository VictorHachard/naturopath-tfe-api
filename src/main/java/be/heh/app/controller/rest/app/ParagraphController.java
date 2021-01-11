package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.ParagraphUpdateValidator;
import be.heh.app.controller.validators.app.ParagraphValidator;
import be.heh.app.model.entities.app.Paragraph;
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
public class ParagraphController extends AbstractController {

    @GetMapping("/paragraph")
    public List<Paragraph> getAllParagraph() {
        return paragraphService.getAllParagraph();
    }

    @GetMapping("/paragraph/{id}")
    public Paragraph getParagraph(@PathVariable("id") int id) {
        return paragraphService.getParagraph(id);
    }

    @PostMapping("/paragraph")
    public Paragraph insertParagraph(@Valid @RequestBody ParagraphValidator paragraphValidator) {
        return paragraphService.insertParagraph(paragraphValidator);
    }

    @PostMapping("/paragraph/update/{id}")
    public Paragraph insertParagraph(@Valid @RequestBody ParagraphUpdateValidator paragraphUpdateValidator, @PathVariable("id") int id) {
        return paragraphService.updateParagraph(paragraphUpdateValidator, id);
    }

}
