package be.heh.app.controller.services;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.PageValidator;
import be.heh.app.mappers.InnerPageMapper;
import be.heh.app.mappers.PageMapper;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.repositories.CategoryRepository;
import be.heh.app.model.repositories.InnerPageRepository;
import be.heh.app.model.repositories.PageRepository;
import be.heh.app.model.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class PageService extends AbstractService {

    public List<Page> getAllPage() {
        if (pageRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page in the database");
        } else {
            return pageRepository.findAll();
        }
    }

    public Page getPage(int id) {
        if (pageRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this pageId");
        } else {
            return pageRepository.findById(id).get();
        }
    }

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
