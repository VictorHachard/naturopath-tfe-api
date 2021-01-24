package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.update.PageUpdateValidator;
import be.heh.app.dto.edit.InnerPageEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.User;
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
public final class InnerPageMapper extends AbstractMapper {

    public InnerPage set(PageValidator pageValidator, User user) {
        return innerPageFacade.newInstance(
                pageValidator.getTitle(),
                pageValidator.getDescription(),
                user);
    }

    public InnerPage set(PageUpdateValidator pageUpdateValidator, int version, User user) {
        return innerPageFacade.newInstance(
                pageUpdateValidator.getTitle(),
                pageUpdateValidator.getDescription(),
                version,
                user);
    }

    public List<InnerPageEditDto> getAllEditDto(List<InnerPage> list) {
        List<InnerPageEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        return res;
    }

    public InnerPageEditDto getEditDto(InnerPage i) {
        return new InnerPageEditDto(
                i.getId(),
                i.getVersion(),
                voteMapper.getAllViewDto(i.getVoteList()),
                messageMapper.getAllViewDto(i.getMessageList()),
                i.getEnumState().toString(),
                userMapper.getView(i.getUser()),
                i.getTitle(),
                i.getDescription()
        );
    }

}
