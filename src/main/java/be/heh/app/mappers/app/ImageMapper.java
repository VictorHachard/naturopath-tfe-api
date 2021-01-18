package be.heh.app.mappers.app;

import be.heh.app.dto.view.ImageViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
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
public final class ImageMapper extends AbstractMapper {

    public List<ImageViewDto> getAllView(List<Image> j) {
        List<ImageViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        return res;
    }

    public ImageViewDto getView(Image j) {
        List<InnerImage> i = imageRepository.findInnerImage(j, EnumState.VALADATING);
        if (i == null) {
            return null;
        } else {
            InnerImage k = i.get(0);
            return new ImageViewDto(
                    k.getId(),
                    k.getTitle(),
                    k.getDescription(),
                    k.getUrl()
            );
        }
    }

}
