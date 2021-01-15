package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import be.heh.app.model.entities.app.Page;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class ParapageViewDto extends AbstractDto {

    String title;

    List<PageViewDto> pageList;

}
