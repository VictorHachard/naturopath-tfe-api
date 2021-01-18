package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.Vote;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class VoteFacade extends AbstractFacade<Vote> {

    public Vote newInstance(int choice, User user) {
        Vote vote = new Vote();
        vote.setChoice(choice);
        vote.setUser(user);
        return vote;
    }

}
