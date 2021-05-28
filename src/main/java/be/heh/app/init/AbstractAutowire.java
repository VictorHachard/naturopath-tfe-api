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
public abstract class AbstractAutowire {

    // Repository

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketContentRepository ticketContentRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    SortedTypeRepository sortedTypeRepository;

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
    InnerImageRepository innerImageRepository;

    @Autowired
    ImageRepository imageRepository;

    // Mapper

    @Autowired
    InnerPageMapper innerPageMapper;

    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    TicketContentMapper ticketContentMapper;

    @Autowired
    SortedTypeMapper sortedTypeMapper;

    @Autowired
    ParatagTypeMapper paratagTypeMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PageMapper pageMapper;

    @Autowired
    ParapageTypeMapper parapageTypeMapper;

    @Autowired
    InnerParatagMapper innerParatagMapper;

    @Autowired
    InnerParapageMapper innerParapageMapper;

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

    @Autowired
    ParapageMapper parapageMapper;

    @Autowired
    ParatagMapper paratagMapper;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    InnerImageMapper innerImageMapper;

    // Facade

    @Autowired
    CategoryFacade categoryFacade;

    @Autowired
    TicketContentFacade ticketContentFacade;

    @Autowired
    TicketFacade ticketFacade;

    @Autowired
    SortedTypeFacade sortedTypeFacade;

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
    MessageFacade messageFacade;

    @Autowired
    VoteFacade voteFacade;

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

    @Autowired
    InnerImageFacade innerImageFacade;

    // Service

    @Autowired
    InnerParatagService innerParatagService;

    @Autowired
    TagTypeService tagTypeService;

    @Autowired
    InnerImageService innerImageService;

    @Autowired
    ImageService imageService;

    @Autowired
    TicketService ticketService;

    @Autowired
    InnerTagService innerTagService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MessageService messageService;

    @Autowired
    PageService pageService;

    @Autowired
    InnerPageService innerPageService;

    @Autowired
    ParagraphService paragraphService;

    @Autowired
    ParagraphTypeService paragraphTypeService;

    @Autowired
    TagService tagService;

    @Autowired
    InnerParagraphService innerParagraphService;

    @Autowired
    VoteService voteService;

    @Autowired
    UserService userService;

    @Autowired
    ParatagTypeService paratagTypeService;

    @Autowired
    ParapageTypeService parapageTypeService;


}
