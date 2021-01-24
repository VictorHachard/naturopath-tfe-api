package be.heh.app.mappers.app;

import be.heh.app.dto.edit.InnerParapageEditDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerParapage;
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
public class InnerParapageMapper extends AbstractMapper {

    public List<InnerParapageEditDto> getAllEditDto(List<InnerParapage> list) {
        List<InnerParapageEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        return res;
    }

    public InnerParapageEditDto getEditDto(InnerParapage i) {
        return new InnerParapageEditDto(
                i.getId(),
                i.getVersion(),
                voteMapper.getAllViewDto(i.getVoteList()),
                messageMapper.getAllViewDto(i.getMessageList()),
                i.getEnumState().toString(),
                userMapper.getView(i.getUser()),
                i.getTitle()
        );
    }

}
