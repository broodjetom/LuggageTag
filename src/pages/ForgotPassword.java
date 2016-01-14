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
 * @author Tom Scholten
 */
public class ForgotPassword {

    private LuggageUI UI;
    private DatabaseManager db;

    private GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show forgot password page
     * @param UI
     */
   
    
    public ForgotPassword(LuggageUI UI) {
        view.setPadding(new Insets(50, 50, 50, 50));

        view.setPadding(new Insets(50, 50, 50, 50));
        UI.setCurPage("ForgotPassword");
        
        Label heading = UI.createHeading("Recover password");
        view.add(heading, 1, 1);

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);
        form.addRow();

        form.addLabel("If you forgot your password, go to a administrator to change it.");
        form.addRow();
        form.addSubmitButton("Back");
        form.onSubmit((Callable) () -> {

            pages.Login page = new pages.Login(UI);
            return true;
        });

        view.add(form.toNode(), 1, 3);

        UI.setCenter(view);

    }
}
