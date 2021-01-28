package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.InnerTagValidator;
import be.heh.app.controller.validators.app.update.InnerTagUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerTagService extends AbstractService<InnerTag> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        //TODO verifiaction
        InnerTagValidator validator = (InnerTagValidator) abstractValidator;
        Tag tag = tagRepository.findById(validator.getTagId()).get();
        User user = userRepository.findById(validator.getUserId()).get();

        InnerTag innerTag = innerTagMapper.set(validator, user);
        innerTagRepository.save(innerTag);
        tag.addInnerTag(innerTag);
        tagRepository.save(tag);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerTagUpdateValidator validator = (InnerTagUpdateValidator) abstractValidator;
        InnerTag innerTag = innerTagRepository.findById(id).get();
        innerTagMapper.update(innerTag, validator);
        innerTagRepository.save(innerTag);
    }

    public void validation(int id) {
        //TODO verifiaction
        InnerTag innerTag = innerTagRepository.findById(id).get();
        System.out.println(innerTag.toString());
        innerTag.setEnumState(EnumState.VALIDATING);
        innerTagRepository.save(innerTag);
    }

}
