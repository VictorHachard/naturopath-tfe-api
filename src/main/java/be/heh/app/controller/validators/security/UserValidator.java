package be.heh.app.controller.validators.security;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserValidator {

    @NotNull(message = "")
    @NotEmpty
    String username;

    @NotNull(message = "")
    @NotEmpty
    @Email
    String email;

    @NotNull(message = "")
    @NotEmpty
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*])(?=\\S+$).{6,}", message = "Password must contain at least one lowercase, uppercase, numeric, special character and between six and sixteen characters")
    String password;

    @NotNull(message = "")
    @NotEmpty
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "Firstname must start with a capitalized letter")
    String first_name;

    @NotNull(message = "")
    @NotEmpty
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "Lastname must start with a capitalized letter")
    String last_name;

    @NotNull(message = "")
    String birth;

}
