package be.heh.app.init;

import be.heh.app.controller.services.app.*;
import be.heh.app.mappers.app.*;
import be.heh.app.model.facades.app.*;
import be.heh.app.model.repositories.app.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PROTECTED)
@Log
public class AbstractAutowire {

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

    @Autowired
    ParagraphFacade paragraphFacade;

    @Autowired
    TagFacade tagFacade;

    @Autowired
    ImageFacade imageFacade;

    // Service

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

}
