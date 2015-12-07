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
public class AddUser {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public AddUser(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Gebruiker toevoegen");

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);
        form.addRow();

        form.addLabel("Gebruikersnaam: ");
        form.addTextField("username", true);

        form.addRow();
        form.addLabel("Wachtwoord: ");
        form.addPassField("password", true);

        form.addRow();
        form.addLabel("Herhaal wachtwoord: ");
        form.addPassField("password2", Boolean.TRUE);

        form.addRow();
        form.addLabel("Voornaam: ");
        form.addTextField("fname", true);

        form.addRow();
        form.addLabel("Tussenvoegsel: ");
        form.addTextField("mname", false);

        form.addRow();
        form.addLabel("Achternaam: ");
        form.addTextField("lname", true);

        form.addRow();
        form.addLabel("Telefoonnummer: ");
        form.addTextField("phone", true);

        form.addRow();
        form.addLabel("Medewerkersnummer: ");
        form.addTextField("ee_num", true);

        form.addRow();
        form.addLabel("Rol: ");
        form.addComboBox("role", new String[]{"Medewerker", "Manager", "Admin"});

        form.addRow();
        form.addLabel("Vestiging: ");
        ObservableList<models.Locations> locationModel = this.db.getLocations();
        form.addComboBox("location_id", locationModel);

        form.addRow();
        form.addCol();
        form.addSubmitButton("Save");
        form.onSubmit((Callable) () -> {
            models.Users newUser = new models.Users();
            Object roleBox = form.getComboBoxSelected("role");
            if ((form.get("password").equals(form.get("password2"))) && (roleBox != null)) {
                newUser.setUsername(form.get("username"));
                newUser.setPassword(form.get("password"));
                newUser.setFname(form.get("fname"));
                newUser.setMname(form.get("mname"));
                newUser.setLname(form.get("lname"));
                newUser.setPhone(form.get("phone"));
                newUser.setEe_num(form.get("ee_num"));
                String roleString = roleBox.toString();
                switch (roleString) {
                    case "Mederwerker":
                        newUser.setEmployee(1);
                        newUser.setAdmin(0);
                        newUser.setManager(0);
                        break;
                    case "Manager":
                        newUser.setManager(1);
                        newUser.setEmployee(0);
                        newUser.setAdmin(0);
                        break;
                    case "Administrator":
                        newUser.setAdmin(1);
                        newUser.setManager(0);
                        newUser.setEmployee(0);
                        break;
                }
                models.Locations locationsBox = (models.Locations) form.getComboBoxSelected("location_id");
                if (locationsBox != null) {
                    newUser.setLocation_id(locationsBox.getId());
                }
                System.out.println("Now saving");
                System.out.println(newUser.getLocation_id());
                db.saveUsers(newUser);
                form.error("User saved");
            } else {
                form.error("Wachtwoord incorrect en/of geen rol toegekend!");
            }
            return true;
        });

        view.add(form.toNode(), 1, 2);

        UI.setLeft(view);
        // Zet in de top van de BorderPane  
        UI.setCenter(form.toNode());
    }
}
