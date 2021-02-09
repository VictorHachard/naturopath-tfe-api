package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.ImageValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.ImageViewDto;
import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ImageService extends AbstractService<Image> {

    public List<ImageViewDto> getAllDto() {
        return imageMapper.getAllView(super.getAll());
    }

    public ImageViewDto getDto(int id) {
        return imageMapper.getView(super.get(id));
    }

    public int addC(AbstractValidator abstractValidator) {
        ImageValidator validator = (ImageValidator) abstractValidator;
        Image image;

        User user = this.getUser();
        InnerImage innerImage = innerImageMapper.set(validator, user);
        image = imageMapper.set(innerImage, user);
        innerImageRepository.save(innerImage);
        imageRepository.save(image);
        return image.getId();
    }

}
