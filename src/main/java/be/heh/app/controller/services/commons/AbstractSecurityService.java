package be.heh.app.controller.services.commons;

import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.facades.secutity.UserSecurityFacade;
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

    // Mapper

    @Autowired
    UserSecurityMapper userSecurityMapper;

    // Facade

    @Autowired
    UserSecurityFacade userSecurityFacade;

}
