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
        
        LuggageForm passengerForm = new LuggageForm(UI);
        
        
        
        Label heading1 = UI.createHeading("Linked passenger");
        passengerForm.add(heading1);
        passengerForm.addRow();
        
        if(model.getPassenger_id() != 0){
            models.Passenger passengerModel = db.getPassenger(model.getPassenger_id());
            passengerForm.addLabel("Information: ");
            passengerForm.addLabel(passengerModel.getComment());
            passengerForm.addRow();

            passengerForm.addLabel("First name:");
            passengerForm.addLabel(passengerModel.getFname());
            passengerForm.addRow();
            passengerForm.addLabel("Insertion:");
            passengerForm.addLabel(passengerModel.getMname());
            passengerForm.addRow();
            passengerForm.addLabel("Last name:");
            passengerForm.addLabel(passengerModel.getLname());
            passengerForm.addRow();

            passengerForm.addLabel("Phone number(s):");
            for (int i = 0; i < passengerModel.getPhone().size(); i++) {
                if (passengerModel.getPhone().get(i).getPhone().length() != 0) {
                    passengerForm.addLabel(passengerModel.getPhone().get(i).getPhone());
                }
                if (i != passengerModel.getPhone().size()) {
                    passengerForm.addRow();
                    passengerForm.addCol();
                }
            }

            passengerForm.addRow();
            passengerForm.addLabel("Address(es):");
            for (int i = 0; i < passengerModel.getAddress().size(); i++) {
                if (passengerModel.getAddress().get(i).getAddress().length() != 0) {
                    passengerForm.addLabel(passengerModel.getAddress().get(i).getFormattedAddress());
                }
                if (i != passengerModel.getAddress().size()) {
                    passengerForm.addRow();
                    passengerForm.addCol();
                }
            }
            passengerForm.addRow();

            passengerForm.addLabel("Email address(es):");
            for (int i = 0; i < passengerModel.getEmail().size(); i++) {
                if (passengerModel.getEmail().get(i).getEmail().length() != 0) {
                    passengerForm.addLabel(passengerModel.getEmail().get(i).getEmail());
                }
                if (i != passengerModel.getEmail().size()) {
                    passengerForm.addRow();
                    passengerForm.addCol();
                }
            }

            passengerForm.addRow();
            passengerForm.addSubmitButton("Edit passenger");
            passengerForm.addRow();
            passengerForm.addCol();
            passengerForm.addCol();
            passengerForm.addLabel("    ");
            passengerForm.onSubmit((Callable) () -> {
                EditPassenger page = new EditPassenger(UI, db, passengerModel);
                return true;
            });
        } else {
            passengerForm.addLabel("No passenger linked to this luggage");
        }
        
        LuggageTable table = new LuggageTable();

        table.onClick((Callable) () -> {
            models.Luggage row = (models.Luggage) table.getClicked();
            EditLuggage page = new EditLuggage(UI, db, row);
            return true;
        });

        String[] topText = {"First name", "Insertion", "Last name", "Date added", "Date edited"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "date_added", "date_changed"}; // De variable namen van het object gesorteerd op de topText 
        

        table.onClick((Callable) () -> {
            models.Passenger row = (models.Passenger) table.getClicked();
            PassengerDetails page = new PassengerDetails(UI, db, row);
            return true;
        });
        
        // Zoeken naar passenger
        models.Passenger zoek = new models.Passenger();
        
        if( model.getPassenger_id() == 0 ){
            ObservableList<models.Passenger> passenger = null;
            table.setContent(passenger);
        } else {
            zoek.setId(model.getPassenger_id());
            ObservableList<models.Passenger> passenger = db.getPassenger(zoek);
            table.setContent(passenger);
        }
        

        // Set de top rij
        table.setTopRow(topText, topVars);
        // Set de data voor in de tabel
        
        
        HBox box = new HBox();
        
        form.setPrefWidth(400.0);
        passengerForm.setPrefWidth(400.0);
        
        box.getChildren().addAll(form.toNode(), passengerForm.toNode());

        view.add(box, 0, 0);
        
        UI.setLeft(null);
        // Zet in de top van de BorderPane  
        UI.setCenter(view);
    }
}
