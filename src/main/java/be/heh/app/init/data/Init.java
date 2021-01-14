package be.heh.app.init.data;

import be.heh.app.init.AbstractAutowire;
import be.heh.app.model.entities.app.*;
import be.heh.app.model.repositories.app.TagRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Init extends AbstractAutowire {

    static List<User> userList = new ArrayList<>();
    static List<Category> categoryList = new ArrayList<>();

    static List<TagType> tagTypeList = new ArrayList<>();
    static List<ParagraphType> paragraphTypeList = new ArrayList<>();
    static List<ParapageType> parapageTypeList = new ArrayList<>();
    static List<ParatagType> paratagTypeList = new ArrayList<>();

    static List<InnerParagraph> innerParagraphList = new ArrayList<>();
    static List<Paragraph> paragraphs = new ArrayList<>();

    static List<InnerTag> innerTagList = new ArrayList<>();
    static List<Tag> tagList = new ArrayList<>();

    static List<InnerParapage> innerParapageList = new ArrayList<>();
    static List<Parapage> parapageList = new ArrayList<>();

    static List<InnerParatag> innerParatagList = new ArrayList<>();
    static List<Paratag> paratagList = new ArrayList<>();

    static List<InnerImage> innerImageList = new ArrayList<>();
    static List<Image> imageList = new ArrayList<>();

    static List<InnerPage> innerPageList = new ArrayList<>();
    static List<Page> pageList = new ArrayList<>();


    public void initUser() {
        userList.add(userFacade.newInstance("FR"));
    }

    public void initTagType() {
        tagTypeList.add(tagTypeFacade.newInstance("Nom latin", "")); //0
        tagTypeList.add(tagTypeFacade.newInstance("Famille", "")); //1

        tagTypeList.add(tagTypeFacade.newInstance("Principes actifs", "")); //2
    }

    public void initParatagType() {
        paratagTypeList.add(paratagTypeFacade.newInstance("Principes actifs" , "", tagTypeList.get(2))); //1
    }

    public void initParagraphType() {
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Habitat et culture", "")); //0
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Espèces voisines", "")); //1
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Usages traditionnels et courants", "")); //2
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Recherches en cours", "")); //3
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Parties utilisées", "")); //4
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Preparations et usages", "")); //5
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Toxicité et contre-indication", "")); //6
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Synonymes", "")); //7
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Risques de confusions", "")); //8
    }

    public void initCategory() {
        categoryList.add(categoryFacade.newInstance("Plantes", "")); //0
        //categoryList.get(0).setOrder(1);
        categoryList.get(0).addParagraphType(paragraphTypeList.get(0));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(1));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(2));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(3));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(4));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(5));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(6));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(7));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(8));

        categoryList.get(0).addParatagType(paratagTypeList.get(1));

        categoryList.get(0).addTagType(tagTypeList.get(1));
        categoryList.get(0).addTagType(tagTypeList.get(2));

        categoryList.add(categoryFacade.newInstance("Huiles Essentielles", "")); //1
        categoryList.add(categoryFacade.newInstance("Tisanes", "")); //2
        categoryList.add(categoryFacade.newInstance("Infusions", "")); //3
        categoryList.get(3).setParentCategory(categoryList.get(2));
        categoryList.add(categoryFacade.newInstance("Décoctions", "")); //4
        categoryList.get(4).setParentCategory(categoryList.get(2));
        categoryList.add(categoryFacade.newInstance("Macérations", "")); //5
        categoryList.get(5).setParentCategory(categoryList.get(2));
        categoryList.add(categoryFacade.newInstance("Sirops", "")); //6
        categoryList.add(categoryFacade.newInstance("Cataplasmes", "")); //7
        categoryList.add(categoryFacade.newInstance("Onguents", "")); //8
        categoryList.add(categoryFacade.newInstance("Teintures Mères", "")); //9
        categoryList.add(categoryFacade.newInstance("Vins Médicinaux", "")); //10
        categoryList.add(categoryFacade.newInstance("Comprimés", "")); //11
        categoryList.add(categoryFacade.newInstance("Fumigations", "")); //12
        categoryList.add(categoryFacade.newInstance("Huiles Végétales", "")); //13
        categoryList.add(categoryFacade.newInstance("Plantes Fraîches", "")); //14
        categoryList.add(categoryFacade.newInstance("Élixirs", "")); //15
        categoryList.add(categoryFacade.newInstance("Macérats Huileux", "")); //16
        categoryList.add(categoryFacade.newInstance("Poudres", "")); //17
        categoryList.add(categoryFacade.newInstance("Gélules", "")); //18
        categoryList.add(categoryFacade.newInstance("Bains de Plantes", "")); //19
        categoryList.add(categoryFacade.newInstance("Bains de Bouche ou Gargarismes", "")); //20
        categoryList.add(categoryFacade.newInstance("Bains d’Yeux", "")); //21
        categoryList.add(categoryFacade.newInstance("Collyres", "")); //22
        categoryList.add(categoryFacade.newInstance("Beaumes", "")); //23
        categoryList.add(categoryFacade.newInstance("Gels", "")); //24
        categoryList.add(categoryFacade.newInstance("Pommades", "")); //25
        categoryList.add(categoryFacade.newInstance("Hydrolats", "")); //26
        categoryList.add(categoryFacade.newInstance("Macérats de Bourgeons", "")); //27
        categoryList.add(categoryFacade.newInstance("Élixirs floraux ou Fleurs de Bach", "")); //28

    }

    public void initPage() {
        innerPageList.add(innerPageFacade.newInstance("Lavande", "", userList.get(0))); //0

        pageList.add(pageFacade.newInstance(innerPageList.get(0), userList.get(0), categoryList.get(0))); //0
        pageList.get(0).addTag();
    }

    public void initTag() {
        innerTagList.add(innerTagFacade.newInstance("Phénols", "", userList.get(0))); //0
        innerTagList.add(innerTagFacade.newInstance("Astéracées", "", userList.get(0))); //1

        tagList.add(tagFacade.newInstance(innerTagList.get(0), tagTypeList.get(2), userList.get(0))); //0
        tagList.add(tagFacade.newInstance(innerTagList.get(1), tagTypeList.get(1), userList.get(0))); //1
    }

    @PostConstruct
    public void init() {
        initUser();
        initParagraphType();
        initTagType();
        initParatagType();
        initCategory();
        initPage();
        userList.forEach(user -> {
            userRepository.save(user);
        });
        paragraphTypeList.forEach(user -> {
            paragraphTypeRepository.save(user);
        });
        tagTypeList.forEach(user -> {
            tagTypeRepository.save(user);
        });
        paratagTypeList.forEach(paratagType -> {
            paratagTypeRepository.save(paratagType);
        });
        categoryList.forEach(user -> {
            categoryRepository.save(user);
        });
        innerPageList.forEach(user -> {
            innerPageRepository.save(user);
        });
        innerTagList.forEach(innerTag -> {
            innerTagRepository.save(innerTag);
        });
        tagList.forEach(tag -> {
            tagRepository.save(tag);
        });
        pageList.forEach(user -> {
            pageRepository.save(user);
        });
    }


}
