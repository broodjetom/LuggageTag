package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

/**
 * @author ________ Jimmy van Wieringen
 * Student nummer:_ 500728110
 * Groep:__________ IS102
 */
public class AddCustomer {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public AddCustomer(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Add Passenger");

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
        form.addLabel("Telephone ");
        ObservableList<models.Brands> brandsModel = this.db.getBrands();
        form.addComboBox("Telephone", brandsModel);
        form.addRow();
        
        form.addLabel("Country ");
        ObservableList<models.Colors> colorsModel = this.db.getColors();
        form.addComboBox("Country", colorsModel);
        form.addRow();

        form.addRow();
        form.addLabel("City ");
        form.addTextField("city", false);
        
        form.addRow();
        form.addLabel("Adress ");
        ObservableList<models.Materials> materialsModel = this.db.getMaterials();
        form.addComboBox("adress", materialsModel);
        form.addRow();

        form.addRow();
        form.addLabel("ZIP code ");
        form.addTextField("zipCode", false);

        form.addRow();
        form.addLabel("End travel destination ");
        form.addTextArea("endTravelDestination", false);

        form.addRow();
        form.addLabel("Begin travel destination ");
        form.addTextField("beginTravelDestination", false);
        
        form.addRow();
        form.addLabel("Current destination ");
        ObservableList<models.Types> typeModel = this.db.getTypes();
        form.addComboBox("currentDestination", typeModel);
        form.addRow();
        
        form.addRow();
        form.addLabel("Vestigingen");
        ObservableList<models.Locations> locationsModel = this.db.getLocations();
        form.addComboBox("location_id", locationsModel);
        form.addRow();

        form.addRow();
        form.addLabel("Comment ");
        form.addTextArea("Comment", false);

        form.addRow();
        form.addLabel("User ");
        form.addTextField("User", false);

        form.addRow();
        form.addLabel("Status:");

        form.addHRadioButtons("status", new String[]{"Found", "Lost"}, "Found");

        form.addRow();
        form.addRow();
        form.addCol();
        form.addSubmitButton("Save");
        form.addRow();
        form.onSubmit((Callable) () -> {
            
            return true;
        });

        view.add(form.toNode(), 1, 2);

        UI.setLeft(view);
        // Zet in de top van de BorderPane  
        UI.setCenter(form.toNode());
    }
}


