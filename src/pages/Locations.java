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

/**
 *
 * @author Tom Scholten
 */
public class Locations {

    private LuggageUI UI;
    private DatabaseManager db;

    private GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show locations page
     * @param UI
     * @throws SQLException
     * @throws IOException
     */
    public Locations(LuggageUI UI) throws SQLException, IOException {

        this.UI = UI;
        this.db = DatabaseManager.getInstance();

        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Locations");

        LuggageTable table = new LuggageTable();

        table.onClick((Callable) () -> {
            models.Locations row = (models.Locations) table.getClicked();
            EditLocation edit = new EditLocation(UI, row);
            return true;
        });

        String[] topText = {"Location", "Address", "Zip", "Country"};
        String[] topVars = {"location", "address", "zip", "land"};

        models.Locations zoek = new models.Locations();

        ObservableList<models.Locations> locations = db.getLocations();

        table.setTopRow(topText, topVars);

        table.setContent(locations);

        GridPane test = new GridPane();
        test.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Search");

        test.add(heading, 1, 1);

        LuggageForm form = new LuggageForm(UI);

        form.addRow();
        form.addLabel("Locatie:");
        form.addTextField("location", false);

        form.addRow();
        form.addCol();
        form.addSubmitButton("Search");
        form.onSubmit((Callable)()-> {
            models.Locations newZoek = new models.Locations();
            newZoek.setLocation(form.get("location"));
            ObservableList<models.Locations> locationZoek = db.getLocation(newZoek);
            table.setContent(locationZoek);
            return true;
        });

        test.add(form.toNode(), 1, 2);

        UI.setLeft(test);
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());

    }
}
