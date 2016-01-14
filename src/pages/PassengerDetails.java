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
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Alex
 */
public class PassengerDetails {

    private LuggageUI UI;
    private DatabaseManager db;

    /**
     *
     */
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show pagger detials page
     * @param UI
     * @param model
     * @throws SQLException
     * @throws IOException
     */
    public PassengerDetails(LuggageUI UI, models.Passenger model) throws SQLException, IOException {
        this.UI = UI;
        this.db = DatabaseManager.getInstance();

        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Passenger details");

        UI.setCurPage("AddLuggage");

        view.setPadding(new Insets(50, 50, 50, 50));
        
        LuggageForm form = new LuggageForm(UI);

        Label heading = UI.createHeading("Details of " + model.getFullName());
        form.add(heading);
        form.addRow();
        form.addLabel("Information: ");
        form.addLabel(model.getComment());
        form.addRow();

        form.addLabel("First name:");
        form.addLabel(model.getFname());
        form.addRow();
        form.addLabel("Insertion:");
        form.addLabel(model.getMname());
        form.addRow();
        form.addLabel("Last name:");
        form.addLabel(model.getLname());
        form.addRow();

        form.addLabel("Phone number(s):");
        for (int i = 0; i < model.getPhone().size(); i++) {
            if (model.getPhone().get(i).getPhone().length() != 0) {
                form.addLabel(model.getPhone().get(i).getPhone());
            }
            if (i != model.getPhone().size()) {
                form.addRow();
                form.addCol();
            }
        }

        form.addRow();
        form.addLabel("Address(es):");
        for (int i = 0; i < model.getAddress().size(); i++) {
            if (model.getAddress().get(i).getAddress().length() != 0) {
                form.addLabel(model.getAddress().get(i).getFormattedAddress());
            }
            if (i != model.getAddress().size()) {
                form.addRow();
                form.addCol();
            }
        }
        form.addRow();

        form.addLabel("Email address(es):");
        for (int i = 0; i < model.getEmail().size(); i++) {
            if (model.getEmail().get(i).getEmail().length() != 0) {
                form.addLabel(model.getEmail().get(i).getEmail());
            }
            if (i != model.getEmail().size()) {
                form.addRow();
                form.addCol();
            }
        }
        
        form.addRow();
        form.addSubmitButton("Edit passenger");
        form.addRow();
        form.addCol();
        form.addCol();
        form.addLabel("    ");
        form.onSubmit((Callable) () -> {
            EditPassenger page = new EditPassenger(UI, model);
            return true;
        });

        LuggageTable table = new LuggageTable();

        table.onClick((Callable) () -> {
            models.Luggage row = (models.Luggage) table.getClicked();
            EditLuggage page = new EditLuggage(UI, row);
            return true;
        });

        String[] topText = {"Brand", "Color", "Weight", "Material", "Has sticker", "Has belt", "Type", "Status", "Date added", "Date edited"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"brand", "color", "weight", "material", "stickers", "belt", "type", "situation", "date_added", "date_changed"}; // De variable namen van het object gesorteerd op de topText 

        // Zoeken naar passenger
        models.Luggage zoek = new models.Luggage();
        zoek.setPassenger_id(model.getId());

        table.onClick((Callable) () -> {
            models.Luggage row = (models.Luggage) table.getClicked();
            LuggageDetails page = new LuggageDetails(UI, row);
            return true;
        });

        ObservableList<models.Luggage> luggage = db.getLuggage(zoek);

        // Set de top rij
        table.setTopRow(topText, topVars);
        // Set de data voor in de tabel
        table.setContent(luggage);
        
        LuggageForm form1 = new LuggageForm(UI);
        Label heading1 = UI.createHeading("Linked luggage");
        form1.add(heading1);
        form1.addRow();
        form1.add(table.getTable());
        
        HBox box = new HBox();
        box.getChildren().addAll(form.toNode(), form1.toNode());

        view.add(box, 0, 0);

        UI.setLeft(null);
        UI.setCenter(view);
    }
}
