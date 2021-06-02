package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.app.LikeValidator;
import be.heh.app.controller.validators.app.update.CategoryUpdateValidator;
import be.heh.app.controller.validators.app.update.LikeUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.controller.validators.commons.Pair;
import be.heh.app.dto.edit.CategoryEditDto;
import be.heh.app.dto.view.CategoryViewDto;
import be.heh.app.dto.view.LikeViewDto;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.Like;
import be.heh.app.model.entities.app.SortedType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class LikeService extends AbstractService<Like> {

    public LikeViewDto getDto(int pageId) {
        if (!pageRepository.existsById(pageId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no page with this pageId");
        }
        if (likeRepository.existsByPageAndUser(pageRepository.findById(pageId).get(), this.getUser())) {
            return likeMapper.getView(likeRepository.findByPageAndUser(pageRepository.findById(pageId).get(), this.getUser()).get());
        } else {
            return null;
        }
    }

    public void addC(AbstractValidator abstractValidator) {
        LikeValidator validator = (LikeValidator) abstractValidator;
        if (!pageRepository.existsById(validator.getPageId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no page with this pageId");
        }
        Like like = likeFacade.newInstance(this.getUser(), validator.isLike(), pageRepository.findById(validator.getPageId()).get());
        likeRepository.save(like);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        super.update(abstractValidator, id);
        LikeUpdateValidator validator = (LikeUpdateValidator) abstractValidator;
        Like like = likeRepository.findById(id).get();
        like.setActualLike(validator.isLike());
        likeRepository.save(like);
    }

}
