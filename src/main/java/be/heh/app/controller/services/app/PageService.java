package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.update.PageUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.PageViewDto;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
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

    public List<PageViewDto> getAllDto() {
        return pageMapper.getAllDto(super.getAll());
    }

    public PageViewDto getDto(int id) {
        return pageMapper.getDto(super.get(id));
    }

    /*public List<CategoryViewDto> getAllDto() {
        List<CategoryViewDto> categoryDtoList = new ArrayList<>();
        categoryRepository.findAllParent().forEach(category -> {
            CategoryViewDto categoryDto = getRecursive(category);
            categoryDtoList.add(categoryDto);

        });
        return categoryDtoList;
    }

    public CategoryViewDto getDto(int id) {
        return getRecursive(super.get(id));
    }*/

    @Override
    public void add(AbstractValidator abstractValidator) {
        PageValidator pageValidator = (PageValidator) abstractValidator;
        if (categoryRepository.findById(pageValidator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (userRepository.findById(pageValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else {
            InnerPage innerPage = innerPageMapper.set(pageValidator, userRepository.findById(pageValidator.getUserId()).get());
            innerPageRepository.save(innerPage);
            Page page = pageMapper.set(innerPage, categoryRepository.findById(pageValidator.getCategoryId()).get(), userRepository.findById(pageValidator.getUserId()).get());
            pageRepository.save(page);
        }
    }

    public Page updatePage(PageUpdateValidator pageUpdateValidator, int id) {
        if (pageRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this pageId");
        } else if (userRepository.findById(pageUpdateValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else {
            InnerPage lastInnerPage = pageRepository.findById(id).get().getInnerPageList().get(pageRepository.findById(id).get().getInnerPageList().size() - 1);
            InnerPage innerPage = innerPageMapper.set(pageUpdateValidator, lastInnerPage.getVersion() + 1, userRepository.findById(pageUpdateValidator.getUserId()).get());
            innerPageRepository.save(innerPage);
            Page page = pageRepository.findById(id).get();
            page.addInnerPage(innerPage);
            pageRepository.save(page);
            return page;
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
