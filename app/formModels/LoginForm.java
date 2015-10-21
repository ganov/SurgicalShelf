package formModels;

import play.data.validation.Constraints;

/**
 * UserForm Class
 * Created by ganovelli on 21/10/2015.
 */
public class LoginForm extends UserForm {
    @Constraints.Required
    public String password;
}