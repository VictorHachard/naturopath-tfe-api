package be.heh.app.dto;

import be.heh.app.dto.commons.AbstractDto;
import be.heh.app.model.entities.app.Page;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class PageDto extends AbstractDto {

    Page page;

    String msgSucess;

}
