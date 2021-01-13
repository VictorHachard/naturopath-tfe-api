package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.PageUpdateValidator;
import be.heh.app.controller.validators.app.PageValidator;
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

    public Page insertPage(PageValidator pageValidator) {
        if (categoryRepository.findById(pageValidator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (userRepository.findById(pageValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else {
            InnerPage innerPage = innerPageMapper.map(pageValidator, userRepository.findById(pageValidator.getUserId()).get());
            innerPageRepository.save(innerPage);
            Page page = pageMapper.map(innerPage, categoryRepository.findById(pageValidator.getCategoryId()).get(), userRepository.findById(pageValidator.getUserId()).get());
            pageRepository.save(page);
            return page;
        }
    }

    public Page updatePage(PageUpdateValidator pageUpdateValidator, int id) {
        if (pageRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this pageId");
        } else if (userRepository.findById(pageUpdateValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else {
            InnerPage lastInnerPage = pageRepository.findById(id).get().getInnerPageList().get(pageRepository.findById(id).get().getInnerPageList().size() - 1);
            InnerPage innerPage = innerPageMapper.map(pageUpdateValidator, lastInnerPage.getVersion() + 1, userRepository.findById(pageUpdateValidator.getUserId()).get());
            innerPageRepository.save(innerPage);
            Page page = pageRepository.findById(id).get();
            page.addInnerPage(innerPage);
            pageRepository.save(page);
            return page;
        }
    }

    public Page deletePage(int id) {
        //TODO delete link
        if (!pageRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this pageId");
        } else {
            Page page = pageRepository.findById(id).get();
            pageRepository.delete(page);
            return page;
        }
    }

}
