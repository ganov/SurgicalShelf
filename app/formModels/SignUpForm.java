package formModels;

import play.data.validation.Constraints;

/**
 * UserForm Class
 * Created by ganovelli on 21/10/2015.
 */
public class SignUpForm extends UserForm {
    @Constraints.Required
    @Constraints.MinLength(6)
    public String password;
}