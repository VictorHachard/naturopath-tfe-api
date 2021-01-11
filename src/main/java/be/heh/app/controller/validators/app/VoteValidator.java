package be.heh.app.controller.validators.app;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class VoteValidator {

    @NotNull(message = "")
    @Min(0)
    @Max(1)
    int vote;

    @NotNull(message = "")
    @Min(1)
    int userId;

}
