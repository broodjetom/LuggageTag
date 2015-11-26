/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luggagetag;

import UI.*;
import java.util.concurrent.Callable;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.PassengerLuggage;

/**
 *
 * @author Alex
 */
public class LuggageTag extends Application {
    private LuggageUI UI;
    private boolean loggedIn = true;
    
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
    public void start(Stage primaryStage) {
        // Maak een nieuwe UI, een UI maakt een scherm aan met daar in  BorderPane
        this.UI = new LuggageUI(primaryStage);
        
        // Met setTitle kan je de titel van de applicatie neerzetten
        UI.setTitle("Welcome");
        
        // Stukje voorbeeldcode voor een login
        if (!loggedIn) {
            // Maak een nieuwe knop aan met de tekst Log In, 
            // false zodat hij niet de active state heeft 
            // en de laatste parameter is de eventlistener, 
            // hier in kan je de logica van de button plaatsen
            LuggageMenu menu = new LuggageMenu(UI);
            UI.setTop(menu.toNode());
            
            GridPane test = new GridPane();
            test.setPadding(new Insets(50, 50, 50, 50));
            
            Label heading = UI.createHeading("Inloggen");
            Label subtext = UI.createText("Log in met uw account");
            
            test.add(heading, 1, 1);
            test.add(subtext, 1, 2);
            
            
            LuggageForm form = new LuggageForm(UI);
            form.addLabel("Email: ");
            form.addTextField("email", true);
            form.addRow();
            form.addLabel("Wachtwoord: ");
            form.addPassField("password", true);
            
            
            form.addRow();
            form.addHRadioButtons("testing", new String[]{"test 1", "test 2", "test 3"});
            form.addRow();
            form.addVRadioButtons("testing2", new String[]{"test 1", "test 2", "test 3"}, "test 2");
            
            form.addRow();    
            
            form.addLabel("Test: ");
            form.addTextArea("testArea", false);
            
            form.addRow(); 
            
            form.addLabel("Test dropdown: ");
            form.addComboBox("testArea", new String[]{"test 1", "test 2", "test 3"});
            
            form.addRow(); 
            
            
            Button forgotPassword = UI.createGreyButton("Wachtwoord vergeten", false, (Callable) () -> {
                return true;
            });
            
            form.add(forgotPassword);
            
            form.addSubmitButton("Log In");
            form.onSubmit( (Callable) () -> {
                String emailValue = form.get("email");
                String passwordValue = form.get("password");
                
                if( emailValue.equals("admin") && passwordValue.equals("test") ){
                    mainPage();
                } else {
                    form.error("Email en/of wachtwoord incorrect\nProbeer het met andere gegevens\nOf ga naar uw manager");
                }
                return true;
            });
            
            test.add(form.toNode(), 1, 3);
            
            // Zet nu de loginbutton in de center van de BorderPane
            UI.setCenter(
                test
            );
        } else {
            mainPage(); // als de gebruiker al is ingelogd ga dan naar de mainPage
        }
        
        // Laat de GUI zien
        UI.show();

    }

    public void mainPage() {
        // Maak een nieuwe menu aan met de LuggageMenu class, deze is wel beetje buggy nog
        LuggageMenu menu = new LuggageMenu(UI);
        
        // Maak nieuw element aan, met de text Search Database
        // Active state is waar
        // En weer op dezelfde methode een eventlistener
        menu.addMenuItem("Search Database", true, (Callable) () -> {
            searchDatabase();
            return true;
        });
        
        // Je snapt het idee wel, maar hier is de active state false
        menu.addMenuItem("Search Luggage", false, (Callable) () -> {
            addLuggage();
            return true;
        });

        menu.addMenuItem("User balhaar", false, (Callable) () -> {
            userBalhaar();
            return true;
        });
        UI.setTop(
            menu.toNode() // menu.getMenu geeft et menu terug
        );
    }
    
    // Hier onder staan de methodes om de pagina te genereren, hij voegt nu overal een button toe aan de center van de BorderPane
    public void searchDatabase() {
        // MAIN

        UI.setTitle("Search Database");

        LuggageTable table = new LuggageTable();

        String[] topText = {"Test 1", "Test 2", "Test 3", "Gewicht"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "weight"}; // De variable namen van het object gesorteerd op de topText 

        // Nieuwe obkecten die we in de table stoppen
        PassengerLuggage thomas = new PassengerLuggage();
        thomas.setFname("Thomas");
        thomas.setMname("");
        thomas.setLname("Kamp");
        thomas.setWeight(25.50);

        PassengerLuggage passenger = new PassengerLuggage();
        passenger.setFname("Alex");
        passenger.setMname("Bob");
        passenger.setLname("Lisenkov");
        passenger.setWeight(500);
        
        // Maak een ObservableList van de objecten, is een soort van array
        ObservableList<PassengerLuggage> data
                = FXCollections.observableArrayList(
                        passenger,
                        thomas
                );
        
        // Set de top rij
        table.setTopRow(topText, topVars);
        
        // Set de data voor in de tabel
        table.setContent(data);
        
        GridPane test = new GridPane();
        test.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Zoeken");

        test.add(heading, 1, 1);
        
        LuggageForm form = new LuggageForm(UI);
        form.addLabel("Voornaam: ");
        form.addTextField("fname", false);
        form.addRow();
        form.addLabel("Achternaam: ");
        form.addTextField("lname", false);
        
        form.addRow();
        form.addLabel("Status:");
        
        
        form.addVRadioButtons("status", new String[]{"Gevonden", "Gezocht", "Afgehandeld"}, "Gevonden");
        
        test.add(form.toNode(), 1, 2);
        
        UI.setLeft(test);
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());
    }

    public void addLuggage() {
        // MAIN

        UI.setTitle("Add Luggage");

        Button center = UI.createRedButton("Luggage", false, (Callable) () -> {
            return true;
        });

        UI.setCenter(center);
    }

    public void userBalhaar() {
        // MAIN

        UI.setTitle("Add userBalhaar");

        Button center = UI.createRedButton("Hallo balhaar", false, (Callable) () -> {
            return true;
        });

        UI.setCenter(center);
    }

}
