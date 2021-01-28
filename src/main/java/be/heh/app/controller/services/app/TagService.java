package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.TagValidator;
import be.heh.app.controller.validators.app.view.TagByTagTypeDtoValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.edit.TagEditDto;
import be.heh.app.dto.view.TagByTagTypeViewDto;
import be.heh.app.dto.view.TagViewDto;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagService extends AbstractService<Tag> {

    public List<TagViewDto> getAllDto() {
        return tagMapper.getAllView(super.getAll());
    }

    public TagViewDto getDto(int id) {
        return tagMapper.getView(super.get(id));
    }

    public List<TagEditDto> getAllEditDto() {
        return tagMapper.getAllEditDto(super.getAll());
    }

    public TagEditDto getEditDto(int id) {
        return tagMapper.getEditDto(super.get(id));
    }

    public List<TagByTagTypeViewDto> getAllTagByTagTypeDto(AbstractValidator abstractValidator) {
        TagByTagTypeDtoValidator validator = (TagByTagTypeDtoValidator) abstractValidator;
        if (tagTypeRepository.findById(validator.getTagTypeId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no TagType with this tagTypeId");
        }
        List<TagByTagTypeViewDto> res = tagMapper.getAllTagByTagTypeDto(tagRepository.findAllByTagTypeById(validator.getTagTypeId(), EnumState.VALIDATED));
        Collections.sort(res);
        return res;
    }

    public int addC(AbstractValidator abstractValidator) {
        TagValidator validator = (TagValidator) abstractValidator;
        Tag tag;

        if (userRepository.findById(validator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else if (tagTypeRepository.findById(validator.getTagTypeId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType with this tagTypeId");
        } else {
            User user = userRepository.findById(validator.getUserId()).get();
            InnerTag innerTag = innerTagMapper.set(validator, user);
            tag = tagMapper.set(innerTag, tagTypeRepository.findById(validator.getTagTypeId()).get(), user);
            innerTagRepository.save(innerTag);
            tagRepository.save(tag);
            System.out.println(tag.toString());
        }
        return tag.getId();
    }

}
