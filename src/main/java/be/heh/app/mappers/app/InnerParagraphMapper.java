package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.InnerParagraphValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.dto.edit.InnerParagraphEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParagraph;
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
public final class InnerParagraphMapper extends AbstractMapper {

    public InnerParagraph set(User user) {
        return innerParagraphFacade.newInstance(user);
    }

    public InnerParagraph set(InnerParagraphValidator validator, int version, User user) {
        return innerParagraphFacade.newInstance(
                validator.getTitle(),
                validator.getContent(),
                version,
                user
        );
    }

    public void update(InnerParagraph innerParagraph, InnerParagraphUpdateValidator validator) {
        innerParagraph.setTitle(validator.getTitle());
        innerParagraph.setContent(validator.getContent());
    }

    public List<InnerParagraphEditDto> getAllEditDto(List<InnerParagraph> list) {
        List<InnerParagraphEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        Collections.reverse(res);
        return res;
    }

    public InnerParagraphEditDto getEditDto(InnerParagraph i) {
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

        return new InnerParagraphEditDto(
                i.getId(),
                i.getVersion(),
                f,
                a,
                voteMapper.getAllViewDto(i.getVoteList()),
                messageMapper.getAllViewDto(i.getMessageList()),
                i.getEnumState().toString(),
                userMapper.getView(i.getUser()),
                i.getTitle(),
                i.getContent()
        );
    }

}
