package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ImageViewDto extends AbstractDto {

    String title;

    String description;

    String url;

    public ImageViewDto(int id, String title, String description, String url) {
        super(id);
        this.title = title;
        this.description = description;
        this.url = url;
    }

}
