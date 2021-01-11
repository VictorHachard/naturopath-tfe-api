package be.heh.app.controller;

import be.heh.app.controller.services.TagService;
import be.heh.app.controller.validators.TagValidator;
import be.heh.app.model.entities.app.Tag;
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
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/tag")
    public List<Tag> getAllTag() {
        return tagService.getAllTag();
    }

    @GetMapping("/tag/{id}")
    public Tag getTag(@PathVariable("id") int id) {
        return tagService.getTag(id);
    }

    @PostMapping("/tag")
    public Tag insertTag(@Valid @RequestBody TagValidator tagValidator) {
        return tagService.insertTag(tagValidator);
    }

}
