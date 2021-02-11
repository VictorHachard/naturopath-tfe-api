package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.TicketContentValidator;
import be.heh.app.controller.validators.app.TicketValidator;
import be.heh.app.dto.view.TicketViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/ticket/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TicketController extends AbstractController {

    @PostMapping("")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void add(@Valid @RequestBody TicketValidator validator) {
        ticketService.add(validator);
    }

    @PostMapping("addMessage/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void addMessage(@Valid @RequestBody TicketContentValidator validator, @PathVariable("id") int id) {
        ticketService.addMessage(validator, id);
    }

    @PostMapping("close/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void close(@PathVariable("id") int id) {
        ticketService.close(id);
    }

    @GetMapping("dto")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR')")
    public List<TicketViewDto> getAllDto() {
        return ticketService.getAllDto();
    }

    @GetMapping("dto/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR')")
    public TicketViewDto getDto(@PathVariable("id") int id) {
        return ticketService.getDto(id);
    }

    @GetMapping("dtoForUser")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public List<TicketViewDto> getAllDtoForUser() {
        return ticketService.getAllDtoForUser();
    }

    @GetMapping("dtoForUser/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public TicketViewDto getDtoForUser(@PathVariable("id") int id) {
        return ticketService.getDtoForUser(id);
    }

}
