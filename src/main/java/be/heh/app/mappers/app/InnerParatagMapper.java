package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.app.InnerParatagValidator;
import be.heh.app.controller.validators.app.update.CategoryUpdateValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.controller.validators.app.update.InnerParatagUpdateValidator;
import be.heh.app.dto.edit.InnerParatagEditDto;
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
public final class InnerParatagMapper extends AbstractMapper {

    public InnerParatag set(User user) {
        return innerParatagFacade.newInstance(user);
    }

    public InnerParatag set(InnerParatagValidator validator, int version, User user) {
        return innerParatagFacade.newInstance(
                validator.getTitle(),
                validator.getContent(),
                version,
                user
        );
    }

    public void update(InnerParatag innerParatag, InnerParatagUpdateValidator validator) {
        innerParatag.setTitle(validator.getTitle());
        innerParatag.setContent(validator.getContent());
    }

    public List<InnerParatagEditDto> getAllEditDto(List<InnerParatag> list) {
        List<InnerParatagEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        Collections.reverse(res);
        return res;
    }

    public InnerParatagEditDto getEditDto(InnerParatag i) {
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

        return new InnerParatagEditDto(
                i.getId(),
                i.getVersion(),
                f,
                a,
                voteMapper.getAllViewDto(i.getVoteList()),
                messageMapper.getAllViewDto(i.getMessageList()),
                i.getEnumState().toString(),
                userMapper.getView(i.getUser()),
                i.getTitle(),
                i.getContent(),
                tagMapper.getAllView(i.getTagList())
        );
    }

}
