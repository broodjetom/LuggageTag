package pages;

import UI.LuggageUI;
import database.DatabaseManager;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 * @Author Tom Scholten
 * @Class
 * @Date
 */
public class EditLuggage {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public EditLuggage(LuggageUI UI, DatabaseManager db, models.Luggage model) {
        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Edit luggage");
        
        
    }
}
