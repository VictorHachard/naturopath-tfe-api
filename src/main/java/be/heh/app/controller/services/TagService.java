package be.heh.app.controller.services;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.TagValidator;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagService extends AbstractService {

    public List<Tag> getAllTag() {
        if (tagRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Tag in the database");
        } else {
            return tagRepository.findAll();
        }
    }

    public Tag getTag(int id) {
        if (tagRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Tag with this tagId");
        } else {
            return tagRepository.findById(id).get();
        }
    }

    public Tag insertTag(TagValidator tagValidator) {
        if (pageRepository.findById(tagValidator.getPageId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this categoryId");
        } else if (userRepository.findById(tagValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else if (tagTypeRepository.findById(tagValidator.getTagTypeId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType with this tagTypeId");
        } else {
            InnerTag innerTag = new InnerTag();
            Tag tag = tagMapper.map(innerTag, tagTypeRepository.findById(tagValidator.getTagTypeId()).get(), userRepository.findById(tagValidator.getUserId()).get());
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
