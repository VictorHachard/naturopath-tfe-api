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
    String first_name;

    @Column(name = "last_name")
    String last_name;

    @Column(name = "validation_token", unique = true)
    String validation_token;

    @Column(name = "confirm_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date confirm_set;

    @Column(name = "confirmed_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date confirmed_at;

    @Column(name = "reset_token", unique = true)
    String reset_token;

    @Column(name = "reset_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date reset_set;

    @Column(name = "reset_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date reset_at;

    @Column(name = "delete_token", unique = true)
    String delete_token;

    @Column(name = "delete_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date delete_set;

    @Column(name = "permission")
    @Enumerated(EnumType.STRING)
    EnumPermission enumPermission;

    @Column(name = "all_emails")
    int all_emails;

    @Column(name = "accept_terms")
    int accept_terms;

    @Column(name = "last_connection")
    @Temporal(TemporalType.TIMESTAMP)
    Date last_connection;

    @Column(name = "profile_privacy")
    int profile_privacy;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date created_at;

}
