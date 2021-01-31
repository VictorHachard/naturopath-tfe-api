package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class TagFacade extends AbstractFacade<Tag> {

    public Tag newInstance(InnerTag innerTag, TagType tagType, User user) {
        Tag res = super.newInstance();
        res.addInnerTag(innerTag);
        res.setTagType(tagType);
        res.setUser(user);
        return res;
    }

    // Init
    public Tag init(InnerTag innerTag, TagType tagType) {
        Tag res = super.newInstance();
        res.addInnerTag(innerTag);
        res.setTagType(tagType);
        res.setEnumState(EnumState.VALIDATED);
        res.setUser(userRepository.findById(this.userId).get());
        return res;
    }

}
