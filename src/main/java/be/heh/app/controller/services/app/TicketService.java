package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.TicketContentValidator;
import be.heh.app.controller.validators.app.TicketValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.view.TicketViewDto;
import be.heh.app.model.entities.app.Ticket;
import be.heh.app.model.entities.app.TicketContent;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TicketService extends AbstractService<Ticket> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        TicketValidator validator = (TicketValidator) abstractValidator;
        Ticket ticket = ticketMapper.set(validator, (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        TicketContent ticketContent = ticketContentMapper.set(validator, (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        ticket.add(ticketContent);
        ticketContentRepository.save(ticketContent);
        ticketRepository.save(ticket);
    }

    public void addMessage(AbstractValidator abstractValidator, int id) {
        TicketContentValidator validator = (TicketContentValidator) abstractValidator;
        Ticket ticket = super.get(id);
        TicketContent ticketContent = ticketContentMapper.set(validator, (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        ticket.add(ticketContent);
        ticketContentRepository.save(ticketContent);
        ticketRepository.save(ticket);
    }

    public void close(int id) {
        Ticket ticket = super.get(id);
        ticket.setClose(true);
        ticketRepository.save(ticket);
    }

    public List<TicketViewDto> getAllDto() {
        if (ticketRepository.existsAllOpen()) {
            return ticketMapper.getAllView(ticketRepository.findAllOpen().get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        }
    }

    public TicketViewDto getDto(int id) {
        return ticketMapper.getView(super.get(id));
    }

    public List<TicketViewDto> getAllDtoForUser() {
        UserSecurity userSecurity = (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (ticketRepository.existsByUserSecurityId(userSecurity.getId())) {
            return ticketMapper.getAllView(ticketRepository.findAllByUserSecurityId(userSecurity.getId()).get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        }
    }

    public TicketViewDto getDtoForUser(int id) {
        UserSecurity userSecurity = (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (ticketRepository.existsByUserSecurityId(userSecurity.getId())) {
            return ticketMapper.getView(ticketRepository.findByUserSecurityId(userSecurity.getId(), id).get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        }
    }

}
