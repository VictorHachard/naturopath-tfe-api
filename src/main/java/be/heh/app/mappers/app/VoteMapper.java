package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.VoteValidator;
import be.heh.app.dto.view.VoteViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.Vote;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<VoteViewDto> getAllViewDto(List<Vote> voteList) {
        List<VoteViewDto> res = new ArrayList<>();
        voteList.forEach(i -> {
            res.add(this.getViewDto(i));
        });
        return res;
    }

    public VoteViewDto getViewDto(Vote vote) {
        return new VoteViewDto(
                vote.getId(),
                userMapper.getView(vote.getUser()),
                vote.getChoice(),
                vote.getCreatedAt()
        );
    }

}
