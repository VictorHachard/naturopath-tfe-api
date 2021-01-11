package be.heh.app.controller.validators.app;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PageValidator {

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 8, max = 128)
    String title;

    @NotNull(message = "")
    @NotEmpty
    @Size(min = 64, max = 1024)
    String description;

    @NotNull(message = "")
    @Min(1)
    int categoryId;

    @NotNull(message = "")
    @Min(1)
    int userId;

}
