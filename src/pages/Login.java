/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.*;
import models.*;
import database.DatabaseManager;
import java.util.concurrent.Callable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alex
 */
public class Login {
    private LuggageUI UI;
    private DatabaseManager db;
    
    private static final user.Session USER = user.Session.getInstance();
    
    public GridPane view = new GridPane();
    
    public Login( LuggageUI UI, DatabaseManager db ){
        
        this.UI = UI;
        this.db = db;
        
        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Inloggen");
        Label subtext = UI.createText("Log in met uw account");

        view.add(heading, 1, 1);
        view.add(subtext, 1, 2);


        LuggageForm form = new LuggageForm(UI);
        form.addLabel("Email: ");
        form.addTextField("email", true);
        form.addRow();
        form.addLabel("Wachtwoord: ");
        form.addPassField("password", true);
        
        form.addRow();
        
        Button forgotPassword = UI.createGreyButton("Wachtwoord vergeten", false, (Callable) () -> {
            ForgotPassword ForgotPassword = new ForgotPassword(UI, db);
            return true;
        });

        form.add(forgotPassword);

        form.addSubmitButton("Log In");
        form.onSubmit( (Callable) () -> {
            String emailValue = form.get("email");
            String passwordValue = form.get("password");

            if( emailValue.equals("admin") && passwordValue.equals("test") ){
                USER.getUser().setId(1);
                USER.getUser().setFname("Tester");
                USER.getUser().setLname("Hallo");
                USER.getUser().setEe_num("NL_00012");
                pages.menus.Employee menu = new pages.menus.Employee(UI, db);
                SearchLuggage searchLuggage = new SearchLuggage(UI, db);
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
