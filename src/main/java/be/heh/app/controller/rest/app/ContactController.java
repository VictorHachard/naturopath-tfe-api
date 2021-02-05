package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.CategoryValidator;
import be.heh.app.controller.validators.app.ContactValidator;
import be.heh.app.dto.view.CategoryViewDto;
import be.heh.app.dto.view.ContactViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/contact/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ContactController extends AbstractController {

    @PostMapping("")
    public void add(@Valid @RequestBody ContactValidator validator) {
        contactService.add(validator);
    }

    @GetMapping("dto")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public List<ContactViewDto> getAllDto() {
        return contactService.getAllDto();
    }

    @GetMapping("dto/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR') or hasRole('OWNER')")
    public ContactViewDto getDto(@PathVariable("id") int id) {
        return contactService.getDto(id);
    }

}
