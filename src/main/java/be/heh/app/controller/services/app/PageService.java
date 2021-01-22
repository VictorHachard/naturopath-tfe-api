package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.update.PageUpdateValidator;
import be.heh.app.controller.validators.app.view.PagesByCategoryDtoValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.PageByCategoryViewDto;
import be.heh.app.dto.view.PageViewDto;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class PageService extends AbstractService<Page> {

    //TODO sort by category maybe
    public List<PageViewDto> getAllDto() {
        return pageMapper.getAllDto(super.getAll());
    }

    public PageViewDto getDto(int id) {
        return pageMapper.getDto(super.get(id));
    }

    public List<PageByCategoryViewDto> getAllPageByCategoryDto(PagesByCategoryDtoValidator validator) {
        if (categoryRepository.findById(validator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        }
        //TODO findAllByCategory not empty
        return pageMapper.getAllPageByCategoryDto(pageRepository.findAllByCategoryById(validator.getCategoryId(), EnumState.VALIDATED));
    }

    @Override
    public void add(AbstractValidator abstractValidator) {
        PageValidator validator = (PageValidator) abstractValidator;
        if (categoryRepository.findById(validator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (userRepository.findById(validator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else {
            InnerPage innerPage = innerPageMapper.set(validator, userRepository.findById(validator.getUserId()).get());
            innerPageRepository.save(innerPage);
            Page page = pageMapper.set(innerPage, categoryRepository.findById(validator.getCategoryId()).get(), userRepository.findById(validator.getUserId()).get());
            pageRepository.save(page);
        }
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        PageUpdateValidator validator = (PageUpdateValidator) abstractValidator;
        if (pageRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this pageId");
        } else if (userRepository.findById(validator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else {
            InnerPage lastInnerPage = pageRepository.findById(id).get().getInnerPageList().get(pageRepository.findById(id).get().getInnerPageList().size() - 1);
            InnerPage innerPage = innerPageMapper.set(validator, lastInnerPage.getVersion() + 1, userRepository.findById(validator.getUserId()).get());
            innerPageRepository.save(innerPage);
            Page page = pageRepository.findById(id).get();
            page.addInnerPage(innerPage);
            pageRepository.save(page);
        }
    }

    @Override
    public void delete(int id) {
        //TODO delete link
        pageRepository.findById(id).ifPresentOrElse((page)->{
            pageRepository.delete(page);
        }, ()->{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this pageId");
        });
    }

}
