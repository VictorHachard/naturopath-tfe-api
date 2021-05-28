package be.heh.app.controller.validators.app.validation;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class InnerParatagValidationValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 8, max = 128)
    String title;

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 64, max = 8182)
    String content;

    @NotNull(message = "")
    @NotEmpty
    List<Integer> tagIdList;

}
