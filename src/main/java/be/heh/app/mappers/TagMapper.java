package be.heh.app.mappers;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.app.TagFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class TagMapper {

    @Autowired
    TagFacade tagFacade;

    public Tag map(InnerTag innerTag, TagType tagType, User user) {
        return tagFacade.newInstance(innerTag, tagType, user);
    }

}
