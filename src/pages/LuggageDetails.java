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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Alex
 */
public class LuggageDetails {
    
    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();
    
    private models.Passenger passengerModel = new models.Passenger();
    private static final user.Session USER = user.Session.getInstance();
    
    public LuggageDetails(LuggageUI UI, DatabaseManager db, models.Luggage model) throws SQLException {
        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));
        
        LuggageForm form = new LuggageForm(UI);
        
        Label heading = UI.createHeading(model.getSituation()+" "+model.getType().toString());
        form.add(heading);
        form.addRow();
        
        form.addRow();
        form.addLabel("Brand: ");
        form.addLabel(model.getBrand().toString());
        form.addRow();

        form.addLabel("Color: ");
        form.addLabel(model.getColor().toString());
        form.addRow();

        form.addRow();
        form.addLabel("Weight: ");
        form.addLabel(String.valueOf(model.getWeight()));

        form.addRow();
        form.addLabel("Material: ");
        form.addLabel(model.getMaterial().toString());
        form.addRow();

        form.addRow();
        form.addLabel("Stickers: ");
        form.addLabel(String.valueOf(model.getStickers()));

        form.addRow();
        form.addLabel("Characteristics: ");
        form.addLabel(model.getCharacteristic().toString());

        form.addRow();
        form.addLabel("Belt: ");
        form.addLabel(( model.getBelt() == 0 ? "No" : "Yes"));

        form.addRow();
        form.addLabel("Type: ");
        form.addLabel(model.getType().toString());
        form.addRow();

        form.addRow();
        form.addLabel("Vestigingen");
        form.addLabel(model.getLocation().toString());
        form.addRow();

        form.addRow();
        form.addLabel("Comment: ");
        form.addLabel(model.getComment());

        form.addRow();
        form.addLabel("Status:");
        form.addLabel(model.getSituation());
        
        
        LuggageTable table = new LuggageTable();

        table.onClick((Callable) () -> {
            models.Luggage row = (models.Luggage) table.getClicked();
            EditLuggage page = new EditLuggage(UI, db, row);
            return true;
        });

        String[] topText = {"First name", "Insertion", "Last name", "Date added", "Date edited"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "date_added", "date_changed"}; // De variable namen van het object gesorteerd op de topText 
        // Zoeken naar passenger
        models.Passenger zoek = new models.Passenger();
        zoek.setId(model.getPassenger_id());

        table.onClick((Callable) () -> {
            models.Passenger row = (models.Passenger) table.getClicked();
            PassengerDetails page = new PassengerDetails(UI, db, row);
            return true;
        });

        ObservableList<models.Passenger> passenger = db.getPassenger(zoek);

        // Set de top rij
        table.setTopRow(topText, topVars);
        // Set de data voor in de tabel
        table.setContent(passenger);
        
        HBox box = new HBox();
        LuggageForm form1 = new LuggageForm(UI);
        Label heading1 = UI.createHeading("Linked passenger");
        form1.add(heading1);
        form1.addRow();
        form1.add(table.getTable());
        
        box.getChildren().addAll(form.toNode(), form1.toNode());

        view.add(box, 0, 0);
        
        UI.setLeft(null);
        // Zet in de top van de BorderPane  
        UI.setCenter(view);
    }
}
