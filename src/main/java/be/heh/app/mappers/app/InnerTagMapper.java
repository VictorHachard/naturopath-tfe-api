package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.TagValidator;
import be.heh.app.controller.validators.app.update.InnerTagUpdateValidator;
import be.heh.app.dto.edit.InnerTagEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.Vote;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class InnerTagMapper extends AbstractMapper {

    public InnerTag set(TagValidator validator, User user) {
        return innerTagFacade.newInstance(
                validator.getName(),
                validator.getContent(),
                0,
                user
        );
    }

    public InnerTag set(InnerTagUpdateValidator validator, int version, User user) {
        return innerTagFacade.newInstance(
                validator.getName(),
                validator.getContent(),
                version,
                user
        );
    }

    public void update(InnerTag innerTag, InnerTagUpdateValidator validator) {
        innerTag.setName(validator.getName());
        innerTag.setContent(validator.getContent());
    }

    public List<InnerTagEditDto> getAllEditDto(List<InnerTag> list) {
        List<InnerTagEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        Collections.reverse(res);
        return res;
    }

    public InnerTagEditDto getEditDto(InnerTag i) {
        int a = 0;
        int f = 0;
        for (Vote v : i.getVoteList()) {
            if (v.getChoice() == 0) {
                a += 1;
            }
        }
        for (Vote v : i.getVoteList()) {
            f += v.getChoice();
        }

        return new InnerTagEditDto(
                i.getId(),
                i.getVersion(),
                f,
                a,
                voteMapper.getAllViewDto(i.getVoteList()),
                messageMapper.getAllViewDto(i.getMessageList()),
                i.getEnumState().toString(),
                userMapper.getView(i.getUser()),
                i.getName(),
                i.getContent()
        );
    }

}
