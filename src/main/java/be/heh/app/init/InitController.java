package be.heh.app.init;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.services.app.*;
import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.model.repositories.app.CategoryRepository;
import be.heh.app.model.repositories.commons.AbstractRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InitController {

    @Autowired
    TagTypeService tagTypeService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MessageService messageService;

    @Autowired
    PageService pageService;

    @Autowired
    ParagraphService paragraphService;

    @Autowired
    ParagraphTypeService paragraphTypeService;

    @Autowired
    TagService tagService;

    @Autowired
    VoteService voteService;

    @Autowired
    UserService userService;

    @Autowired
    ParatagTypeService paratagTypeService;

    @Autowired
    ParapageTypeService parapageTypeService;

    public static Map<String, AbstractService> serviceMap = new HashMap<>();

    @PostConstruct
    public void init() {
        CategoryRepository.class.getClass();

        /*Reflections reflections = new Reflections("be.heh.app.model.repositories.app");
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);

        System.out.println(allClasses.size());*/

        serviceMap.put("Page", pageService);
        serviceMap.put("Category", categoryService);
    }

    public static <T>T get(Class c){
        System.out.println(c);
        return (T) serviceMap.get(c.getSimpleName().replace("Service", ""));
    }

}
