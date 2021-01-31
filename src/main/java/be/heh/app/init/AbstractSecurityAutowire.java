package be.heh.app.init;

import be.heh.app.controller.services.security.UserSecurityService;
import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.facades.security.UserSecurityFacade;
import be.heh.app.model.repositories.security.PermissionRepository;
import be.heh.app.model.repositories.security.UserSecurityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PROTECTED)
@Log
public abstract class AbstractSecurityAutowire extends AbstractAutowire {

    // Repository

    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Autowired
    PermissionRepository permissionRepository;

    // Mapper

    @Autowired
    UserSecurityMapper userSecurityMapper;

    // Service

    @Autowired
    UserSecurityService userSecurityService;

    // Facade

    @Autowired
    UserSecurityFacade userSecurityFacade;

}
