package be.heh.app.model.facades.app;

import be.heh.app.controller.validators.TagTypeValidator;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.TagTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagTypeFacade extends AbstractFacade<TagType> {

    @Autowired
    TagTypeRepository tagTypeRepository;

    @Override
    public TagType newInstance() {
        return tagTypeRepository.newInstance();
    }

    public TagType newInstance(TagTypeValidator tagTypeValidator) {
        TagType tagType = new TagType();
        tagType.setName(tagTypeValidator.getName());
        tagType.setDescription(tagTypeValidator.getDescription());
        return tagType;
    }

}
