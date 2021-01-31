package be.heh.app.model.facades.security;

import be.heh.app.model.entities.security.Permission;
import be.heh.app.model.entities.security.enumeration.EnumPermission;
import be.heh.app.model.facades.commons.AbstractFacade;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
//Lombok
@Log
public class PermissionFacade extends AbstractFacade<Permission> {

    public Permission newInstance(EnumPermission e) {
        Permission res = new Permission();
        res.setEnumPermission(e);
        return res;
    }

}
