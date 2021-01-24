package be.heh.app.mappers.app;

import be.heh.app.dto.edit.InnerParatagEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParatag;
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
public class InnerParatagMapper extends AbstractMapper {

    public List<InnerParatagEditDto> getAllEditDto(List<InnerParatag> list) {
        List<InnerParatagEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        return res;
    }

    public InnerParatagEditDto getEditDto(InnerParatag i) {
        return new InnerParatagEditDto(
                i.getId(),
                i.getVersion(),
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
