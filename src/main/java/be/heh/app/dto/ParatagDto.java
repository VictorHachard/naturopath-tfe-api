package be.heh.app.dto;

import be.heh.app.dto.view.TagViewDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class ParatagDto {

    int id;

    String title;

    List<TagViewDto> tagDtoList;

}
