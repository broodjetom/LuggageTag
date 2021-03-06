package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * @author Tom Scholten
 */
public class EditLocation {

    private LuggageUI UI;
    private DatabaseManager db;

    private GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show edit location page
     * @param UI
     * @param model models.Location to edit
     * @throws SQLException
     * @throws IOException
     */
    public EditLocation(LuggageUI UI, models.Locations model) throws SQLException, IOException {

        this.UI = UI;
        this.db = DatabaseManager.getInstance();

        UI.setTitle("Edit Location");

        Label heading = UI.createHeading("Edit Location");

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);

        form.addRow();
        form.addLabel("Location: ");
        form.addTextField("location", true, model.getLocation());

        form.addRow();
        form.addLabel("Address: ");
        form.addTextField("address", true, model.getAddress());

        form.addRow();
        form.addLabel("Zip: ");
        form.addTextField("zip", true, model.getZip());

        form.addRow();
        form.addLabel("Land: ");
        form.addTextField("land", true, model.getLand());

        form.addRow();
        form.addCol();
        form.addSubmitButton("Save");
        form.onSubmit((Callable) () -> {

            if (form.get("location").isEmpty() || form.get("address").isEmpty()
                    || form.get("zip").isEmpty() || form.get("land").isEmpty()) {
                form.error("Field is empty!");
            } else {
                model.setLocation(form.get("location"));
                model.setAddress(form.get("address"));
                model.setZip(form.get("zip"));
                model.setLand(form.get("land"));
                db.saveLocation(model);
                form.error("Location saved!");
            }
            return true;
        });

        view.add(form.toNode(), 1, 2);

        UI.setLeft(view);

        UI.setCenter(form.toNode());
    }
}
