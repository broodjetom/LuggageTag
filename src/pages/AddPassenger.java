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
 * @author ________ Jimmy van Wieringen Student nummer:_ 500728110 Groep:__________ IS102
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
        form.addLabel("Telephone 1: ");
        form.addTextField("phone", true);

        form.addLabel("Telephone 2: ");
        form.addTextField("phone2", false);

        form.addLabel("Telephone 3: ");
        form.addTextField("phone3", false);

        form.addRow();
        form.addLabel("E-mail 1:");
        form.addTextField("email1", true);

        form.addLabel("E-mail 2:");
        form.addTextField("email2", false);

        form.addLabel("E-mail 3:");
        form.addTextField("email3", false);

        form.addRow();
        form.addLabel("Adres 1: ");
        form.addTextField("address1", true);

        form.addLabel("ZIP / City 1: ");
        form.addTextField("zip1", true);

        form.addLabel("Nationality 1: ");
        form.addTextField("land1", true);
        form.addRow();

        form.addLabel("Adres 2: ");
        form.addTextField("address2", false);

        form.addLabel("ZIP / City 2: ");
        form.addTextField("zip2", false);

        form.addLabel("Nationality 2: ");
        form.addTextField("land2", false);

        form.addRow();
        form.addLabel("Adres 3: ");
        form.addTextField("address3", false);

        form.addLabel("ZIP / City 3: ");
        form.addTextField("zip3", false);

        form.addLabel("Nationality 3: ");
        form.addTextField("land3", false);
        form.addRow();

        form.addRow();
        form.addLabel("Comment ");
        form.addTextArea("comment", false);

        form.addRow();
        form.addCol();
        form.addSubmitButton("Save");
        form.addRow();
        form.onSubmit((Callable) () -> {
            models.Passenger passengerModel = new models.Passenger();
            passengerModel.setFname(form.get("fname"));
            passengerModel.setMname(form.get("mname"));
            passengerModel.setLname(form.get("lname"));
            passengerModel.setComment(form.get("comment"));
            passengerModel.setUsers_id(USER.getUser().getId());
            db.savePassenger(passengerModel);
            System.out.println("passenger saved");
            int lastInsertId = db.getLastInsertId("passenger");
            
            models.Phone phoneModel = new models.Phone();
            phoneModel.setPassenger_id(lastInsertId);
            phoneModel.setPhone(form.get("phone1"));
            db.savePhone(phoneModel);

            if (form.get("phone2") != null) {
                phoneModel.setPassenger_id(lastInsertId);
                phoneModel.setPhone(form.get("phone2"));
                db.savePhone(phoneModel);
            }

            if (form.get("phone3") != null) {
                phoneModel.setPassenger_id(lastInsertId);
                phoneModel.setPhone(form.get("phone3"));
                db.savePhone(phoneModel);
            }

            models.Email emailModel = new models.Email();
            phoneModel.setPassenger_id(lastInsertId);
            phoneModel.setPhone(form.get("phone1"));
            db.savePhone(phoneModel);

            if (form.get("phone2") != null) {
                phoneModel.setPassenger_id(lastInsertId);
                phoneModel.setPhone(form.get("phone2"));
                db.savePhone(phoneModel);
            }

            if (form.get("phone3") != null) {
                phoneModel.setPassenger_id(lastInsertId);
                phoneModel.setPhone(form.get("phone3"));
                db.savePhone(phoneModel);
            }

            return true;
        });

        view.add(form.toNode(), 1, 2);

        UI.setLeft(view);
        // Zet in de top van de BorderPane  
        UI.setCenter(form.toNode());
    }
}
