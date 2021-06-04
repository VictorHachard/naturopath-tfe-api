package be.heh.app.mappers.app;

import be.heh.app.dto.view.LikeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Like;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class LikeMapper extends AbstractMapper {

    public LikeViewDto getView(Like like) {
        return new LikeViewDto(
                like.getId(),
                like.isActualLike(),
                like.getPage().getId());
    }

}
