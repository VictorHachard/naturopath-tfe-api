package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.ImageValidator;
import be.heh.app.controller.validators.app.update.InnerImageUpdateValidator;
import be.heh.app.dto.edit.InnerImageEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerImage;
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
public final class InnerImageMapper extends AbstractMapper {

    public InnerImage set(ImageValidator validator, User user) {
        return innerImageFacade.newInstance(
                validator.getTitle(),
                validator.getDescription(),
                validator.getUrl(),
                0,
                user
        );
    }

    public InnerImage set(InnerImageUpdateValidator validator, int version, User user) {
        return innerImageFacade.newInstance(
                validator.getTitle(),
                validator.getDescription(),
                validator.getUrl(),
                version,
                user
        );
    }

    public void update(InnerImage innerImage, InnerImageUpdateValidator validator) {
        innerImage.setTitle(validator.getTitle());
        innerImage.setDescription(validator.getDescription());
        innerImage.setUrl(validator.getUrl());
    }

    public List<InnerImageEditDto> getAllEditDto(List<InnerImage> list) {
        List<InnerImageEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        Collections.reverse(res);
        return res;
    }

    public InnerImageEditDto getEditDto(InnerImage i) {
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

        return new InnerImageEditDto(
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
                i.getUrl()
        );
    }

}
