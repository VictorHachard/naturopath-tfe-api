package be.heh.app.controller.services.commons;

import be.heh.app.mappers.*;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.repositories.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public class AbstractService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PageRepository pageRepository;

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
    TagTypeRepository tagTypeRepository;

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

}
