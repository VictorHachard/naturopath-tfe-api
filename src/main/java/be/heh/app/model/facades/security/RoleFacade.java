package be.heh.app.model.facades.security;

import be.heh.app.model.entities.security.Role;
import be.heh.app.model.entities.security.enumeration.EnumRole;
import be.heh.app.model.facades.commons.AbstractFacade;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
//Lombok
@Log
public class RoleFacade extends AbstractFacade<Role> {

    public Role newInstance(EnumRole e) {
        Role res = new Role();
        res.setName( e);
        return res;
    }

}
