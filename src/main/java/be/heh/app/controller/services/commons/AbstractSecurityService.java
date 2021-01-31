package be.heh.app.controller.services.commons;

import be.heh.app.controller.services.security.UserSecurityService;
import be.heh.app.mappers.security.PermissionMapper;
import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.facades.security.RoleFacade;
import be.heh.app.model.facades.security.UserSecurityFacade;
import be.heh.app.model.repositories.security.RoleRepository;
import be.heh.app.model.repositories.security.UserSecurityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public abstract class AbstractSecurityService<T> extends AbstractService<T> {

    // Repository

    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Autowired
    RoleRepository permissionRepository;

    // Mapper

    @Autowired
    UserSecurityMapper userSecurityMapper;

    @Autowired
    PermissionMapper permissionMapper;

    // Service

    @Autowired
    UserSecurityService userSecurityService;

    // Facade

    @Autowired
    UserSecurityFacade userSecurityFacade;

    @Autowired
    RoleFacade permissionFacade;

}
