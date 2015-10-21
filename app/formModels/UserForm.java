package formModels;

import play.data.validation.Constraints;

/**
 * UserForm Class
 * Created by ganovelli on 21/10/2015.
 */
public class UserForm {
    @Constraints.Required
    @Constraints.Email
    public String email;
}