package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

/**
 * @author Tom Scholten
 */
public class AddPassenger {

    private LuggageUI UI;
    private DatabaseManager db;

    private GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show add passenger page
     * @param UI
     * @throws SQLException
     * @throws IOException
     */
    public AddPassenger(LuggageUI UI) throws SQLException, IOException {

        this.UI = UI;
        this.db = DatabaseManager.getInstance();

        view.setPadding(new Insets(50, 50, 50, 50));

        
        
        Label heading = UI.createHeading("Add Passenger");

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);
        form.addRow();

        form.addLabel("First name: ");
        form.addTextField("fname", true);

        form.addRow();
        form.addLabel("Insertion: ");
        form.addTextField("mname", false);

        form.addRow();
        form.addLabel("Last name: ");
        form.addTextField("lname", true);

        form.addRow();
        form.addLabel("Telephone 1: ");
        form.addTextField("phone1", true);

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
            passengerModel = db.savePassenger(passengerModel);
            int id = passengerModel.getId();
            System.out.println("passenger saved");

            models.Phone phoneModel = new models.Phone();
            phoneModel.setPassenger_id(id);
            phoneModel.setPhone(form.get("phone1"));
            db.savePhone(phoneModel);

            
            System.out.println("phone saved" + form.get("phone1"));
            if (form.get("phone2").length() != 0 ) {
                phoneModel.setId(0);
                phoneModel.setPassenger_id(id);
                phoneModel.setPhone(form.get("phone2"));
                phoneModel = db.savePhone(phoneModel);
            }

            if (form.get("phone3").length() != 0 ) {
                phoneModel.setId(0);
                phoneModel.setPassenger_id(id);
                phoneModel.setPhone(form.get("phone3"));
                phoneModel = db.savePhone(phoneModel);
            }

            models.Email emailModel = new models.Email();
            phoneModel.setId(0);
            emailModel.setPassenger_id(id);
            emailModel.setEmail(form.get("email1"));
            db.saveEmail(emailModel);
            
            System.out.println("email saved");
            if (form.get("email2").length() != 0) {
                phoneModel.setId(0);
                emailModel.setPassenger_id(id);
                emailModel.setEmail(form.get("email2"));
                db.saveEmail(emailModel);
            }

            if (form.get("email3").length() != 0) {
                phoneModel.setId(0);
                emailModel.setPassenger_id(id);
                emailModel.setEmail(form.get("email3"));
                db.saveEmail(emailModel);
            }

            models.Address addressModel = new models.Address();
            addressModel.setPassenger_id(id);
            addressModel.setAddress(form.get("address1"));
            addressModel.setZip(form.get("zip1"));
            addressModel.setLand(form.get("land1"));
            db.saveAddress(addressModel);

            System.out.println("address saved");
            if (form.get("address2").length() != 0) {
                phoneModel.setId(0);
                addressModel.setPassenger_id(id);
                addressModel.setAddress(form.get("address2"));
                addressModel.setZip(form.get("zip2"));
                addressModel.setLand(form.get("land2"));
                db.saveAddress(addressModel);
            }

            if (form.get("address3").length() != 0) {
                phoneModel.setId(0);
                addressModel.setPassenger_id(id);
                addressModel.setAddress(form.get("address3"));
                addressModel.setZip(form.get("zip3"));
                addressModel.setLand(form.get("land3"));
                db.saveAddress(addressModel);
            }

            form.error("Passenger saved!");
            return true;
        });

        view.add(form.toNode(), 1, 2);

        UI.setLeft(view);
        // Zet in de top van de BorderPane  
        UI.setCenter(form.toNode());
    }
}
