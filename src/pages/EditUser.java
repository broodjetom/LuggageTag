package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Alex
 */
public class EditUser {
    private LuggageUI UI;
    private DatabaseManager db;
    private models.Users editUser;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public EditUser(LuggageUI UI, DatabaseManager db, models.Users user) throws SQLException {
        this.UI = UI;
        this.db = db;
        this.editUser = user;
        
        view.add(createForm().toNode(), 0, 0);
        
        VBox left = new VBox();
        
        Button save = UI.createSecondaryButton("Save", false, (Callable) () -> {
            ForgotPassword ForgotPassword = new ForgotPassword(UI, db);
            return true;
        });
        
        Button back = UI.createRedButton("Go back", false, (Callable) () -> {
            ForgotPassword ForgotPassword = new ForgotPassword(UI, db);
            return true;
        });
        
        left.getChildren().addAll(save, back);
        
        UI.setLeft(left);
        UI.setCenter(view);
    }
    
    private LuggageForm createForm(){
        LuggageForm form = new LuggageForm(this.UI);
        Label heading = UI.createHeading("Bewerk gebruiker: "+ editUser.getFname());
        form.addRow();
        
        form.addTextField("fname", Boolean.TRUE, editUser.getFname());
       
        
        return form;
    }
}
