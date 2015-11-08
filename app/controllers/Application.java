package controllers;

import play.Play;
import play.api.mvc.Action;
import play.api.mvc.AnyContent;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * Main Application Controller.
 */
public class Application extends Controller {

    /**
     * Index : return home page.
     *
     * @return Page d'acceuil.
     */
    public static Result index() {
        return ok(index.render());
    }

    /**
     * Gestion Favicon en fonction de la property env.typ .
     * @return Action pour les routes.
     */
    public static Action<AnyContent> favicon() {

        return Assets.at("/public/images", "favicon.png", false);
    }
}
