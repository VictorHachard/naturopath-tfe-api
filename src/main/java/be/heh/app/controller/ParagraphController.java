package be.heh.app.controller;

import be.heh.app.controller.services.ParagraphService;
import be.heh.app.controller.validators.ParagraphValidator;
import be.heh.app.model.entities.app.Paragraph;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParagraphController {

    @Autowired
    ParagraphService paragraphService;

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

}
