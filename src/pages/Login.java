/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.*;
import database.DatabaseManager;
import java.util.concurrent.Callable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javax.crypto.*;

/**
 *
 * @author Alex
 */
public class Login {

    private Cipher encrypter;
    private LuggageUI UI;
    private DatabaseManager db;

    private static final user.Session USER = user.Session.getInstance();

    public GridPane view = new GridPane();

    public Login(LuggageUI UI, DatabaseManager db) {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Log in");
        Label subtext = UI.createText("Log in with your log-in credentials");

        view.add(heading, 1, 1);
        view.add(subtext, 1, 2);

        LuggageForm form = new LuggageForm(UI);
        form.addLabel("Username: ");
        form.addTextField("email", true);
        form.addRow();
        form.addLabel("Password: ");
        form.addPassField("password", true);

        form.addRow();

        Button forgotPassword = UI.createGreyButton("Wachtwoord vergeten", false, (Callable) () -> {
            ForgotPassword ForgotPassword = new ForgotPassword(UI, db);
            return true;
        });

        //form.add(forgotPassword);
        form.addCol();

        form.addSubmitButton("Log In");
        form.onSubmit((Callable) () -> {

            String emailValue = (form.get("email"));
            String passwordValue = ""+form.get("password").hashCode();

            if (db.getCorrectForLogin(emailValue, passwordValue)) {
                USER.setUser(db.getUserForLogin(emailValue, passwordValue));
                if (USER.getUser().getEmployee() != 0) {
                    pages.menus.Employee menu = new pages.menus.Employee(UI, db);
                    SearchCustomer searchLuggage = new SearchCustomer(UI, db);
                } else if (USER.getUser().getManager() != 0) {
                    pages.menus.Manager menu = new pages.menus.Manager(UI, db);
                    Logs logs = new Logs(UI, db);
                } else if (USER.getUser().getAdmin() != 0) {
                    pages.menus.Administrator menu = new pages.menus.Administrator(UI, db);
                    pages.UsersPage users = new pages.UsersPage(UI, db);
                }
            } else {
                form.error("Email en/of wachtwoord incorrect\nProbeer het met andere gegevens\nOf ga naar uw manager");
            }
            return true;

        });

        view.add(form.toNode(), 1, 3);

        UI.setCenter(view);

        LuggageMenu menu = new LuggageMenu(UI);
        UI.setTop(menu.toNode());
    }

}
