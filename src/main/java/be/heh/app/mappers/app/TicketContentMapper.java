package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.TicketContentValidator;
import be.heh.app.controller.validators.app.TicketValidator;
import be.heh.app.dto.view.TicketContentViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.entities.app.TicketContent;
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
public final class TicketContentMapper extends AbstractMapper {

    @Autowired
    UserSecurityMapper userSecurityMapper;

    public TicketContent set(TicketValidator validator, UserSecurity userSecurity) {
        return ticketContentFacade.newInstance(
                validator.getContent(),
                userSecurity
        );
    }

    public TicketContent set(TicketContentValidator validator, UserSecurity userSecurity) {
        return ticketContentFacade.newInstance(
                validator.getContent(),
                userSecurity
        );
    }

    public List<TicketContentViewDto> getAllView(List<TicketContent> j) {
        List<TicketContentViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        Collections.reverse(res);
        return res;
    }

    public TicketContentViewDto getView(TicketContent j) {
        return new TicketContentViewDto(
                j.getId(),
                j.getCreatedAt(),
                userSecurityMapper.getSimplifiedViewDto(j.getUserSecurity()),
                j.getContent()
        );
    }

}
