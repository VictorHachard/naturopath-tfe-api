package be.heh.app.mappers.app;

import be.heh.app.dto.edit.ParatagEditDto;
import be.heh.app.dto.view.ParatagViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.entities.app.Paratag;
import be.heh.app.model.entities.app.ParatagType;
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
public final class ParatagMapper extends AbstractMapper {

    public Paratag set(InnerParatag innerParatag, ParatagType paratagType, User user) {
        return paratagFacade.newInstance(
                innerParatag,
                paratagType,
                user);
    }

    public List<ParatagViewDto> getAllView(List<Paratag> j) {
        List<ParatagViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            ParatagViewDto d = this.getView(i);
            if (d != null) {
                res.add(d);
            }
        });
        return res;
    }

    public ParatagViewDto getView(Paratag j) {
        List<InnerParatag> i = paratagRepository.findInnerParatag(j, EnumState.VALIDATED);
        if (i == null || i.isEmpty()) {
            return null;
        } else {
            InnerParatag k = i.get(0);
            return new ParatagViewDto(
                    k.getId(),
                    k.getTitle(),
                    paratagTypeMapper.getView(j.getParatagType()),
                    k.getContent(),
                    tagMapper.getAllView(k.getTagList()));
        }
    }

    public List<ParatagEditDto> getAllEditDto(List<Paratag> list) {
        List<ParatagEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        return res;
    }

    public ParatagEditDto getEditDto(Paratag i) {
        return new ParatagEditDto(
                i.getId(),
                paratagTypeMapper.getView(i.getParatagType()),
                innerParatagMapper.getAllEditDto(i.getInnerParatagList())
        );
    }

}
