package be.heh.app.init;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.model.repositories.app.CategoryRepository;
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

    public static Map<String, AbstractService> serviceMap = new HashMap<>();

    @PostConstruct
    public void init() {
        CategoryRepository.class.getClass();

        /*Reflections reflections = new Reflections("be.heh.app.model.repositories.app");
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);

        System.out.println(allClasses.size());*/

        serviceMap.put("page", pageService);
        serviceMap.put("category", categoryService);
    }

}
