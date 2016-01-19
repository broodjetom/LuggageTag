package pages;

import UI.LuggageForm;
import UI.LuggageTable;
import UI.LuggageUI;
import database.DatabaseManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * @author ________ Jimmy van Wieringen 
 * Student nummer:_ 500728110
 * Groep:__________ IS102
 */
public class Overview {

    private LuggageUI UI;
    private DatabaseManager db;
    private GridPane view = new GridPane();
    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show search luggage page
     *
     * @param UI
     * @throws SQLException, geeft informatie weer tijdens database toegang of andere errors
     * @throws IOException geeft informatie weer als er input of output wordt gegeven
     */
    public Overview(LuggageUI UI) throws SQLException, IOException {
        this.UI = UI;
        this.db = DatabaseManager.getInstance();

        //Zet de CurPage op "Overview", zodat de F1 class kan identificeren welke IMG je nodig hebt
        UI.setCurPage("Overview");

        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Overview");

        LuggageTable table = new LuggageTable();

        table.onClick((Callable) () -> {
            models.Luggage row = (models.Luggage) table.getClicked();
            LuggageDetails page = new LuggageDetails(UI, row);
            return true;
        });

        // Zoeken naar passenger
        models.Luggage zoek = new models.Luggage();

        String[] topText = {"Brand", "Color", "Weight", "Material", "Amount of Stickers", "Has belt", "Type", "Status", "Location", "Date added", "Date changed"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"brand", "color", "weight", "material", "stickers", "belt", "type", "situation", "location", "date_added", "date_changed"}; // De variable namen van het object gesorteerd op de topText 

        ObservableList<models.Luggage> luggage = db.getLuggage(zoek);

        // Set de top rij in de tabel
        table.setTopRow(topText, topVars);

        // Set de data voor in de tabel
        table.setContent(luggage);

        GridPane test = new GridPane();
        test.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Search");

        test.add(heading, 1, 1);

        LuggageForm form = new LuggageForm(UI);

        form.addRow();
        form.addLabel("Status:");

        form.addComboBox("status", new String[]{"Gevonden", "Verloren", "Afgehandeld"});
        form.addRow();

        form.addCol();
        form.addSubmitButton("Search");

        form.onSubmit((Callable) () -> {
            models.Luggage zoekNew = new models.Luggage();                                          //Maakt een nieuwe object aan

            String selected = (String) form.getComboBoxSelected("status");                          //Selecteert "status" en verandert het terug naar een String datatype

            zoekNew.setSituation(selected);                                                         //Set de gekozen status van een bagage

            ObservableList<models.Luggage> passengersZoek = db.getLuggage(zoekNew);                 //Zoekt de gekozen status op in de database

            table.setContent(passengersZoek);                                                       //Verandert de inhoud van de tabel naar de gekozen optie
            return true;
        });

        test.add(form.toNode(), 1, 2);

        UI.setLeft(test);
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());

    }
}
