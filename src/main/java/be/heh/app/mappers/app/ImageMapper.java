package be.heh.app.mappers.app;

import be.heh.app.dto.view.ImageViewDto;
import be.heh.app.dto.view.ParagraphViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.app.ImageFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ImageMapper extends AbstractMapper {

    @Autowired
    ImageFacade imageFacade;

    public List<ImageViewDto> getAllView(List<Image> j) {
        List<ImageViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        return res;
    }

    public ImageViewDto getView(Image image) {
        InnerImage innerImage = imageRepository.findLastFiltered(image, EnumState.VALADATING).get(0);
        return new ImageViewDto(innerImage.getTitle(),
                innerImage.getDescription(),
                innerImage.getUrl()
        );
    }

}
