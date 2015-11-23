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
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alex
 */
public class LuggageTag extends Application {
    private LuggageUI UI;
    private boolean loggedIn = false;
    
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
        
        // Zet in de top van de BorderPane
        UI.setTop(
            menu.toNode() // menu.getMenu geeft et menu terug
        );
    }
    
    // Hier onder staan de methodes om de pagina te genereren, hij voegt nu overal een button toe aan de center van de BorderPane
    public void searchDatabase() {
        // MAIN

        UI.setTitle("Search Database");

        Button center = UI.createSecondaryButton("Test", false, (Callable) () -> {
            return true;
        });
        
        VBox test = new VBox();
        test.getChildren().addAll(new Label("test1"), new Label("test2"), new Label("test3"));
        test.setStyle("-fx-border-right: 1px; -fx-border-color: #2e8b57;");
        
        UI.setLeft(test);
        UI.setCenter(center);
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
