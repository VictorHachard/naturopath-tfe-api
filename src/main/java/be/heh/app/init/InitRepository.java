package be.heh.app.init;

import be.heh.app.model.repositories.app.CategoryRepository;
import be.heh.app.model.repositories.commons.AbstractRepository;
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
public class InitRepository extends AbstractAutowire {

    public static Map<String, AbstractRepository> repositoryMap = new HashMap<>();

    @PostConstruct
    public void init() {
        CategoryRepository.class.getClass();

        /*Reflections reflections = new Reflections("be.heh.app.model.repositories.app");
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);

        System.out.println(allClasses.size());*/

        repositoryMap.put("Page", pageRepository);
        repositoryMap.put("Category", categoryRepository);
    }

    public static <T>T get(Class c) {
        return (T) repositoryMap.get(c.getSimpleName().replace("Service", ""));
    }

}
