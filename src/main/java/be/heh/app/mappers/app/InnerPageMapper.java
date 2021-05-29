package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.update.InnerPageUpdateValidator;
import be.heh.app.dto.edit.InnerPageEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerPage;
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
public final class InnerPageMapper extends AbstractMapper {

    public InnerPage set(PageValidator pageValidator, User user) {
        return innerPageFacade.newInstance(
                pageValidator.getTitle(),
                pageValidator.getDescription(),
                user
        );
    }

    public InnerPage set(InnerPageUpdateValidator validator, Image image, int version, User user) {
        return innerPageFacade.newInstance(
                validator.getTitle(),
                validator.getDescription(),
                image,
                version,
                user
        );
    }

    public void update(InnerPage innerPage, Image image, InnerPageUpdateValidator validator) {
        innerPage.setTitle(validator.getTitle());
        innerPage.setDescription(validator.getDescription());
        innerPage.setImage(image);
    }

    public List<InnerPageEditDto> getAllEditDto(List<InnerPage> list) {
        List<InnerPageEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        Collections.reverse(res);
        return res;
    }

    public InnerPageEditDto getEditDto(InnerPage i) {
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

        return new InnerPageEditDto(
                i.getId(),
                i.getVersion(),
                f,
                a,
                voteMapper.getAllViewDto(i.getVoteList()),
                messageMapper.getAllViewDto(i.getMessageList()),
                i.getEnumState().toString(),
                userMapper.getView(i.getUser()),
                i.getTitle(),
                i.getDescription(),
                i.getImage() == null ? null : imageMapper.getView(i.getImage())
        );
    }

}
