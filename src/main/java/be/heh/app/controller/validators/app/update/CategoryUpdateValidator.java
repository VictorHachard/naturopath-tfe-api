package be.heh.app.controller.validators.app.update;

import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.controller.validators.commons.Pair;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;
import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class CategoryUpdateValidator extends AbstractValidator {

    String name;

    String description;

    // For parent can be null
    Integer parentCategoryId;

    List<@Valid Pair> sortedTypeList;

}
