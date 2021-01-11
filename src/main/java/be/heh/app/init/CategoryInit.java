package be.heh.app.init;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.repositories.app.CategoryRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryInit {

    @Autowired
    CategoryRepository categoryRepository;

    static List<Category> categoryList = new ArrayList<>();

    static {
        Category category = new Category();
        category.setName("Plantes");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Huiles Essentielles");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Tisane");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Infusion");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Décoction");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Macération");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Sirop");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Cataplasme");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Onguent");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Teinture Mère");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Vins Médicinaux");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Comprimés");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
        category = new Category();
        category.setName("Fumigation");
        category.setDescription("");
        category.setLang("FR");
        categoryList.add(category);
    }

    @PostConstruct
    public void init() {
        categoryList.forEach(category -> {
            categoryRepository.save(category);
        });
    }

}
