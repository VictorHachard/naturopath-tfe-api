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
public class ParapageTypeController extends AbstractController {

    /*@GetMapping("/parapageType")
    public List<ParapageType> getAllParapageType() {
        return parapageTypeService.getAll();
    }

    @GetMapping("/parapageType/{id}")
    public ParapageType getParapageType(@PathVariable("id") int id) {
        return parapageTypeService.get(id);
    }

    @PostMapping("/parapageType")
    public ParapageType insertParapageType(@Valid @RequestBody GeneralTypeValidator generalTypeValidator) {
        return parapageTypeService.insertParapageType(generalTypeValidator);
    }

    @PostMapping("/parapageType/{parapageTypeeId}/linkToCategory/{categoryId}")
    public void linParapageTypeToCategory(@PathVariable("categoryId") int categoryId, @PathVariable("parapageTypeId") int parapageTypeId) {
        parapageTypeService.linkParapageTypeToCategory(categoryId, parapageTypeId);
    }*/

}
