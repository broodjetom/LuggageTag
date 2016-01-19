
package pages;

import UI.LuggageForm;
import UI.LuggageTable;
import UI.LuggageUI;
import database.DatabaseManager;
import java.io.IOException;
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

    private GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show search customer page
     * @param UI
     * @throws SQLException
     * @throws IOException
     */
    public SearchCustomer(LuggageUI UI) throws SQLException, IOException {

        this.UI = UI;
        this.db = DatabaseManager.getInstance();
        
        
        view.setPadding(new Insets(50, 50, 50, 50));
        UI.setCurPage("SearchPassenger");

        view.setPadding(new Insets(50, 50, 50, 50));
        
        // Titel aanpassen
        UI.setTitle("Search Database");
        
        // Nieuwe tabel aanmaken    
        LuggageTable table = new LuggageTable();
        
        table.onClick((Callable) () -> {
            models.Passenger row = (models.Passenger)table.getClicked();
            PassengerDetails page = new PassengerDetails(UI, row);
            return true;
        });

        String[] topText = {"First name", "Insertion", "Last name", "Date added", "Date edited"}; // texten die bovenaan de tabel verschijnen
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
     
        // Maak de Search form aan
        Label heading = UI.createHeading("Search");

        test.add(heading, 1, 1);
        
        LuggageForm form = new LuggageForm(UI);
        form.addLabel("First name: ");
        form.addTextField("fname", false);
        form.addRow();
        
        form.addLabel("Insertion: ");
        form.addTextField("mname", false);
        form.addRow();
        
        form.addLabel("Last name: ");
        form.addTextField("lname", false);
        form.addRow();
        
        Button forgotPassword = UI.createGreyButton("Clear", false, (Callable) () -> {
            return true;
        });
        
        // Grijze search knop
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
        
        // Zet de search velden links
        UI.setLeft(test);
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());
        

    }
}
