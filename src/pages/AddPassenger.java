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
public class AddPassenger {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public AddPassenger(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Add Passenger");

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);
        form.addRow();

        form.addLabel("First name: ");
        form.addTextField("fname", true);

        form.addRow();
        form.addLabel("Insertion: ");
        form.addTextField("insertion", false);

        form.addRow();
        form.addLabel("Last name: ");
        form.addTextField("lname", true);
        
        form.addRow();
        form.addLabel("Telephone 1 ");
        form.addTextField("phone", true);
        
        form.addRow();
        form.addLabel("Telephone 2 ");
        form.addTextField("phone2", false);
        
        form.addRow();
        form.addLabel("Telephone 3 ");
        form.addTextField("phone3", false);
        
        form.addRow();
        form.addLabel("E-mail ");
        form.addTextField("email", true);
        
        form.addRow();
        form.addLabel("Adress ");
        form.addTextField("address", true);
        form.addRow();

        form.addRow();
        form.addLabel("ZIP / City ");
        form.addTextField("zip", true);
        
        form.addRow();
        form.addLabel("Nationality ");
        form.addTextField("land", true);
        form.addRow();
        
        form.addRow();
        form.addLabel("Comment ");
        form.addTextArea("comment", false);
        
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


