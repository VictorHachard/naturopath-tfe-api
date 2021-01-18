package be.heh.app.init;

import be.heh.app.controller.services.commons.AbstractService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InitService extends AbstractAutowire {

    /*public static Map<String, AbstractService> serviceMap = new HashMap<>();

    @PostConstruct
    public void init() {
        serviceMap.put("page", pageService);
        serviceMap.put("category", categoryService);
    }

    public static <T>T get(Class c) {
        return (T) serviceMap.get(c.getSimpleName().replace("Service", "")); //TODO
    }*/

}
