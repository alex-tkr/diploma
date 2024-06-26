/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ua.nure.calendar.web;

import ua.nure.calendar.services.ServicesConfiguration;
import ua.nure.calendar.web.api.user.SignInRoute;

import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class Application {

    public static void main(String[] args) {
        var context = new ServicesConfiguration();
        staticFiles.location("/web-client");
        post("api/sign-in", new SignInRoute(context.userService()));
    }
}
