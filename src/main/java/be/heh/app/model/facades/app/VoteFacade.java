package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Vote;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteFacade extends AbstractFacade<Vote> {

    @Autowired
    VoteRepository voteRepository;

    @Override
    public Vote newInstance() {
        return voteRepository.newInstance();
    }

}
