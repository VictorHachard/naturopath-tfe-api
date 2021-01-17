package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.VoteValidator;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.Vote;
import be.heh.app.model.facades.app.VoteFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class VoteMapper extends AbstractMapper {

    public Vote set(VoteValidator voteValidator, User user) {
        return voteFacade.newInstance(
                voteValidator.getChoice(),
                user);
    }
}
