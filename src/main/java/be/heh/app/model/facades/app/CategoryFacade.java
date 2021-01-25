package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.SortedType;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFacade extends AbstractFacade<Category> {

    public Category newInstance(String name, String description, Category parentCategory, List<SortedType> sortedTypeList) {
        Category res = super.newInstance();
        this.updateInstance(
                res,
                name,
                description,
                parentCategory,
                sortedTypeList);
        return res;
    }

    public Category updateInstance(Category category, String name, String description, Category parentCategory, List<SortedType> sortedTypeList) {
        category.setName(name);
        category.setDescription(description);
        category.setParentCategory(parentCategory);
        category.addType(sortedTypeList);
        return category;
    }

    // Init
    public Category init(String name, String description, Category parentCategory) {
        Category res = super.newInstance();
        res.setName(name);
        res.setDescription(description);
        res.setParentCategory(parentCategory);
        return res;
    }

    // Init
    public Category init(String name, String description) {
        Category res = super.newInstance();
        res.setName(name);
        res.setDescription(description);
        return res;
    }

    /*public List<Category> getAllChildOfCategory(Category c) {
        TypedQuery<Category> typedQuery = entityManager.createNamedQuery(Category.GET_ALL_CHILD_OF_CATEGORY, Category.class);
        typedQuery.setParameter("category", c);
        return getList(typedQuery.getResultList())
                .stream()
                .sorted((c1, c2)->c1.getName().compareTo(c2.getName()))
                .collect(Collectors.toList());
    }

    public List<Category> getAllParent() {
        TypedQuery<Category> typedQuery = entityManager.createNamedQuery(Category.GET_ALL_PARENT, Category.class);
        return getList(typedQuery.getResultList())
                .stream()
                .sorted((c1, c2)->c1.getName().compareTo(c2.getName()))
                .collect(Collectors.toList());
    }*/

}
