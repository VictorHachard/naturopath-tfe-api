package be.heh.app.init;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.repositories.UserRepository;
import be.heh.app.model.repositories.UserSecurityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInit {

    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Autowired
    UserRepository userRepository;

    static List<User> userList = new ArrayList<>() {
    };

    static {
        User user = new User();
        user.setBirth(new Date("06/06/1999"));
        user.setLang("EN");
        userList.add(user);
    }

    @PostConstruct
    public void init() {
        userList.forEach(user -> {
            userRepository.save(user);
            //userSecurityRepository.save(new UserSecurity());
        });
    }

}
