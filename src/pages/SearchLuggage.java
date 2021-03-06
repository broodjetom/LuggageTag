
package pages;

import UI.LuggageForm;
import UI.LuggageTable;
import UI.LuggageUI;
import database.DatabaseManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
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
public class SearchLuggage {

    private LuggageUI UI;
    private DatabaseManager db;

    private GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show search luggage page
     *
     * @param UI
     * @throws SQLException
     * @throws IOException
     */
    public SearchLuggage(LuggageUI UI) throws SQLException, IOException {

        this.UI = UI;
        this.db = DatabaseManager.getInstance();

         // F1 scherm directie geven
        UI.setCurPage("SearchLuggage");

        view.setPadding(new Insets(50, 50, 50, 50));

        // Titel aanpassen
        UI.setTitle("Search Database");

        // Nieuwe tabel aanmaken
        LuggageTable table = new LuggageTable();

        // In een row klikken zorgt dat het scherm LuggagDetails komt
        table.onClick((Callable) () -> {
            models.Luggage row = (models.Luggage) table.getClicked();
            LuggageDetails page = new LuggageDetails(UI, row);
            return true;
        });

        // texten die bovenaan de tabel verschijnen
        String[] topText = {"Brand", "Color", "Weight", "Material",
            "Amount of Stickers", "Has belt", "Type", "Status", "Location",
            "Date added", "Date changed"};

        // De variable namen van het object gesorteerd op de topText 
        String[] topVars = {"brand", "color", "weight", "material", "stickers",
            "belt", "type", "situation", "location", "date_added", "date_changed"};

        // Zoeken naar passenger
        models.Luggage zoek = new models.Luggage();

        // Geef een lijst van alle luggage
        
        ObservableList<models.Luggage> luggage = db.getLuggage(zoek);

        // Set de top rij
        table.setTopRow(topText, topVars);

        // Set de data voor in de tabel
        table.setContent(luggage);

        GridPane test = new GridPane();
        test.setPadding(new Insets(50, 50, 50, 50));

        // Maak de Search form aan
        Label heading = UI.createHeading("Search");

        test.add(heading, 1, 1);

        LuggageForm form = new LuggageForm(UI);

        form.addLabel("Brand: ");
        ObservableList<models.Brands> brandsModel = this.db.getBrands();
        form.addComboBox("brand_id", brandsModel);
        form.addRow();

        form.addLabel("Color: ");
        ObservableList<models.Colors> colorsModel = this.db.getColors();
        form.addComboBox("color_id", colorsModel);
        form.addRow();

        form.addLabel("Weight: ");
        form.addTextField("weight", false);
        form.addRow();

        form.addLabel("Material: ");
        ObservableList<models.Materials> materialsModel = this.db.getMaterials();
        form.addComboBox("material_id", materialsModel);
        form.addRow();

        form.addLabel("Stickers: ");
        form.addTextField("stickers", false);
        form.addRow();

        form.addLabel("Belt: ");
        form.addTextField("belt", false);
        form.addRow();

        form.addLabel("Type: ");

        ObservableList<models.Types> typeModel = this.db.getTypes();
        form.addComboBox("type_id", typeModel);
        form.addRow();

        form.addRow();
        form.addLabel("Status:");
        form.addComboBox("status", new String[]{"Gevonden", "Verloren", "Afgehandeld"});
        form.addRow();
        
        //Clear button werkt niet
        Button forgotPassword = UI.createGreyButton("Clear", false, (Callable) () -> {
            return true;
        });

        // Knop om te kijken of er een of meer zoekresultaten zijn
        form.add(forgotPassword);
        form.addSubmitButton("Search");

        form.onSubmit((Callable) () -> {
            models.Luggage zoekNew = new models.Luggage();

            models.Brands brandBox = (models.Brands) form.getComboBoxSelected("brand_id");
            if (brandBox != null) {
                zoekNew.setBrand_id(brandBox.getId());
            }

            models.Colors colorBox = (models.Colors) form.getComboBoxSelected("color_id");
            if (colorBox != null) {
                zoekNew.setColor_id(colorBox.getId());
            }

            models.Materials materialBox = (models.Materials) form.getComboBoxSelected("material_id");
            if (materialBox != null) {
                zoekNew.setMaterial_id(materialBox.getId());
            }

            models.Types typeBox = (models.Types) form.getComboBoxSelected("type_id");
            if (typeBox != null) {
                zoekNew.setType_id(typeBox.getId());
            }

            if (!form.get("weight").isEmpty()) {
                if (form.get("weight").contains(",")) {
                    zoekNew.setWeight(Double.parseDouble(form.get("weight").replace(",", ".")));
                } else {
                    zoekNew.setWeight(Double.parseDouble(form.get("weight")));
                }
            }

            String selected = (String) form.getComboBoxSelected("status");

            zoekNew.setSituation(selected);
            
            // Get the resultaten
            ObservableList<models.Luggage> passengersZoek = db.getLuggage(zoekNew);
            table.setContent(passengersZoek);
            return true;
        });

        test.add(form.toNode(), 1, 2);
       
        // Set de search velden naar links
        UI.setLeft(test);
        
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());

    }
}
