package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.InnerPageValidator;
import be.heh.app.controller.validators.app.update.InnerPageUpdateValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerPageService extends AbstractService<InnerPage> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        //TODO verifiaction
        InnerPageValidator validator = (InnerPageValidator) abstractValidator;
        Page page = pageRepository.findById(validator.getPageId()).get();
        InnerPage innerPage = innerPageMapper.set(validator, this.getUser());
        innerPageRepository.save(innerPage);
        page.addInnerPage(innerPage);
        pageRepository.save(page);
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        //TODO verifiaction
        InnerPageUpdateValidator validator = (InnerPageUpdateValidator) abstractValidator;
        InnerPage innerPage = innerPageRepository.findById(id).get();
        innerPageMapper.update(innerPage, validator);
        innerPageRepository.save(innerPage);
    }

    public void validation(int id) {
        //TODO verifiaction
        InnerPage innerPage = innerPageRepository.findById(id).get();
        innerPage.setEnumState(EnumState.VALIDATING);
        innerPageRepository.save(innerPage);
    }

}
