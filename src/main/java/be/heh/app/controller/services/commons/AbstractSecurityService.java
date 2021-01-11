package be.heh.app.controller.services.commons;

import be.heh.app.mappers.UserMapper;
import be.heh.app.mappers.security.UserSecurityMapper;
import be.heh.app.model.repositories.UserRepository;
import be.heh.app.model.repositories.UserSecurityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public abstract class AbstractSecurityService extends AbstractService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserSecurityMapper userSecurityMapper;

}
