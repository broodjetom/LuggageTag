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

/**
 * @Author Tom Scholten
 * @Class
 * @Date
 */
public class EditPassenger {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public EditPassenger(LuggageUI UI, DatabaseManager db, models.Passenger model) throws SQLException {
        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Edit passenger");

        Label heading = UI.createHeading("Edit passenger");

        ObservableList<models.Phone> phone = db.getPhones(model.getId());
        ObservableList<models.Email> email = db.getEmails(model.getId());
        ObservableList<models.Address> address = db.getAddresses(model.getId());

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);
        form.addRow();

        form.addLabel("First name: ");
        form.addTextField("fname", true, model.getFname());

        form.addRow();
        form.addLabel("Insertion: ");
        form.addTextField("mname", false, model.getMname());

        form.addRow();
        form.addLabel("Last name: ");
        form.addTextField("lname", true, model.getLname());

        form.addRow();
        form.addLabel("Telephone 1: ");
        form.addTextField("phone1", true, phone.get(0).getPhone());

        form.addLabel("Telephone 2: ");
        form.addTextField("phone2", false, (phone.size() >= 2 ? phone.get(1).getPhone() : ""));

        form.addLabel("Telephone 3: ");
        form.addTextField("phone3", false, (phone.size() >= 3 ? phone.get(2).getPhone() : ""));
        
        form.addRow();
        form.addLabel("E-mail 1:");
        form.addTextField("email1", true, email.get(0).getEmail());
        
        form.addLabel("E-mail 2: ");
        form.addTextField("email2", false, (email.size() >= 2 ? email.get(1).getEmail() : ""));

        form.addLabel("E-mail 3: ");
        form.addTextField("email3", false, (email.size() >= 3 ? email.get(2).getEmail() : ""));
        form.addRow();

        form.addLabel("Adres 1: ");
        form.addTextField("address1", true, address.get(0).getAddress());

        form.addLabel("ZIP / City 1: ");
        form.addTextField("zip1", true, address.get(0).getZip());

        form.addLabel("Nationality 1: ");
        form.addTextField("land1", true, address.get(0).getLand());
        form.addRow();
        
        form.addLabel("Adres 2: ");
        form.addTextField("address2", false, (address.size() >= 2 ? address.get(1).getAddress() : ""));

        form.addLabel("ZIP / City 2: ");
        form.addTextField("zip2", false, (address.size() >= 2 ? address.get(1).getZip() : ""));

        form.addLabel("Nationality 2: ");
        form.addTextField("land2", false, (address.size() >= 2 ? address.get(1).getLand() : ""));
        form.addRow();
        
        form.addLabel("Adres 3: ");
        form.addTextField("address3", false, (address.size() >= 3 ? address.get(2).getAddress() : ""));

        form.addLabel("ZIP / City 3: ");
        form.addTextField("zip3", false, (address.size() >= 3 ? address.get(2).getZip() : ""));

        form.addLabel("Nationality 3: ");
        form.addTextField("land3", false, (address.size() >= 3 ? address.get(2).getLand() : ""));
        form.addRow();

        form.addLabel("Comment ");
        form.addTextArea("comment", false, model.getComment(), 30);

        form.addRow();

        form.addCol();

        form.addSubmitButton("Save");
        form.addRow();

        form.onSubmit((Callable) () -> {
            models.Passenger passengerModel = model;
            passengerModel.setFname(form.get("fname"));
            passengerModel.setMname(form.get("mname"));
            passengerModel.setLname(form.get("lname"));
            passengerModel.setComment(form.get("comment"));
            passengerModel.setUsers_id(USER.getUser().getId());
            passengerModel = db.savePassenger(passengerModel);
            int id = passengerModel.getId();
            System.out.println("passenger saved");

            models.Phone phoneModel = new models.Phone();
            phoneModel.setId(phone.get(0).getId());
            phoneModel.setPassenger_id(id);
            phoneModel.setPhone(form.get("phone1"));
            db.savePhone(phoneModel);

            
            System.out.println("phone saved" + form.get("phone1"));
            if (form.get("phone2").length() != 0 ) {
                phoneModel.setId(phone.get(1).getId());
                phoneModel.setPhone(form.get("phone2"));
                phoneModel = db.savePhone(phoneModel);
            }

            if (form.get("phone3").length() != 0 ) {
                phoneModel.setId(phone.get(2).getId());
                phoneModel.setPhone(form.get("phone3"));
                phoneModel = db.savePhone(phoneModel);
            }

            models.Email emailModel = new models.Email();
            emailModel.setId(email.get(0).getId());
            emailModel.setPassenger_id(id);
            emailModel.setEmail(form.get("email1"));
            db.saveEmail(emailModel);
            
            System.out.println("email saved");
            if (form.get("email2").length() != 0) {
                emailModel.setId(email.get(1).getId());
                emailModel.setEmail(form.get("email2"));
                db.saveEmail(emailModel);
            }

            if (form.get("email3").length() != 0) {
                emailModel.setId(email.get(2).getId());
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
                addressModel.setId(0);
                addressModel.setAddress(form.get("address2"));
                addressModel.setZip(form.get("zip2"));
                addressModel.setLand(form.get("land2"));
                db.saveAddress(addressModel);
            }

            if (form.get("address3").length() != 0) {
                addressModel.setId(0);
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
