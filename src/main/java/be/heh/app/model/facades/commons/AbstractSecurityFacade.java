package be.heh.app.model.facades.commons;

import be.heh.app.controller.services.security.UserSecurityService;
import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.facades.security.UserSecurityFacade;
import be.heh.app.model.repositories.security.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractSecurityFacade <T> extends AbstractFacade<T> {

    // Repository

    @Autowired
    UserSecurityRepository userSecurityRepository;

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
