package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.Vote;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.InnerTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InnerTagFacade extends AbstractFacade<InnerTag> {

    @Autowired
    InnerTagRepository innerTagRepository;

    public InnerTag newInstance(String name, String content, User user) {
        InnerTag innerTag = new InnerTag();
        innerTag.setUser(user);
        innerTag.setContent(content);
        innerTag.setName(name);
        innerTag.setVersion(0);
        innerTag.setEnumState(EnumState.DRAFT);
        return innerTag;
    }

    public InnerTag newInstance(String name, String content, int version, User user) {
        InnerTag innerTag = new InnerTag();
        innerTag.setUser(user);
        innerTag.setContent(content);
        innerTag.setName(name);
        innerTag.setVersion(version);
        innerTag.setEnumState(EnumState.DRAFT);
        return innerTag;
    }

    public boolean userAlreadyVote(InnerTag innerTag, User user) {
        if (innerTag.getVoteList() == null) {
            return false;
        }
        for (Vote vote : innerTag.getVoteList()) {
            if (vote.getUser() == user) {
                return true;
            }
        }
        return false;
    }

}
