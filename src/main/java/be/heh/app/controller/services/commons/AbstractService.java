package be.heh.app.controller.services.commons;

import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.init.InitRepository;
import be.heh.app.mappers.app.*;
import be.heh.app.model.facades.app.*;
import be.heh.app.model.repositories.app.*;
import be.heh.app.model.repositories.commons.AbstractRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public abstract class AbstractService<I> {

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

    public List<I> getAll() {
        AbstractRepository repository = InitRepository.get(this.getClass());
        if (repository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        } else {
            return (List<I>) repository.findAll();
        }
    }

    public I get(int id) {
        AbstractRepository repository = InitRepository.get(this.getClass());
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        } else {
            return (I) repository.findById(id);
        }
    }

    public void add(AbstractValidator abstractValidator) {
    }

    public void update(AbstractValidator abstractValidator, int id) {
    }

    public void delete(int id) {
        AbstractRepository repository = InitRepository.get(this.getClass());
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        } else {
            repository.deleteById(id);
        }
    }

}
