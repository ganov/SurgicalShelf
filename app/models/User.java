package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;
import utils.PasswordUtils;

/**
 * Model representing the App user
 */
@Entity
public class User extends Model {

    @Id
    public Long id;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.MaxLength(255)
    @Constraints.Required
    @Constraints.Email
    public String email;

    @Column(length = 64, nullable = false)
    private byte[] shaPassword;

    public void setPassword(String password) {
        this.shaPassword = PasswordUtils.getSha512(password);
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public static final Finder<Long, User> FIND = new Finder<>(
            Long.class, User.class);

    public static User findByEmailAndPassword(String email, String password) {
        return FIND
                .where()
                .eq("email", email.toLowerCase())
                .eq("shaPassword", PasswordUtils.getSha512(password))
                .findUnique();
    }

    public static User findByEmail(String email) {
        return FIND
                .where()
                .eq("email", email.toLowerCase())
                .findUnique();
    }
}
