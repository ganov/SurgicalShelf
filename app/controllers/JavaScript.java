package controllers;

import play.Routes;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Javascritp routes Controllers
 */
public class JavaScript extends Controller {
    /**
     * Router javascript.
     *
     * @return javascript's router
     */
    public static Result jsRoutes() {
        response().setContentType("text/javascript");
        return ok(
                /*For Ex.: Routes.javascriptRouter("jsRoutes", controllers.routes.javascript.Application.login())*/
        );
    }
}
