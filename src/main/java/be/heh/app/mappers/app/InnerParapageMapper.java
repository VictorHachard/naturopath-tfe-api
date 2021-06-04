package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.InnerParagraphValidator;
import be.heh.app.controller.validators.app.InnerParapageValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.controller.validators.app.update.InnerParapageUpdateValidator;
import be.heh.app.dto.edit.InnerParapageEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.*;
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
public final class InnerParapageMapper extends AbstractMapper {

    public InnerParapage set(User user) {
        return innerParapageFacade.newInstance(user);
    }

    public InnerParapage set(InnerParapageValidator validator, int version, User user) {
        return innerParapageFacade.newInstance(
                validator.getTitle(),
                validator.getContent(),
                version,
                user
        );
    }

    public void update(InnerParapage innerParapage, InnerParapageUpdateValidator validator) {
        innerParapage.setTitle(validator.getTitle());
        innerParapage.setContent(validator.getContent());

    }

    public List<InnerParapageEditDto> getAllEditDto(List<InnerParapage> list) {
        List<InnerParapageEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        Collections.reverse(res);
        return res;
    }

    public InnerParapageEditDto getEditDto(InnerParapage i) {
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

        return new InnerParapageEditDto(
                i.getId(),
                i.getVersion(),
                f,
                a,
                voteMapper.getAllViewDto(i.getVoteList()),
                messageMapper.getAllViewDto(i.getMessageList()),
                i.getEnumState().toString(),
                userMapper.getView(i.getUser()),
                i.getTitle()
        );
    }

}
