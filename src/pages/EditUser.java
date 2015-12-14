package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;

/**
 *
 * @author Tarik Kilic
 */
public class EditUser {

    private LuggageUI UI;
    private DatabaseManager db;
    private models.Users editUser;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public EditUser(LuggageUI UI, DatabaseManager db, models.Users model) throws SQLException {
        this.UI = UI;
        this.db = db;
        this.editUser = model;

        String role = new String();
        if (model.getEmployee() == 1) {
            role = "Employee";
        } else if (model.getManager() == 1) {
            role = "Manager";
        } else if (model.getAdmin() == 1) {
            role = "Admin";
        }

        UI.setTitle("Edit User");

        Label heading = UI.createHeading("Edit User");

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);

        form.addRow();
        form.addLabel("Username: ");
        form.addTextField("username", true, model.getUsername());

        form.addRow();
        form.addLabel("Password: ");
        form.addPassField("password", false);

        form.addRow();
        form.addLabel("Repeat Password : ");
        form.addPassField("repeatpassword", false);

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
        form.addLabel("Telephone : ");
        form.addTextField("phone", true, model.getPhone());

        form.addRow();
        form.addLabel("Employee Number: ");
        form.addTextField("ee_num", true, model.getPhone());

        form.addRow();
        form.addLabel("Role: ");
        form.addComboBox("role", new String[]{"Employee", "Manager", "Administrator"}, false, role);

        form.addRow();
        form.addLabel("Location:");
        ObservableList<models.Locations> locationModel = this.db.getLocations();
        form.addComboBox("location_id", locationModel, false, model.getLocation());

        form.addCol();
        form.addSubmitButton("Save");
        form.onSubmit((Callable) () -> {
            
            if (!(form.get("username").isEmpty() || form.get("fname").isEmpty()
                    || form.get("lname").isEmpty() || form.get("phone").isEmpty()
                    || form.get("ee_num").isEmpty())) {
                if (form.get("password").equals(form.get("repeatpassword"))) {
                    if (form.get("password") != null) {
                        model.setPassword(form.get("password"));
                    }
                    model.setUsername(form.get("username"));
                    model.setFname(form.get("fname"));
                    model.setMname(form.get("mname"));
                    model.setLname(form.get("lname"));
                    model.setPhone(form.get("phone"));
                    model.setEe_num(form.get("ee_num"));
                    models.Locations locationsBox = (models.Locations) form.getComboBoxSelected("location_id");
                    model.setLocation_id(locationsBox.getId());
                    Object roleBox = form.getComboBoxSelected("role");
                    String roleString = roleBox.toString();
                    if (!roleString.isEmpty()) {
                        switch (roleString) {
                            case "Employee":
                                model.setEmployee(1);
                                model.setAdmin(0);
                                model.setManager(0);
                                break;
                            case "Manager":
                                model.setManager(1);
                                model.setEmployee(0);
                                model.setAdmin(0);
                                break;
                            case "Administrator":
                                model.setAdmin(1);
                                model.setManager(0);
                                model.setEmployee(0);
                                break;
                        }
                        db.saveUsers(model);
                        form.error("User Saved.");
                    } else {
                        form.error("Geen rol toegewezen.");
                    }
                } else {
                    form.error("Wachtwoord incorrect.");
                }
            } else {
                form.error("Niet alle velden ingevuld.");
            }
            return true;
        }
        );

        view.add(form.toNode(), 1, 2);

        UI.setLeft(view);

        UI.setCenter(form.toNode());

    }

}
