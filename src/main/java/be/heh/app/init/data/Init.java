package be.heh.app.init.data;

import be.heh.app.init.AbstractSecurityAutowire;
import be.heh.app.model.entities.app.*;
import be.heh.app.model.entities.app.enumeration.EnumSize;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.entities.security.enumeration.EnumRole;
import be.heh.app.utils.Utils;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Init extends AbstractSecurityAutowire {

    Lorem lorem = LoremIpsum.getInstance();

    static List<User> userList = new ArrayList<>();
    static List<UserSecurity> userSecurityList = new ArrayList<>();
    static List<Category> categoryList = new ArrayList<>();

    static List<TagType> tagTypeList = new ArrayList<>();
    static List<ParagraphType> paragraphTypeList = new ArrayList<>();
    static List<ParapageType> parapageTypeList = new ArrayList<>();
    static List<ParatagType> paratagTypeList = new ArrayList<>();

    static List<Paragraph> paragraphList = new ArrayList<>();
    static List<Tag> tagList = new ArrayList<>();
    static List<Parapage> parapageList = new ArrayList<>();
    static List<Paratag> paratagList = new ArrayList<>();
    static List<Image> imageList = new ArrayList<>();
    static List<Page> pageList = new ArrayList<>();


    public void initUser() {
        User u = userFacade.init("Paulin");
        UserSecurity us = userSecurityFacade.newInstance("Paulin", "test@test.test", "Test123*");
        us.setIsDark(true);
        us.addPermission(permissionFacade.newInstance(EnumRole.ROLE_USER));
        us.addPermission(permissionFacade.newInstance(EnumRole.ROLE_MODERATOR));
        us.addPermission(permissionFacade.newInstance(EnumRole.ROLE_ADMINISTRATOR));
        us.addPermission(permissionFacade.newInstance(EnumRole.ROLE_OWNER));
        us.setUser(u);
        userSecurityList.add(us);
        userList.add(u);
    }

    public void initTagType() {
        tagTypeList.add(tagTypeFacade.newInstance("Nom latin", lorem.getWords(12, 16))); //0
        tagTypeList.add(tagTypeFacade.newInstance("Famille", lorem.getWords(12, 16))); //1

        tagTypeList.add(tagTypeFacade.newInstance("Principes actifs", lorem.getWords(12, 16))); //2
    }

    public void initParatagType() {
        paratagTypeList.add(paratagTypeFacade.newInstance("Nom latin" , lorem.getWords(12, 16), tagTypeList.get(0), EnumSize.SMALL)); //0
        paratagTypeList.add(paratagTypeFacade.newInstance("Famille" , lorem.getWords(12, 16), tagTypeList.get(1), EnumSize.SMALL)); //1
        paratagTypeList.add(paratagTypeFacade.newInstance("Principes actifs" , lorem.getWords(12, 16), tagTypeList.get(2), EnumSize.LARGE)); //2
    }

    public void initParapageType() {
        parapageTypeList.add(parapageTypeFacade.newInstance("Test1234" , lorem.getWords(12, 16))); //0
    }

    public void initParagraphType() {
        paragraphTypeList.addAll(Arrays.asList(
                paragraphTypeFacade.newInstance("Habitat et culture", lorem.getWords(12, 16)), //0
                paragraphTypeFacade.newInstance("Espèces voisines", lorem.getWords(12, 16)), //1
                paragraphTypeFacade.newInstance("Usages traditionnels et courants", lorem.getWords(12, 16)), //2
                paragraphTypeFacade.newInstance("Recherches en cours", lorem.getWords(12, 16)), //3
                paragraphTypeFacade.newInstance("Parties utilisées", lorem.getWords(12, 16)), //4
                paragraphTypeFacade.newInstance("Préparations et usages", lorem.getWords(12, 16)), //5
                paragraphTypeFacade.newInstance("Toxicité et contre-indication", lorem.getWords(12, 16)), //6
                paragraphTypeFacade.newInstance("Risques de confusions", lorem.getWords(12, 16)))); //7
    }

    public void initCategory() {
        categoryList.addAll(Arrays.asList(
                categoryFacade.init("Tisanes", lorem.getWords(12, 16), true) //0
                ));
        categoryList.addAll(Arrays.asList(
                categoryFacade.init("Plantes", lorem.getWords(12, 16)), //1
                categoryFacade.init("Huiles Essentielles", lorem.getWords(12, 16)), //2
                categoryFacade.init("Infusions", lorem.getWords(12, 16), categoryList.get(0)), //3
                categoryFacade.init("Décoctions", lorem.getWords(12, 16), categoryList.get(0)), //4
                categoryFacade.init("Macérations", lorem.getWords(12, 16), categoryList.get(0)), //5
                categoryFacade.init("Sirops", lorem.getWords(12, 16)), //6
                categoryFacade.init("Cataplasmes", lorem.getWords(12, 16)), //7
                categoryFacade.init("Onguents", lorem.getWords(12, 16)), //8
                categoryFacade.init("Teintures Mères", lorem.getWords(12, 16)), //9
                categoryFacade.init("Vins Médicinaux", lorem.getWords(12, 16)), //10
                categoryFacade.init("Comprimés", lorem.getWords(12, 16)), //11
                categoryFacade.init("Fumigations", lorem.getWords(12, 16)), //12
                categoryFacade.init("Huiles Végétales", lorem.getWords(12, 16)), //13
                categoryFacade.init("Plantes Fraîches", lorem.getWords(12, 16)), //14
                categoryFacade.init("Élixirs", lorem.getWords(12, 16)), //15
                categoryFacade.init("Macérats Huileux", lorem.getWords(12, 16)), //16
                categoryFacade.init("Poudres", lorem.getWords(12, 16)), //17
                categoryFacade.init("Gélules", lorem.getWords(12, 16)), //18
                categoryFacade.init("Bains de Plantes", lorem.getWords(12, 16)), //19
                categoryFacade.init("Bains de Bouche ou Gargarismes", lorem.getWords(12, 16)), //20
                categoryFacade.init("Bains Oculaire", lorem.getWords(12, 16)), //21
                categoryFacade.init("Collyres", lorem.getWords(12, 16)), //22
                categoryFacade.init("Baumes", lorem.getWords(12, 16)), //23
                categoryFacade.init("Gels", lorem.getWords(12, 16)), //24
                categoryFacade.init("Pommades", lorem.getWords(12, 16)), //25
                categoryFacade.init("Hydrolats", lorem.getWords(12, 16)), //26
                categoryFacade.init("Macérats de Bourgeons", lorem.getWords(12, 16)), //27
                categoryFacade.init("Élixirs Floraux ou Fleurs de Bach", lorem.getWords(12, 16)))); //28

        // Plantes - 0

        for (Category c : categoryList) {
            if (c.isParent()) {
                continue;
            }
            int index = 1;
            for (int i : Utils.getRandomIdListUnique((paragraphTypeList.size() -1) / 2, paragraphTypeList.size() -1, paragraphTypeList.size() -1)) { //TOOD pas random le numbre avec la liste size
                c.addType(sortedTypeFacade.newInstance(paragraphTypeList.get(i), index));
                index++;
            }
            for (int i : Utils.getRandomIdListUnique((paratagTypeList.size() -1) / 2, paratagTypeList.size() -1, paratagTypeList.size() -1)) {
                c.addType(sortedTypeFacade.newInstance(paratagTypeList.get(i), index));
                index++;
            }
        }

        /*categoryList.get(1).addType(
            sortedTypeFacade.newInstance(paragraphTypeList.get(0), 3),
            sortedTypeFacade.newInstance(paragraphTypeList.get(1), 4),
            sortedTypeFacade.newInstance(paragraphTypeList.get(2), 5),
            sortedTypeFacade.newInstance(paragraphTypeList.get(3), 6),
            sortedTypeFacade.newInstance(paragraphTypeList.get(4), 7),
            sortedTypeFacade.newInstance(paragraphTypeList.get(5), 8),
            sortedTypeFacade.newInstance(paragraphTypeList.get(6), 9),
            sortedTypeFacade.newInstance(paragraphTypeList.get(7), 10),

            sortedTypeFacade.newInstance(paratagTypeList.get(0), 1),
            sortedTypeFacade.newInstance(paratagTypeList.get(1), 2),
            sortedTypeFacade.newInstance(paratagTypeList.get(2), 11)

        );*/

    }

    public void initTag() {
        tagList.add(tagFacade.init(innerTagFacade.init("Acides-phénols", lorem.getWords(12, 16)), tagTypeList.get(2))); //0
        tagList.add(tagFacade.init(innerTagFacade.init("Huile essentielle", lorem.getWords(12, 16)), tagTypeList.get(2))); //1
        tagList.add(tagFacade.init(innerTagFacade.init("Triterpènes", lorem.getWords(12, 16)), tagTypeList.get(2))); //2
        tagList.add(tagFacade.init(innerTagFacade.init("Cires", lorem.getWords(12, 16)), tagTypeList.get(2))); //3
        tagList.add(tagFacade.init(innerTagFacade.init("Flavonoïdes", lorem.getWords(12, 16)), tagTypeList.get(2))); //4

        tagList.add(tagFacade.init(innerTagFacade.init("Lamiacées", lorem.getWords(12, 16)), tagTypeList.get(1))); //5

        tagList.add(tagFacade.init(innerTagFacade.init("Mentha x piperita L", lorem.getWords(12, 16)), tagTypeList.get(0))); //6
    }

    public void initParatag() {
        InnerParatag i = innerParatagFacade.init("tr", "");
        i.addTag(tagList.get(0), tagList.get(1),tagList.get(2),tagList.get(3), tagList.get(4));
        paratagList.add(paratagFacade.init(i, paratagTypeList.get(2)));

        i = innerParatagFacade.init("tr", "");
        i.addTag(tagList.get(6));
        paratagList.add(paratagFacade.init(i, paratagTypeList.get(0)));

        i = innerParatagFacade.init("tr", "");
        i.addTag(tagList.get(5));
        paratagList.add(paratagFacade.init(i, paratagTypeList.get(1)));
    }

    public void initParagraph() {
        paragraphList.add(paragraphFacade.init(innerParagraphFacade.init("Super para", "C’est une plante herbacée aromatique, vivace, à stolons traçants, pouvant atteindre 0,60 cm a 1m de hauteur. C’est un hybride entre la menthe aquatique (Mentha aquatica) et la menthe verte (Mentha spicata). La Menthe est originaire d’Angleterre.  Généralement cultivée, on la trouve maintenant en Europe en Asie et en Amérique du Nord. La menthe poivrée se plaire sur une terre aérée et pas trop humide, dans un endroit a moitié ombragé. Nous pouvons récolter la plante en été, avant la floraison. Il est possible de rabattre la plante en été afin de la forcer à produire une autre mise à fleur."), paragraphTypeList.get(0))); //0
        paragraphList.add(paragraphFacade.init(innerParagraphFacade.init("Super para", "La menthe aquatique (Mentha aquatica) et la menthe verte (Mentha spicata) ont des vertus médicinales plus ou moins identiques bien que moins prononcées."), paragraphTypeList.get(1))); //1
        paragraphList.add(paragraphFacade.init(innerParagraphFacade.init("Super para", "att"), paragraphTypeList.get(2))); //2
        paragraphList.add(paragraphFacade.init(innerParagraphFacade.init("Super para", "L’huile essentielle est très antibactérienne. Le menthol est l’un de ces principaux constituants. Il est antiseptique, fongicide, et anesthésiante pour la peau. Elle peut être sur certaines personnes irritante.\n" +
                "Lorsque la menthe poivrée est entière, elle a un effet antispasmodique sur l’appareil digestif. Des etudes ont prouvés son efficacité pour lutter contre les inflammations du colon."), paragraphTypeList.get(3))); //3
        paragraphList.add(paragraphFacade.init(innerParagraphFacade.init("Super para", "La partie aérienne, idéalement les feuilles."), paragraphTypeList.get(4))); //4
        paragraphList.add(paragraphFacade.init(innerParagraphFacade.init("Super para", "L’infusion, boire 150ml après chaque repas pour une meilleure digestion.\n" +
                "Remarque :\n" +
                "En infusion courte (2-3 minutes) la plante aura des vertus stimulantes et excitantes.\n" +
                "En infusion longue (5-10 minutes) la plante aura des vertus calmantes et sédatives.\n" +
                "La lotion, faite à partir de l’infusion s’utilisera sur les peaux irritées.\n" +
                "L’Huile essentielle, la diluer et se masser les tempes avec, en cas de maux de têtes."), paragraphTypeList.get(5))); //4
        paragraphList.add(paragraphFacade.init(innerParagraphFacade.init("Super para", "Ne pas utiliser la menthe poivrée chez les enfants de moins de 7 ans.\n" +
                "Ne pas utiliser l’huile essentielle de menthe poivrée chez les enfants de moins de 12 ans.\n" +
                "Elle ne possède pas vraiment de toxicité chez les plus âgés, mais il reste conseillé de l’utiliser en doses modérées, car à haute dose, elle peut mener a des états d’agitation nocturne et/ou a des phases de cauchemars.\n" +
                "De plus, la plante ne doit pas être utilisée simultanément avec des plantes contenant du camphre ou du thymol ni lors d’un traitement a base de résine végétales."), paragraphTypeList.get(6))); //4
        paragraphList.add(paragraphFacade.init(innerParagraphFacade.init("Super para", "Aucune."), paragraphTypeList.get(7))); //4
    }

    public void initImage() {
        Image image = imageFacade.init(innerImageFacade.init("Menthe poivrée", lorem.getWords(12, 16), "init-m-1.jpg"));

        imageList.add(image); //0
    }

    public void initPage() {
        Page page = pageFacade.init(innerPageFacade.init("Menthe poivrée", lorem.getWords(12, 16), imageList.get(0)),
                categoryList.get(1));

        page.addParagraph(paragraphList.get(0), paragraphList.get(1), paragraphList.get(2), paragraphList.get(3), paragraphList.get(4), paragraphList.get(5), paragraphList.get(6), paragraphList.get(7));

        page.addParatag(paratagList.get(0), paratagList.get(1), paratagList.get(2));

        pageList.add(page); //0
    }

    @PostConstruct
    public void init() {
        initUser();
        userSecurityList.forEach(user -> {
            user.getEnumPermissionList().forEach(p -> {
                permissionRepository.save(p);
            });
            userRepository.save(user.getUser());
            userSecurityRepository.save(user);
        });

        initParagraphType();
        initTagType();
        initParapageType();
        initParatagType();

        initCategory();

        initTag();
        initParatag();
        initParagraph();

        initImage();
        initPage();

        System.out.println(paragraphTypeList);

        paragraphTypeList.forEach(user -> {
            paragraphTypeRepository.save(user);
        });
        tagTypeList.forEach(user -> {
            tagTypeRepository.save(user);
        });
        paratagTypeList.forEach(paratagType -> {
            paratagTypeRepository.save(paratagType);
        });
        categoryList.forEach(i -> {
            if (i.getSortedTypeList() != null)
                i.getSortedTypeList().forEach(j -> {
                    sortedTypeRepository.save(j);
                });
            categoryRepository.save(i);
        });
        paragraphList.forEach(i -> {
            i.getInnerParagraphList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerParagraphRepository.save(j);
            });
            paragraphRepository.save(i);
        });
        tagList.forEach(i -> {
            i.getInnerTagList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerTagRepository.save(j);
            });
            tagRepository.save(i);
        });
        parapageList.forEach(i -> {
            i.getInnerParapageList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerParapageRepository.save(j);
            });
            parapageRepository.save(i);
        });
        paratagList.forEach(i -> {
            i.getInnerParatagList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerParatagRepository.save(j);
            });
            paratagRepository.save(i);
        });
        imageList.forEach(i -> {
            i.getInnerImageList().forEach(j -> {
                innerImageRepository.save(j);
            });
            imageRepository.save(i);
        });
        pageList.forEach(i -> {
            i.getInnerPageList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerPageRepository.save(j);
            });
            pageRepository.save(i);
        });
    }

}
