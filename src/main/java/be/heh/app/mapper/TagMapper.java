package be.heh.app.mapper;

import be.heh.app.controller.validators.TagValidator;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.entities.app.User;

public final class TagMapper {

    public static Tag map(TagValidator tagValidator, Page page, TagType tagType, User user) {
        Tag tag = new Tag();
        tag.setName(tagValidator.getName());
        tag.setDescription(tagValidator.getDescription());
        tag.setTagType(tagType);
        tag.setUser(user);
        return tag;
    }

}
