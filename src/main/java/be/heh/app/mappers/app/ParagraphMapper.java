package be.heh.app.mappers.app;

import be.heh.app.dto.view.ParagraphViewDto;
import be.heh.app.dto.view.ParatagViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
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
public final class ParagraphMapper extends AbstractMapper {

    public Paragraph set(InnerParagraph innerParagraph, ParagraphType paragraphType, User user) {
        return paragraphFacade.newInstance(
                innerParagraph,
                paragraphType,
                user);
    }

    public List<ParagraphViewDto> getAllView(List<Paragraph> j) {
        List<ParagraphViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            ParagraphViewDto d = this.getView(i);
            if (d != null) {
                res.add(d);
            }
        });
        return res;
    }

    public ParagraphViewDto getView(Paragraph j) {
        List<InnerParagraph> i = paragraphRepository.findInnerParagraph(j, EnumState.VALIDATED);
        if (i == null || i.isEmpty()) {
            return null;
        } else {
            InnerParagraph k = i.get(0);
            return new ParagraphViewDto(
                    k.getId(),
                    paragraphTypeMapper.getView(j.getParagraphType()),
                    k.getTitle(),
                    k.getContent());
        }
    }

}
