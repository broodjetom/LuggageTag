/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.util.concurrent.Callable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Thomas
 */
public class ForgotPassword {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public ForgotPassword(LuggageUI UI, DatabaseManager db) {
        view.setPadding(new Insets(50, 50, 50, 50));
        
        Label heading = UI.createHeading("Recover password");
        view.add(heading, 1, 1);
        
        LuggageForm form = new LuggageForm(UI);
        form.add(heading);
        form.addRow();
        
        form.addLabel("Email: ");
        form.addTextField("email", true);
        form.addRow();
        
        Button goBack = UI.createGreyButton("Cancel", true, (Callable) () -> {
            Login login = new Login(UI, db);
            return true;
        });

        form.add(goBack);
        
        form.addSubmitButton("Recover");
        form.onSubmit( (Callable) () -> {
            String emailValue = form.get("email");

            return true;
        });
            

        view.add(form.toNode(), 1, 3);
        
        UI.setCenter(view);
        
    }
}
