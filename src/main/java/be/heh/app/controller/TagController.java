package be.heh.app.controller;

import be.heh.app.controller.validators.TagValidator;
import be.heh.app.mapper.ParagraphMapper;
import be.heh.app.mapper.TagMapper;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.repositories.PageRepository;
import be.heh.app.model.repositories.TagRepository;
import be.heh.app.model.repositories.TagTypeRepository;
import be.heh.app.model.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    TagTypeRepository tagTypeRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/tag")
    public List<Tag> getAllTag() {
        if (tagRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Tag in the database");
        } else {
            return tagRepository.findAll();
        }
    }

    @GetMapping("/tag/{id}")
    public Tag getTag(@PathVariable("id") int id) {
        if (tagRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Tag with this tagId");
        } else {
            return tagRepository.findById(id).get();
        }
    }

    @PostMapping("/tag")
    public Tag insertTag(@Valid @RequestBody TagValidator tagValidator) {
        if (pageRepository.findById(tagValidator.getPageId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this categoryId");
        } else if (userRepository.findById(tagValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else if (tagTypeRepository.findById(tagValidator.getTagTypeId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType with this tagTypeId");
        } else {
            Tag tag = TagMapper.map(tagValidator, pageRepository.findById(tagValidator.getPageId()).get(), tagTypeRepository.findById(tagValidator.getTagTypeId()).get(), userRepository.findById(tagValidator.getUserId()).get());
            if (!pageRepository.findById(tagValidator.getPageId()).get().getCategory().getTagTypeList().contains(tag.getTagType())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Tag don't math the rule");
            } else if (!pageRepository.findById(tagValidator.getPageId()).get().verifyTypeTag(tag.getTagType())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The rule of the tag is duplicate");
            }
            Page page = pageRepository.findById(tagValidator.getPageId()).get();
            page.addTag(tag);

            tagRepository.save(tag);
            pageRepository.save(page);
            return tag;
        }
    }

}
