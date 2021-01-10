package be.heh.app.mapper;

import be.heh.app.controller.validators.TagTypeValidator;
import be.heh.app.model.entities.app.TagType;

public final class TagTypeMapper {

    public static TagType map(TagTypeValidator tagTypeValidator) {
        TagType tagType = new TagType();
        tagType.setName(tagTypeValidator.getName());
        tagType.setDescription(tagTypeValidator.getDescription());
        return tagType;
    }

}
