package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.formModels.LoginForm;
import models.formModels.SignUpForm;
import models.BlogPost;
import models.User;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Application Controller provide end-to-end Authentication.
 * SignUp / login / logout
 */
public class Application extends Controller {

    public static Result signup() {
        Form<SignUpForm> signUpForm = Form.form(SignUpForm.class).bindFromRequest();

        if (signUpForm.hasErrors()) {
            return badRequest(signUpForm.errorsAsJson());
        }
        SignUpForm newUser = signUpForm.get();
        User existingUser = User.findByEmail(newUser.email);
        if (existingUser != null) {
            return badRequest(buildJsonResponse("error", "User exists"));
        } else {
            User user = new User();
            user.setEmail(newUser.email);
            user.setPassword(newUser.password);
            user.save();
            session().clear();
            session("username", newUser.email);

            return ok(buildJsonResponse("success", "User created successfully"));
        }
    }

    public static Result login() {
        Form<LoginForm> loginForm = Form.form(LoginForm.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(loginForm.errorsAsJson());
        }
        LoginForm loggingInUser = loginForm.get();
        User user = User.findByEmailAndPassword(loggingInUser.email, loggingInUser.password);
        if (user == null) {
            return badRequest(buildJsonResponse("error", "Incorrect email or password"));
        } else {
            session().clear();
            session("username", loggingInUser.email);

            ObjectNode wrapper = Json.newObject();
            ObjectNode msg = Json.newObject();
            msg.put("message", "Logged in successfully");
            msg.put("user", loggingInUser.email);
            wrapper.put("success", msg);
            return ok(wrapper);
        }
    }

    public static Result logout() {
        session().clear();
        return ok(buildJsonResponse("success", "Logged out successfully"));
    }

    public static Result isAuthenticated() {
        if (session().get("username") == null) {
            return unauthorized();
        } else {
            ObjectNode wrapper = Json.newObject();
            ObjectNode msg = Json.newObject();
            msg.put("message", "User is logged in already");
            msg.put("user", session().get("username"));
            wrapper.put("success", msg);
            return ok(wrapper);
        }
    }

    public static Result getPosts() {
        return ok(Json.toJson(BlogPost.find.findList()));
    }

    public static Result getPost(Long id) {
        BlogPost blogPost = BlogPost.findBlogPostById(id);
        if (blogPost == null) {
            return notFound(buildJsonResponse("error", "Post not found"));
        }
        return ok(Json.toJson(blogPost));
    }

    public static ObjectNode buildJsonResponse(String type, String message) {
        ObjectNode wrapper = Json.newObject();
        ObjectNode msg = Json.newObject();
        msg.put("message", message);
        wrapper.put(type, msg);
        return wrapper;
    }

}
