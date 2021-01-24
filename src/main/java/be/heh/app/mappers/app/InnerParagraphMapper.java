package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.ParagraphValidator;
import be.heh.app.controller.validators.app.update.ParagraphUpdateValidator;
import be.heh.app.dto.edit.InnerParagraphEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParagraph;
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
public final class InnerParagraphMapper extends AbstractMapper {

    public InnerParagraph set(ParagraphValidator paragraphValidator, User user) {
        return innerParagraphFacade.newInstance(
                paragraphValidator.getTitle(),
                paragraphValidator.getContent(),
                user);
    }

    public InnerParagraph set(ParagraphUpdateValidator paragraphUpdateValidator, int version, User user) {
        return innerParagraphFacade.newInstance(
                paragraphUpdateValidator.getTitle(),
                paragraphUpdateValidator.getContent(),
                version,
                user);
    }

    public List<InnerParagraphEditDto> getAllEditDto(List<InnerParagraph> list) {
        List<InnerParagraphEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        return res;
    }

    public InnerParagraphEditDto getEditDto(InnerParagraph i) {
        return new InnerParagraphEditDto(
                i.getId(),
                i.getVersion(),
                voteMapper.getAllViewDto(i.getVoteList()),
                messageMapper.getAllViewDto(i.getMessageList()),
                i.getEnumState().toString(),
                userMapper.getView(i.getUser()),
                i.getTitle(),
                i.getContent()
        );
    }

}
