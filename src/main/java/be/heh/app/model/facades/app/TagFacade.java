package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagFacade extends AbstractFacade<Tag> {

    public Tag newInstance(InnerTag innerTag, TagType tagType, User user) {
        Tag tag = new Tag();
        tag.addInnerTag(innerTag);
        tag.setTagType(tagType);
        tag.setUser(user);
        return tag;
    }

}
