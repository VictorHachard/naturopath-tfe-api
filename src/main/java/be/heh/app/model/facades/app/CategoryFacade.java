package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.*;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFacade extends AbstractFacade<Category> {

    @Autowired
    CategoryRepository categoryRepository;

    public Category newInstance(String name, String description, Category parentCategory, List<ParagraphType> paragraphTypeList, List<TagType> tagTypeList, List<ParapageType> parapageTypeList, List<ParatagType> paratagTypeList) {
        Category res = new Category();
        //Category res = super.newInstance(); //TODO
        this.updateInstance(res,
                name,
                description,
                parentCategory,
                paragraphTypeList,
                tagTypeList,
                parapageTypeList,
                paratagTypeList);
        return res;
    }

    public Category updateInstance(Category category, String name, String description, Category parentCategory, List<ParagraphType> paragraphTypeList, List<TagType> tagTypeList, List<ParapageType> parapageTypeList, List<ParatagType> paratagTypeList) {
        category.setName(name);
        category.setDescription(description);
        category.setParentCategory(parentCategory);
        category.addAllParagraphType(paragraphTypeList);
        category.addAllTagType(tagTypeList);
        category.addAllParapageType(parapageTypeList);
        category.addAllParatagType(paratagTypeList);
        return category;
    }

    public Category newInstance(String name, String description, Category parentCategory) {
        Category res = new Category();
        //Category res = super.newInstance(); //TODO
        res.setName(name);
        res.setDescription(description);
        res.setParentCategory(parentCategory);
        return res;
    }

    public Category newInstance(String name, String description) {
        Category res = new Category();
        //Category res = super.newInstance(); //TODO
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
