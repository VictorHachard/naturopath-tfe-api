package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Ticket;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class TicketFacade extends AbstractFacade<Ticket> {

    public Ticket newInstance(UserSecurity userSecurity, String subject) {
        Ticket res = super.newInstance();
        res.setUserSecurity(userSecurity);
        res.setSubject(subject);
        res.setClose(false);
        return res;
    }

}
