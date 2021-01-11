package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.TagUpdateValidator;
import be.heh.app.controller.validators.app.TagValidator;
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
            } else if (!pageFacade.verifyTypeTag(pageRepository.findById(tagValidator.getPageId()).get(), tag.getTagType())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The rule of the tag is duplicate");
            }
            Page page = pageRepository.findById(tagValidator.getPageId()).get();
            page.addTag(tag);

            tagRepository.save(tag);
            pageRepository.save(page);
            return tag;
        }
    }

    public Tag updateTag(TagUpdateValidator tagUpdateValidator, int id) {
        if (userRepository.findById(tagUpdateValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else if (tagRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Tag with this id");
        } else {
            Tag tag = tagRepository.findById(id).get();
            InnerTag innerTag = innerTagMapper.map(tagUpdateValidator, tag.getInnerTagList().get(tag.getInnerTagList().size() - 1).getVersion() + 1, userRepository.findById(tagUpdateValidator.getUserId()).get());
            innerTagRepository.save(innerTag);
            tag.addInnerTag(innerTag);
            tagRepository.save(tag);
            return tag;
            //throw new ResponseStatusException(HttpStatus.CREATED, "The rule of the paragraph is duplicate");
        }
    }
}