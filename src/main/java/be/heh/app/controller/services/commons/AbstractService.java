package be.heh.app.controller.services.commons;

import be.heh.app.mappers.app.*;
import be.heh.app.model.facades.app.*;
import be.heh.app.model.repositories.app.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public abstract class AbstractService {

    // Repository

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    InnerTagRepository innerTagRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    InnerParagraphRepository innerParagraphRepository;

    @Autowired
    UserRepository userRepository;

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
    ParatagFacade paratagFacade;

    /*public List<I> getAll() {
        if (categoryRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category in the database");
        } else {
            return categoryRepository.findAll();
        }
    }

    TypeVariable[] clazz = this.getClass().getTypeParameters();
    TypeVariable t = clazz[0];
    Constructor constructor = t.getClass().getDeclaredConstructors()[0];
        constructor.setAccessible(true);
    AbstractEntity obj = null;
        try {
        obj = (AbstractEntity) constructor.newInstance();
        obj.setCreatedAt(new Date());
    } catch (Exception e) {
        Logger.getLogger("AbstractRepository").info(e.getMessage());
    }
        return (I) obj;*/

}
