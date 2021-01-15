package be.heh.app.mappers.app;

import be.heh.app.dto.view.ParagraphViewDto;
import be.heh.app.dto.view.ParapageViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.InnerParapage;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.Parapage;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.app.ParapageFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParapageMapper extends AbstractMapper {

    @Autowired
    ParapageFacade parapageFacade;

    public List<ParapageViewDto> getAllView(List<Parapage> j) {
        List<ParapageViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        return res;
    }

    public ParapageViewDto getView(Parapage paragraph) {
        InnerParapage innerParapage = parapageRepository.findLastFiltered(paragraph, EnumState.VALADATING).get(0);
        return new ParapageViewDto(innerParapage.getTitle(),
                pageMapper.getAllDto(innerParapage.getPageList()));
    }

}
