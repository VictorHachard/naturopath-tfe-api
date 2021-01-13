package be.heh.app.controller.services.commons;

import be.heh.app.init.InitRepo;
import be.heh.app.mappers.app.*;
import be.heh.app.model.facades.app.*;
import be.heh.app.model.repositories.app.*;
import be.heh.app.model.repositories.commons.AbstractRepository;
import ch.qos.logback.core.encoder.EchoEncoder;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.lang.reflect.TypeVariable;
import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public class AbstractService<I> {

    // Repository

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

    // Mapper

    @Autowired
    InnerPageMapper innerPageMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PageMapper pageMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ParagraphMapper paragraphMapper;

    @Autowired
    ParagraphTypeMapper paragraphTypeMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    TagTypeMapper tagTypeMapper;

    @Autowired
    InnerTagMapper innerTagMapper;

    @Autowired
    InnerParagraphMapper innerParagraphMapper;

    @Autowired
    VoteMapper voteMapper;

    @Autowired
    MessageMapper messageMapper;

    // Facade

    @Autowired
    CategoryFacade categoryFacade;

    @Autowired
    InnerTagFacade innerTagFacade;

    @Autowired
    InnerPageFacade innerPageFacade;

    @Autowired
    InnerParagraphFacade innerParagraphFacade;

    @Autowired
    PageFacade pageFacade;

    @Autowired
    ParagraphTypeFacade paragraphTypeFacade;

    @Autowired
    TagTypeFacade tagTypeFacade;

    @Autowired
    InnerParapageFacade innerParapageFacade;

    @Autowired
    InnerParatagFacade innerParatagFacade;

    @Autowired
    ParatagTypeFacade paratagTypeFacade;

    @Autowired
    ParapageTypeFacade parapageTypeFacade;

    @Autowired
    ParapageFacade parapageFacade;

    @Autowired
    UserFacade userFacade;

    @Autowired
    ParatagFacade paratagFacade;

    Class typeObject;

    @PostConstruct
    public void init() {
        String className = this.getClass().getSimpleName().replace("Service", "");
        try {
            typeObject = Class.forName("be.heh.app.model.entities.app" + className);
        } catch (Exception e) {
            try {
                typeObject = Class.forName("be.heh.app.model.entities.app.security" + className);
            } catch (Exception e1) {}
        }
    }

    public List<I> getAll() {
        AbstractRepository repository = InitRepo.get(typeObject);
        if (repository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + typeObject.getSimpleName() + " in the database");
        } else {
            return (List<I>) repository.findAll();
        }
    }

}
