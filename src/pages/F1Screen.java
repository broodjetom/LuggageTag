/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.LuggageUI;
import database.DatabaseManager;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import UI.LuggageForm;
import UI.LuggageTable;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alex
 */
public class F1Screen {

    private LuggageUI UI;
    //private DatabaseManager db;  //Niet nodig voor F1 screen? - jvw
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public F1Screen(LuggageUI UI, DatabaseManager db) {

        this.UI = UI;
        // this.db = db; //Niet nodig voor F1 screen? - jvw

        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Help");

        GridPane test = new GridPane();
        test.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("HELP, Bagage zoeken.");

        test.add(heading, 1, 1);
        
        LuggageForm form = new LuggageForm(UI);
        form.addLabel("Email: ");
        
        
        
        
        
        
        
      
        

    }
}
