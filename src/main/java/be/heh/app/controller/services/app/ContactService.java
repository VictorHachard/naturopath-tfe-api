package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.ContactValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.ContactViewDto;
import be.heh.app.model.entities.app.Contact;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ContactService extends AbstractService<Contact> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        ContactValidator validator = (ContactValidator) abstractValidator;
        Contact contact;
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            contact = contactMapper.set(validator, (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        } else {
            contact = contactMapper.set(validator);
        }
        contactRepository.save(contact);
    }

    public List<ContactViewDto> getAllDto() {
        //TODO return que ce de l'utilisateur si pas admin
        return contactMapper.getAllView(super.getAll());
    }

    /*public List<ContactViewDto> getAllDtoByUser() {
        UserSecurity u = (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (contactRepository.existsByUserSecurityId(u.getId())) {
            return contactMapper.getAllView(contactRepository.findAllByUserSecurityId(u.getId()).get());
        } else {
            return null;
        }
    }*/

    public ContactViewDto getDto(int id) {
        //TODO return que ce de l'utilisateur si pas admin
        return contactMapper.getView(super.get(id));
    }

}
