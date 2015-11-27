package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.util.concurrent.Callable;
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
        form.addLabel("Brand ");
        form.addTextField("Brand", false);

        form.addRow();
        form.addLabel("Color ");
        form.addTextField("Color", false);

        form.addRow();
        form.addLabel("Weight ");
        form.addTextField("Weight", false);

        form.addRow();
        form.addLabel("Material ");
        form.addTextField("Material", false);

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
        form.addLabel("Type ");
        form.addTextField("Type", false);

        form.addRow();
        form.addLabel("Setting ");
        form.addTextField("Setting", false);

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
