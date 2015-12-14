/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luggagetag;

import UI.*;
import pages.Login;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import database.DatabaseManager;
import java.io.IOException;
import java.sql.SQLException;

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
        this.db = DatabaseManager.getInstance();
        this.UI = new LuggageUI(primaryStage);
        
        
        
        UI.setTitle("Welcome");
        
        Login login = new Login(UI);
        
        UI.show();

    }
}
