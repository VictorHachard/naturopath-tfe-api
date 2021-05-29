package be.heh.app.mappers.app;

import be.heh.app.dto.edit.PageEditDto;
import be.heh.app.dto.view.PageByCategoryViewDto;
import be.heh.app.dto.view.PageSimplifiedViewDto;
import be.heh.app.dto.view.PageViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class PageMapper extends AbstractMapper {

    public Page set(InnerPage innerPage, Category category, User user) {
        return pageFacade.newInstance(
                innerPage,
                user,
                category);
    }

    public List<PageViewDto> getAllDto(List<Page> pageList) {
        List<PageViewDto> pageDtoList = new ArrayList<>();
        pageList.forEach(page -> {
            pageDtoList.add(this.getDto(page));
        });
        return pageDtoList;
    }

    public List<PageEditDto> getAllEditDto(List<Page> pageList) {
        List<PageEditDto> pageDtoList = new ArrayList<>();
        pageList.forEach(page -> {
            pageDtoList.add(this.getEditDto(page));
        });
        return pageDtoList;
    }

    public PageViewDto getDto(Page page) {
        List<InnerPage> innerPageList = pageRepository.findInnerPage(page, EnumState.VALIDATED);
        InnerPage innerPage;

        if (innerPageList.isEmpty()) { //TODO remove
            return null;
        } else {
            innerPage = innerPageList.get(0);
        }

        return new PageViewDto(
                page.getId(),
                page.getEnumState().toString(),
                page.getCreatedAt(),
                categoryMapper.getView(page.getCategory()),
                userMapper.getView(page.getUser()),
                innerPage.getTitle(),
                innerPage.getDescription(),
                paragraphMapper.getAllView(page.getParagraphList()),
                parapageMapper.getAllView(page.getParapageList()),
                paratagMapper.getAllView(page.getParatagList()),
                imageMapper.getView(innerPage.getImage()),
                sortedTypeMapper.getAllView(page.getCategory().getSortedTypeList())
        );
    }

    public PageByCategoryViewDto getAllPageByCategoryDto(List<Page> pageList) {
        return this.getAllPageByCategoryDto(pageList, pageList.size());
    }

    public PageByCategoryViewDto getAllPageByCategoryDto(List<Page> pageList, int size) {
        List<PageSimplifiedViewDto> res = new ArrayList<>();
        pageList.forEach(i -> {
            InnerPage innerPage = pageRepository.findInnerPage(i, EnumState.VALIDATED).get(0);

            res.add(new PageSimplifiedViewDto(
                    i.getId(),
                    i.getCreatedAt(),
                    innerPage.getTitle(),
                    innerPage.getDescription(),
                    imageMapper.getImageForPageByCategoryView(innerPage.getImage())
            ));
        });
        return new PageByCategoryViewDto(size, res);
    }

    public PageEditDto getEditDto(Page page) {
        return new PageEditDto(
                page.getId(),
                page.getEnumState().toString(),
                categoryMapper.getView(page.getCategory()),
                userMapper.getView(page.getUser()),
                innerPageMapper.getAllEditDto(page.getInnerPageList()),
                paragraphMapper.getAllEditDto(page.getParagraphList()),
                paratagMapper.getAllEditDto(page.getParatagList()),
                parapageMapper.getAllEditDto(page.getParapageList())
        );
    }

}
