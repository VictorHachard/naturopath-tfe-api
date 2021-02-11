package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.TicketContent;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class TicketContentFacade extends AbstractFacade<TicketContent> {

    public TicketContent newInstance(String content, UserSecurity userSecurity) {
        TicketContent res = super.newInstance();
        res.setContent(content);
        res.setUserSecurity(userSecurity);
        return res;
    }

}
