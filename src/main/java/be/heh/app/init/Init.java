package be.heh.app.init;

import be.heh.app.controller.services.commons.AbstractSecurityService;
import be.heh.app.model.entities.app.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Init extends AbstractSecurityService {

    static List<User> userList = new ArrayList<>();
    static List<Category> categoryList = new ArrayList<>();
    static List<InnerPage> innerPageList = new ArrayList<>();
    static List<Page> pageList = new ArrayList<>();
    static List<TagType> tagTypeList = new ArrayList<>();
    static List<ParagraphType> paragraphTypeList = new ArrayList<>();

    public void initUser() {
        userList.add(userFacade.newInstance(new Date("06/06/1999"), "FR"));
    }

    public void initTagType() {

    }

    public void initParagraphType() {
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Habitat et culture", "")); //0
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Espèces voisines", "")); //1
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Usages traditionnels et courants", "")); //2
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Recherches en cours", "")); //3
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Parties utilisées", "")); //4
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Preparations et usages", "")); //5
        paragraphTypeList.add(paragraphTypeFacade.newInstance("Contradication", "")); //6
    }

    public void initCategory() {
        categoryList.add(categoryFacade.newInstance("Plantes", "")); //0
        categoryList.get(0).addParagraphType(paragraphTypeList.get(0));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(1));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(2));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(3));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(4));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(5));
        categoryList.get(0).addParagraphType(paragraphTypeList.get(6));
        categoryList.add(categoryFacade.newInstance("Huiles Essentielles", "")); //1
        categoryList.add(categoryFacade.newInstance("Tisane", "")); //2
        categoryList.add(categoryFacade.newInstance("Infusion", "")); //3
        categoryList.add(categoryFacade.newInstance("Décoction", "")); //4
        categoryList.add(categoryFacade.newInstance("Macération", "")); //5
        categoryList.add(categoryFacade.newInstance("Sirop", "")); //6
        categoryList.add(categoryFacade.newInstance("Cataplasme", "")); //7
        categoryList.add(categoryFacade.newInstance("Onguent", "")); //8
        categoryList.add(categoryFacade.newInstance("Teinture Mère", "")); //9
        categoryList.add(categoryFacade.newInstance("Vins Médicinaux", "")); //10
        categoryList.add(categoryFacade.newInstance("Comprimés", "")); //11
        categoryList.add(categoryFacade.newInstance("Fumigation", "")); //12
    }

    public void initPage() {
        innerPageList.add(innerPageFacade.newInstance("Lavande", "", userList.get(0)));
        pageList.add(pageFacade.newInstance(innerPageList.get(0), userList.get(0), categoryList.get(0)));
    }

    @PostConstruct
    public void init() {
        userList.forEach(user -> {
            userRepository.save(user);
            //userSecurityRepository.save(new UserSecurity());
        });
    }


}