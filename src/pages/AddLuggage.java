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
 *
 * @author Alex/Thomas
 */
public class AddLuggage {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public AddLuggage(LuggageUI UI, DatabaseManager db) throws SQLException {

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
        form.addLabel("Merk: ");
        ObservableList<models.Brands> brandsModel = this.db.getBrands();
        form.addComboBox("brand_id", brandsModel);
        form.addRow();
        
        form.addLabel("Kleur: ");
        ObservableList<models.Colors> colorsModel = this.db.getColors();
        form.addComboBox("color_id", colorsModel);
        form.addRow();

        form.addRow();
        form.addLabel("Weight ");
        form.addTextField("Weight", false);
        
        form.addRow();
        form.addLabel("Materiaal: ");
        ObservableList<models.Materials> materialsModel = this.db.getMaterials();
        form.addComboBox("material_id", materialsModel);
        form.addRow();

        form.addRow();
        form.addLabel("Stickers ");
        form.addTextField("Stickers", false);

        form.addRow();
        form.addLabel("Characteristics ");
        form.addTextArea("Characteristics", false);

        form.addRow();
        form.addLabel("Belt ");
        form.addTextField("Belt", false);
        
        form.addRow();
        form.addLabel("Type bagage ");
        ObservableList<models.Types> typeModel = this.db.getTypes();
        form.addComboBox("type_id", typeModel);
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
