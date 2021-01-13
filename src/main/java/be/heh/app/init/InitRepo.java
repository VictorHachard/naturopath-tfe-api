package be.heh.app.init;

import be.heh.app.model.repositories.app.*;
import be.heh.app.model.repositories.commons.AbstractRepository;
import be.heh.app.model.repositories.security.UserSecurityRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InitRepo {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    InnerTagRepository innerTagRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    InnerParagraphRepository innerParagraphRepository;

    @Autowired
    InnerPageRepository innerPageRepository;

    @Autowired
    ParagraphRepository paragraphRepository;

    @Autowired
    ParagraphTypeRepository paragraphTypeRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    TagTypeRepository tagTypeRepository;

    @Autowired
    InnerParapageRepository innerParapageRepository;

    @Autowired
    InnerParatagRepository innerParatagRepository;

    @Autowired
    ParatagTypeRepository paratagTypeRepository;

    @Autowired
    ParapageTypeRepository parapageTypeRepository;

    @Autowired
    ParapageRepository parapageRepository;

    @Autowired
    ParatagRepository paratagRepository;

    @Autowired
    UserSecurityRepository userSecurityRepository;

    public static Map<String, AbstractRepository> repositoryMap = new HashMap<>();

    @PostConstruct
    public void init() {
        CategoryRepository.class.getClass();

        Reflections reflections = new Reflections("be.heh.app.model.repositories.app");
        Set<Class<?>> allClasses =
                reflections.getSubTypesOf(Object.class);

        System.out.println(allClasses.size());

        repositoryMap.put("Page",pageRepository);
    }

    public static <T>T get(Class c){
        return (T) repositoryMap.get(c.getSimpleName());
    }

}
