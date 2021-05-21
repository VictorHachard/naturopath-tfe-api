package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.PageValidator;
import be.heh.app.controller.validators.app.view.PagesByCategoryDtoValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.dto.edit.PageEditDto;
import be.heh.app.dto.view.PageByCategoryViewDto;
import be.heh.app.dto.view.PageViewDto;
import be.heh.app.model.entities.app.*;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class PageService extends AbstractService<Page> {

    //TODO sort by category maybe
    public List<PageViewDto> getAllDto() { //ICI que les validated
        return pageMapper.getAllDto(super.getAll());
    }

    public List<PageEditDto> getAllEditDto() { //ICI tout
        return pageMapper.getAllEditDto(super.getAll());
    }

    public PageViewDto getDto(int id) {
        return pageMapper.getDto(super.get(id));
    }

    public PageEditDto getEditDto(int id) {
        return pageMapper.getEditDto(super.get(id));
    }

    public PageByCategoryViewDto getAllPageByCategoryDto(PagesByCategoryDtoValidator validator) {
        if (categoryRepository.findById(validator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        }
        //TODO findAllByCategory not empty
        if (validator.getLimit() != null && validator.getOffset() != null) {
            List<Page> pageList = pageRepository.findAllByCategoryById(validator.getCategoryId(), EnumState.VALIDATED);
            return pageMapper.getAllPageByCategoryDto(pageList.stream().skip(validator.getOffset()).limit(validator.getLimit()).collect(Collectors.toList()), pageList.size()); //TODO optimize the db acces
        } else {
            return pageMapper.getAllPageByCategoryDto(pageRepository.findAllByCategoryById(validator.getCategoryId(), EnumState.VALIDATED));
        }
    }

    public int addC(AbstractValidator abstractValidator) {
        PageValidator validator = (PageValidator) abstractValidator;
        Page page;
        if (categoryRepository.findById(validator.getCategoryId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else {
            User user = this.getUser();
            InnerPage innerPage = innerPageMapper.set(validator, user);
            innerPageRepository.save(innerPage);
            page = pageMapper.set(innerPage, categoryRepository.findById(validator.getCategoryId()).get(), user);
            //TODO si la category na pas de regle ne pas ajouter de liste
            page.getCategory().getSortedTypeList().forEach(sortedType -> {
                if (sortedType.getAbstractType() instanceof ParagraphType) {
                    page.addParagraph(paragraphMapper.set(innerParagraphMapper.set(user), (ParagraphType) sortedType.getAbstractType(), user));
                } else if (sortedType.getAbstractType() instanceof ParatagType) {
                    page.addParatag(paratagMapper.set(innerParatagMapper.set(user), (ParatagType) sortedType.getAbstractType(), user));
                }
            });
            page.getParagraphList().forEach(i -> {
                i.getInnerParagraphList().forEach(j -> {
                    innerParagraphRepository.save(j);
                });
                paragraphRepository.save(i);
            });
            page.getParatagList().forEach(i -> {
                i.getInnerParatagList().forEach(j -> {
                    innerParatagRepository.save(j);
                });
                paratagRepository.save(i);
            });
            pageRepository.save(page);
        }

        return page.getId();
    }

}
