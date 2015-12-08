package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * @Author Tom Scholten
 * @Class
 * @Date
 */
public class AddCategory {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public AddCategory(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Categorieën toevoegen");

        LuggageForm form = new LuggageForm(UI);

        form.add(heading);
        form.addRow();

        form.addLabel("Brand: ");
        form.addTextField("brand", false);
        form.addSubmitButton("Toevoegen");
        form.addRow();

        form.addLabel("Color: ");
        form.addTextField("color", false);
        form.addSubmitButton("Toevoegen");
        form.addRow();

        form.addLabel("Material: ");
        form.addTextField("material", false);
        form.addSubmitButton("Toevoegen");
        form.addRow();

        form.addLabel("Type: ");
        form.addTextField("type", false);
        form.addSubmitButton("Toevoegen");
        form.addRow();

        
        
        view.add(form.toNode(), 1, 2);

        UI.setLeft(view);
        // Zet in de top van de BorderPane  
        UI.setCenter(form.toNode());

    }
}
