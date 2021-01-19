package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ParapageViewDto extends AbstractDto {

    String title;

    List<PageViewDto> pageList;

    public ParapageViewDto(int id, String title, List<PageViewDto> pageList) {
        super(id);
        this.title = title;
        this.pageList = pageList;
    }

}
