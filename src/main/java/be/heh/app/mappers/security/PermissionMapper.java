package be.heh.app.mappers.security;

import be.heh.app.init.AbstractSecurityAutowire;
import be.heh.app.model.entities.security.Role;
import be.heh.app.model.entities.security.enumeration.EnumRole;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class PermissionMapper extends AbstractSecurityAutowire {

    public Role set(EnumRole enumPermission) {
        return permissionFacade.newInstance(enumPermission);
    }

}