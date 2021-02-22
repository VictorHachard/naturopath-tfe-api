package be.heh.app.controller.services.commons;

import be.heh.app.controller.services.security.CookieRememberMeService;
import be.heh.app.controller.services.security.UserSecurityService;
import be.heh.app.mappers.security.PermissionMapper;
import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.facades.security.CookieRememberMeFacade;
import be.heh.app.model.facades.security.RoleFacade;
import be.heh.app.model.facades.security.UserSecurityFacade;
import be.heh.app.model.repositories.security.CookieRememberMeRepository;
import be.heh.app.model.repositories.security.RoleRepository;
import be.heh.app.model.repositories.security.UserSecurityRepository;
import be.heh.app.springjwt.JwtUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public abstract class AbstractSecurityService<T> extends AbstractService<T> {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    // Repository

    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Autowired
    RoleRepository permissionRepository;

    @Autowired
    CookieRememberMeRepository cookieRememberMeRepository;

    // Mapper

    @Autowired
    UserSecurityMapper userSecurityMapper;

    @Autowired
    PermissionMapper permissionMapper;

    // Service

    @Autowired
    UserSecurityService userSecurityService;

    @Autowired
    CookieRememberMeService cookieRememberMeService;

    // Facade

    @Autowired
    UserSecurityFacade userSecurityFacade;

    @Autowired
    RoleFacade permissionFacade;

    @Autowired
    CookieRememberMeFacade cookieRememberMeFacade;

}
