/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

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
public class SearchLuggage {
    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public SearchLuggage(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));
        
        UI.setTitle("Search Database");

        LuggageTable table = new LuggageTable();

        String[] topText = {"Voornaam", "Tussenvoegsel", "Achternaam", "Vluchtnummer", "Merk", "Kleur", "Gewicht", "Materiaal", "Stickers"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "flight", "brand_id", "color_id", "weight", "material_id", "stickers"}; // De variable namen van het object gesorteerd op de topText 
        
        // Zoeken naar passengerluggage
        models.PassengerLuggage zoek = new models.PassengerLuggage();
        
       // zoek.setFname("Jim");
        
        ObservableList<models.PassengerLuggage> passengers = db.getPassengerLuggage( zoek );
        
       /* for (models.PassengerLuggage rij: passengers) {
            rij.setFname("Jimmy");
            rij.setBrand_id(1);
            rij = db.savePassengerLuggage(rij);
        } */
        
        // Set de top rij
        table.setTopRow(topText, topVars);
        
        // Set de data voor in de tabel
        table.setContent(passengers);
        
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
        
        
        form.addComboBox("status", new String[]{"Gevonden", "Gezocht", "Afgehandeld"});
        form.addRow();
        
        Button forgotPassword = UI.createGreyButton("Clear", false, (Callable) () -> {
            return true;
        });

        form.add(forgotPassword);
        form.addSubmitButton("Search");
        
        form.onSubmit((Callable) () -> {
            models.PassengerLuggage zoekNew = new models.PassengerLuggage();
            String emailValue = form.get("fname");
            
            zoekNew.setFname(emailValue);
            zoekNew.setLname(form.get("lname"));

            ObservableList<models.PassengerLuggage> passengersZoek = db.getPassengerLuggage( zoekNew );
            
            table.setContent(passengersZoek);
            return true;
        });
        
        test.add(form.toNode(), 1, 2);
        
        UI.setLeft(test);
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());
        

    }
}
