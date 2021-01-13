package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParatagTypeController extends AbstractController {

    /*@GetMapping("/paratagType")
    public List<ParatagType> getAllParatagType() {
        return paratagTypeService.getAll();
    }

    @GetMapping("/paratagType/{id}")
    public ParatagType getParatagType(@PathVariable("id") int id) {
        return paratagTypeService.get(id);
    }

    @PostMapping("/paratagType")
    public ParatagType insertParatagType(@Valid @RequestBody GeneralTypeValidator generalTypeValidator) {
        return paratagTypeService.insertParatagType(generalTypeValidator);
    }

    @PostMapping("/paratagType/{paratagTypeId}/linkToCategory/{categoryId}")
    public void linkParagraphTypeToCategory(@PathVariable("categoryId") int categoryId, @PathVariable("paratagTypeId") int paratagTypeId) {
        paratagTypeService.linkParatagTypeToCategory(categoryId, paratagTypeId);
    }*/

}
