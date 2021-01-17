package be.heh.app.model.entities.security;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.security.enumeration.EnumPermission;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserSecurity implements Serializable {

    @Id
    @GeneratedValue
    int id;

    @OneToOne
    User user;

    @Column(name = "username", unique = true, nullable = false)
    String username;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    Date birth;

    @Column(name = "validation_token", unique = true)
    String validationToken;

    @Column(name = "confirm_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date confirmSet;

    @Column(name = "confirmed_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date confirmedAt;

    @Column(name = "reset_token", unique = true)
    String resetToken;

    @Column(name = "reset_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date resetSet;

    @Column(name = "reset_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date resetAt;

    @Column(name = "delete_token", unique = true)
    String deleteToken;

    @Column(name = "delete_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date deleteSet;

    @Column(name = "permission")
    @Enumerated(EnumType.STRING)
    EnumPermission enumPermission;

    @Column(name = "all_emails")
    int allEmails; // 0 - no, 1 - yes

    @Column(name = "accept_terms")
    int acceptTerms;

    @Column(name = "last_connection")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastConnection;

    @Column(name = "profile_privacy")
    int profilePrivacy; // 0 - private, 1 - public

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;

}
