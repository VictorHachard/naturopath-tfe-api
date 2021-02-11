package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.TicketValidator;
import be.heh.app.dto.view.TicketViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.entities.app.Ticket;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TicketMapper extends AbstractMapper {

    @Autowired
    UserSecurityMapper userSecurityMapper;

    public Ticket set(TicketValidator validator, UserSecurity userSecurity) {
        return ticketFacade.newInstance(
                userSecurity,
                validator.getSubject()
        );
    }

    public List<TicketViewDto> getAllView(List<Ticket> j) {
        List<TicketViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        Collections.reverse(res);
        return res;
    }

    public TicketViewDto getView(Ticket j) {
        return new TicketViewDto(
                j.getId(),
                j.getCreatedAt(),
                userSecurityMapper.getSimplifiedViewDto(j.getUserSecurity()),
                j.getSubject(),
                j.isClose(),
                ticketContentMapper.getAllView(j.getTicketContentList())
        );
    }

}
