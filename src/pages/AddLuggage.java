/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alex
 */
public class AddLuggage {
    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public AddLuggage(LuggageUI UI, DatabaseManager db) {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));
        
        Label heading = UI.createHeading("Bagage toevoegen");
        
        LuggageForm form = new LuggageForm(UI);
        form.add(heading);
        form.addRow();
        
        form.addLabel("First name: ");
        form.addTextField("fname", false);
        form.addRow();
        form.addLabel("Insertion: ");
        form.addTextField("insertion", false);
        
        form.addRow();
        form.addLabel("Last name: ");
        form.addTextField("lname", false);
        form.addRow();
        form.addLabel("Flight number: ");
        form.addTextField("flightnumber", false);
        
        form.addRow();
        form.addLabel("Status:");
        
        
        form.addHRadioButtons("status", new String[]{"Found", "Lost"}, "Found");
        
        view.add(form.toNode(), 1, 2);
        
        UI.setLeft(view);
        // Zet in de top van de BorderPane
        UI.setCenter(form.toNode());
    }
}
