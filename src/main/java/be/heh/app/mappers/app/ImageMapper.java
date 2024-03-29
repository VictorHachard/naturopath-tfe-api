package be.heh.app.mappers.app;

import be.heh.app.dto.edit.ImageEditDto;
import be.heh.app.dto.view.ImageForPageByCategoryViewDto;
import be.heh.app.dto.view.ImageViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
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

    public Image set(InnerImage innerImage, User user) {
        return imageFacade.newInstance(
                innerImage,
                user
        );
    }

    public List<ImageViewDto> getAllView(List<Image> j) {
        List<ImageViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            if (i != null) {
                ImageViewDto imageViewDto = this.getView(i);
                if (imageViewDto != null) {
                    res.add(this.getView(i));
                }
            }
        });
        return res;
    }

    public ImageViewDto getView(Image j) {
        List<InnerImage> i = imageRepository.findInnerImage(j, EnumState.VALIDATED);
        if (i == null) {
            return null;
        } else {
            if (!i.isEmpty()) { //Todo remove empty nerver empty
                InnerImage k = i.get(0);
                return new ImageViewDto(
                        j.getId(),
                        k.getId(),
                        k.getTitle(),
                        k.getDescription(),
                        k.getUrl()
                );
            } else {
                return null;
            }
        }
    }

    public List<ImageEditDto> getAllEditDto(List<Image> list) {
        List<ImageEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        return res;
    }

    public ImageEditDto getEditDto(Image j) {
        return new ImageEditDto(
                j.getId(),
                innerImageMapper.getAllEditDto(j.getInnerImageList())
        );
    }

    public ImageForPageByCategoryViewDto getImageForPageByCategoryView(Image j) {
        List<InnerImage> i = imageRepository.findInnerImage(j, EnumState.VALIDATED);
        if (i == null) {
            return null;
        } else {
            if (!i.isEmpty()) {
                InnerImage k = i.get(0);
                return new ImageForPageByCategoryViewDto(k.getUrl());
            } else {
                return null;
            }
        }
    }

}
