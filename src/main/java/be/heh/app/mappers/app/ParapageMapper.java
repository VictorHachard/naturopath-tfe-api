package be.heh.app.mappers.app;

import be.heh.app.dto.view.ParapageViewDto;
import be.heh.app.dto.view.ParatagViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParapage;
import be.heh.app.model.entities.app.Parapage;
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
public final class ParapageMapper extends AbstractMapper {

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
                    pageMapper.getAllDto(k.getPageList()));
        }
    }

}
