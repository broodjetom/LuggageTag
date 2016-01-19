/*
 * Luggage Tag main file.
 * This file creates the program by getting the required files.
 * 
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

/**
 * Maakt een nieuwe class aan "LT" met de attributen van class "Application"
 * Application is een standaard class in javaFX die er voor zorgt dat het 
 * programma kan opstarten.
 */
public class LuggageTag extends Application {
    //Objecten worden benoemt en krijgen een "naam""
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
        
    */
    
    
    /**
     * Start de constructor die ervoor zorgt dat de juister objecten worden 
     * aangemaakt en dat het programma opstart.
     * 
     * Get instance zorgt ervoor dat er maar 1 instance actief is als 
     * het programma draait. Heeft met singleton te maken, hier verteld alex straks meer over.
     */
    @Override
    public void start(Stage primaryStage) throws SQLException, IOException {
        //SQLExcep laat informatie zien over de database.
        //
        //Hier word verteld dat bijvoorbeeld "db" de databasemanager is.
        this.db = DatabaseManager.getInstance(); 
        this.UI = new LuggageUI(primaryStage);
      
        
        UI.setTitle("Welcome"); //Dit komt te zien naast de naam van het programma.
        
        //Het object "login" word aangemaakt zodat er een login scherm getoont word.
        Login login = new Login(UI);
        
        UI.show();

    }
}
