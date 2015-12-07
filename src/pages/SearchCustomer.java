
package pages;

import UI.LuggageForm;
import UI.LuggageTable;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.util.Vector;
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
public class SearchCustomer {
    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public SearchCustomer(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));
        
        UI.setTitle("Search Database");

        LuggageTable table = new LuggageTable();
        
        table.onClick((Callable) () -> {
            models.Passenger row = (models.Passenger)table.getClicked();
            PassengerDetails page = new PassengerDetails(UI, db, row);
            return true;
        });

        String[] topText = {"Voornaam", "Tussenvoegsel", "Achternaam", "Datum toegevoegd", "Datum gewijzigd"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "date_added", "date_changed"}; // De variable namen van het object gesorteerd op de topText 
        
        // Zoeken naar passenger
        models.Passenger zoek = new models.Passenger();
        
        
        ObservableList<models.Passenger> passengers = db.getPassenger( zoek );
        
        
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
        
        form.addLabel("Tussenvoegsel: ");
        form.addTextField("mname", false);
        form.addRow();
        
        form.addLabel("Achternaam: ");
        form.addTextField("lname", false);
        form.addRow();
        
        Button forgotPassword = UI.createGreyButton("Clear", false, (Callable) () -> {
            return true;
        });

        form.add(forgotPassword);
        form.addSubmitButton("Search");
        
        form.onSubmit((Callable) () -> {
            models.Passenger zoekNew = new models.Passenger();
            
            zoekNew.setFname(form.get("fname"));
            zoekNew.setMname(form.get("mname"));
            zoekNew.setLname(form.get("lname"));
            
            ObservableList<models.Passenger> passengersZoek = db.getPassenger( zoekNew );
            
            table.setContent(passengersZoek);
            return true;
        });
        
        test.add(form.toNode(), 1, 2);
        
        UI.setLeft(test);
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());
        

    }
}
