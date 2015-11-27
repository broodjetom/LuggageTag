/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luggagetag;

import UI.*;
import pages.*;
import java.util.concurrent.Callable;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import database.DatabaseManager;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Alex
 */
public class LuggageTag extends Application {
    private LuggageUI UI;
    private static final user.Session USER = user.Session.getInstance();
    
    private DatabaseManager db;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
    
    /*
        Start is de constructor, hier start de applicatie
    */
    @Override
    public void start(Stage primaryStage) throws SQLException, IOException {
        this.db = new DatabaseManager();
        this.UI = new LuggageUI(primaryStage);
        
        // Met setTitle kan je de titel van de applicatie neerzetten
        UI.setTitle("Welcome");
        
        // Stukje voorbeeldcode voor een login
        
        if (USER.getUser().getId() == 0) {
            Login login = new Login(UI, db);
        } else {
            pages.menus.Administrator menu = new pages.menus.Administrator(UI, db);
            SearchLuggage searchLuggage = new SearchLuggage(UI, db);
        }
        
        UI.show();

    }
}
