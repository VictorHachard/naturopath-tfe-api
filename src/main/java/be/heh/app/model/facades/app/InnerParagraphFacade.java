package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.Vote;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.InnerParagraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InnerParagraphFacade extends AbstractFacade<InnerParagraph> {

    @Autowired
    InnerParagraphRepository innerParagraphRepository;

    public InnerParagraph newInstance(String title, String content, User user) {
        InnerParagraph innerParagraph = new InnerParagraph();
        innerParagraph.setUser(user);
        innerParagraph.setContent(content);
        innerParagraph.setTitle(title);
        innerParagraph.setVersion(0);
        innerParagraph.setEnumState(EnumState.DRAFT);
        return innerParagraph;
    }

    public InnerParagraph newInstance(String title, String content, int version, User user) {
        InnerParagraph innerParagraph = new InnerParagraph();
        innerParagraph.setUser(user);
        innerParagraph.setContent(content);
        innerParagraph.setTitle(title);
        innerParagraph.setVersion(version);
        innerParagraph.setEnumState(EnumState.DRAFT);
        return innerParagraph;
    }

    public boolean userAlreadyVote(InnerParagraph innerParagraph, User user) {
        if (innerParagraph.getVoteList() == null) {
            return false;
        }
        for (Vote vote : innerParagraph.getVoteList()) {
            if (vote.getUser() == user) {
                return true;
            }
        }
        return false;
    }

}
