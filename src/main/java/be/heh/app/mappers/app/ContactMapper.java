package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.ContactValidator;
import be.heh.app.dto.view.ContactViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Contact;
import be.heh.app.model.entities.security.UserSecurity;
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
public class ContactMapper extends AbstractMapper {

    public Contact set(ContactValidator validator) {
        return contactFacade.newInstance(
                validator.getUsername(),
                validator.getEmail(),
                validator.getContent());
    }

    public Contact set(ContactValidator validator, UserSecurity userSecurity) {
        return contactFacade.newInstance(
                userSecurity,
                validator.getContent());
    }

    public List<ContactViewDto> getAllView(List<Contact> j) {
        List<ContactViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        //Collections.sort(res);
        return res;
    }

    public ContactViewDto getView(Contact contact) {
        return new ContactViewDto(
                contact.getId(),
                contact.getUserSecurity() != null ? contact.getUserSecurity().getId() : null,
                contact.getUsername() != null ? contact.getUsername() : null,
                contact.getEmail() != null ? contact.getEmail() : null,
                contact.getContent()
        );
    }

}
