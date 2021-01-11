package be.heh.app.controller.services.commons;

import be.heh.app.mappers.app.UserMapper;
import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.facades.app.UserFacade;
import be.heh.app.model.facades.secutity.UserSecurityFacade;
import be.heh.app.model.repositories.app.UserRepository;
import be.heh.app.model.repositories.security.UserSecurityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public abstract class AbstractSecurityService extends AbstractService {

    // Repository

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSecurityRepository userSecurityRepository;

    // Mapper

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserSecurityMapper userSecurityMapper;

    // Facade

    @Autowired
    UserFacade userFacade;

    @Autowired
    UserSecurityFacade userSecurityFacade;

}
