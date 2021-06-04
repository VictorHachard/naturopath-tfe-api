package be.heh.app.mappers.app;

import be.heh.app.dto.edit.ParapageEditDto;
import be.heh.app.dto.view.ParapageViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.*;
import be.heh.app.model.entities.app.enumeration.EnumState;
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
public final class ParapageMapper extends AbstractMapper {

    public Parapage set(InnerParapage innerParapage, ParapageType parapageType, User user) {
        return parapageFacade.newInstance(
                innerParapage,
                parapageType,
                user);
    }

    public List<ParapageViewDto> getAllView(List<Parapage> j) {
        List<ParapageViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            ParapageViewDto d = this.getView(i);
            if (d != null) {
                res.add(d);
            }
        });
        return res;
    }

    public ParapageViewDto getView(Parapage j) {
        List<InnerParapage> i = parapageRepository.findInnerParapage(j, EnumState.VALIDATED);
        if (i == null || i.isEmpty()) {
            return null;
        } else {
            InnerParapage k = i.get(0);
            return new ParapageViewDto(
                    k.getId(),
                    k.getTitle(),
                    k.getContent(),
                    parapageTypeMapper.getView(j.getParapageType()),
                    pageMapper.getAllPageSimplifiedRecommendedViewDto(k.getPageList()));
        }
    }

    public List<ParapageEditDto> getAllEditDto(List<Parapage> list) {
        List<ParapageEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        Collections.reverse(res);
        return res;
    }

    public ParapageEditDto getEditDto(Parapage i) {
        return new ParapageEditDto(
                i.getId(),
                parapageTypeMapper.getView(i.getParapageType()),
                innerParapageMapper.getAllEditDto(i.getInnerParapageList())
        );
    }

}
