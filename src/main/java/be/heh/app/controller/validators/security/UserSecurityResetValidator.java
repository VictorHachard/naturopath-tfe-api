package be.heh.app.controller.validators.security;

import be.heh.app.controller.validators.commons.AbstractValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserSecurityResetValidator extends AbstractValidator {

    @NotNull(message = "")
    @NotEmpty
    @Column(length = 60)
    String token;

    @NotNull(message = "")
    @NotEmpty
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*])(?=\\S+$).{6,}", message = "Password must contain at least one lowercase, uppercase, numeric, special character and between six and sixteen characters")
    String password;

}
