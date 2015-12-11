/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.LuggageForm;
import UI.LuggageTable;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alex
 */
public class UsersPage {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public UsersPage(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Search Users");

        LuggageTable table = new LuggageTable();
        
        table.onClick((Callable) () -> {
            models.Users row = (models.Users)table.getClicked();
            EditUser edit = new EditUser(UI, db, row);
            return true;
        });

        String[] topText = {"First name", "Insertion", "Last name", "Phone number", "Employee number", "Is employee", "Is manager", "Is admin", "Location"};
        String[] topVars = {"fname", "mname", "lname", "phone", "ee_num", "employee", "manager", "admin", "location"};

        models.Users zoek = new models.Users();

        ObservableList<models.Users> users = db.getUsers(zoek);

        table.setTopRow(topText, topVars);

        table.setContent(users);

        GridPane test = new GridPane();
        test.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Search");

        test.add(heading, 1, 1);

        LuggageForm form = new LuggageForm(UI);
        form.addLabel("First name: ");
        form.addTextField("fname", false);
        form.addRow();

        form.addLabel("Instertion: ");
        form.addTextField("mname", false);
        form.addRow();

        form.addLabel("Last name: ");
        form.addTextField("lname", false);
        form.addRow();

        form.addLabel("Phone: ");
        form.addTextField("phone", false);
        form.addRow();

        form.addLabel("Location: ");
        ObservableList<models.Locations> locationModel = this.db.getLocations();
        form.addComboBox("location", locationModel);
        form.addRow();

        form.addLabel("Employee number: ");
        form.addTextField("ee_num", false);
        form.addRow();

        form.addLabel("Role: ");
        form.addComboBox("role", new String[]{"Mederwerker", "Manager", "Admin"});
        form.addRow();

        Button forgotPassword = UI.createGreyButton("Clear", false, (Callable) () -> {
            return true;
        });

        form.add(forgotPassword);
        form.addSubmitButton("Search");
        
        form.onSubmit((Callable) () -> {
            models.Users zoekNew = new models.Users();
            
            zoekNew.setFname(form.get("fname"));
            zoekNew.setMname(form.get("mname"));
            zoekNew.setLname(form.get("lname"));
            zoekNew.setEe_num(form.get("ee_num"));
            

            Object roleBox = form.getComboBoxSelected("role");
            if (roleBox != null) {
                String roleString = roleBox.toString();
                switch( roleString ){
                    case "Mederwerker":
                        zoekNew.setEmployee(1);
                        zoekNew.setAdmin(0);
                        zoekNew.setManager(0);
                        break;
                    case "Manager":
                        zoekNew.setManager(1);
                        zoekNew.setEmployee(0);
                        zoekNew.setAdmin(0);
                        break;
                    case "Administrator":
                        zoekNew.setAdmin(1);
                        zoekNew.setManager(0);
                        zoekNew.setEmployee(0);
                        break;
                    default:
                        break;
                }
            }

            ObservableList<models.Users> userZoek = db.getUsers(zoekNew);

            table.setContent(userZoek);

            return true;
        });

        test.add(form.toNode(), 1, 2);

        UI.setLeft(test);
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());
    }
    
//    public String checkmark(String input){
//        char mark;
//        if (input.equals("1")) {
//            mark = '\u2713';
//        } else {
//            mark = '\u2717';
//        }
//        return ""+mark;
//    }
}
