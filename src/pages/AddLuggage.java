package pages;

import UI.LuggageForm;
import UI.LuggageTable;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author Tom Scholten
 * @class add luggage
 * @date 07-12-15
 */
public class AddLuggage {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private models.Passenger passengerModel = new models.Passenger();
    private static final user.Session USER = user.Session.getInstance();

    public AddLuggage(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Bagage toevoegen");

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);
        form.addRow();

        form.addRow();
        form.addLabel("Merk: ");
        ObservableList<models.Brands> brandsModel = this.db.getBrands();
        form.addComboBox("brand_id", brandsModel);
        form.addRow();

        form.addLabel("Kleur: ");
        ObservableList<models.Colors> colorsModel = this.db.getColors();
        form.addComboBox("color_id", colorsModel);
        form.addRow();

        form.addRow();
        form.addLabel("Weight: ");
        form.addTextField("weight", false);

        form.addRow();
        form.addLabel("Materiaal: ");
        ObservableList<models.Materials> materialsModel = this.db.getMaterials();
        form.addComboBox("material_id", materialsModel);
        form.addRow();

        form.addRow();
        form.addLabel("Stickers: ");
        form.addTextField("stickers", false);

        form.addRow();
        form.addLabel("Characteristics: ");
        form.addTextArea("characteristics", false);

        form.addRow();
        form.addLabel("Riem: ");
        form.addComboBox("belt", new String[]{"Ja", "Nee"});

        form.addRow();
        form.addLabel("Type: ");
        ObservableList<models.Types> typeModel = this.db.getTypes();
        form.addComboBox("type_id", typeModel);
        form.addRow();

        form.addRow();
        form.addLabel("Vestigingen");
        ObservableList<models.Locations> locationsModel = this.db.getLocations();
        form.addComboBox("location_id", locationsModel);
        form.addRow();

        form.addRow();
        form.addLabel("Comment: ");
        form.addTextArea("comment", false);

        form.addRow();
        form.addLabel("Status:");
        form.addHRadioButtons("status", new String[]{"Gevonden", "Verloren"}, "Gevonden");

        
        LuggageTable table = new LuggageTable();
        
        table.onClick((Callable) () -> {
            passengerModel = (models.Passenger) table.getClicked();
            System.out.println(passengerModel.getId());
            return true;
        });

        String[] topText = {"Voornaam", "Tussenvoegsel", "Achternaam", "Datum toegevoegd", "Datum gewijzigd"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "date_added", "date_changed"}; // De variable namen van het object gesorteerd op de topText 

        models.Passenger zoek = new models.Passenger();

        ObservableList<models.Passenger> passengers = db.getPassenger(zoek);

        table.setTopRow(topText, topVars);

        table.setContent(passengers);

        form.addRow();
        form.addCol();
        form.addSubmitButton("Save");

        form.onSubmit((Callable) () -> {
            models.Luggage luggageModel = new models.Luggage();
            Object beltBox = form.getComboBoxSelected("belt");
            models.Brands brandsBox = (models.Brands) form.getComboBoxSelected("brand_id");
            if (brandsBox != null) {
                luggageModel.setBrand_id(brandsBox.getId());
            }
            models.Colors colorsBox = (models.Colors) form.getComboBoxSelected("color_id");
            if (colorsBox != null) {
                luggageModel.setColor_id(colorsBox.getId());
            }

            if (form.get("weight").contains(",")) {
                luggageModel.setWeight(Double.parseDouble(form.get("weight").replace(",", ".")));
            } else {
                luggageModel.setWeight(Double.parseDouble(form.get("weight")));
            }

            models.Materials materialsBox = (models.Materials) form.getComboBoxSelected("material_id");
            if (materialsBox != null) {
                luggageModel.setMaterial_id(materialsBox.getId());
            }
            luggageModel.setStickers(Integer.parseInt(form.get("stickers")));
            luggageModel.setCharacteristic(form.get("characteristics"));

            String beltString = beltBox.toString();
            switch (beltString) {
                case "Ja":
                    luggageModel.setBelt(1);
                    break;
                case "Nee":
                    luggageModel.setBelt(0);
                    break;
                default:
                    luggageModel.setBelt(0);
                    break;
            }
            System.out.println(form.get("belt"));
            luggageModel.setBelt((form.get("belt") == ("Ja")) ? 1 : 0);
            models.Types typesBox = (models.Types) form.getComboBoxSelected("type_id");
            if (typesBox != null) {
                luggageModel.setType_id(typesBox.getId());
            }
            models.Locations locationsBox = (models.Locations) form.getComboBoxSelected("location_id");
            if (locationsBox != null) {
                luggageModel.setLocation_id(locationsBox.getId());
            }
            luggageModel.setComment(form.get("comment"));
            luggageModel.setSituation(form.get("status"));
            if ("Verloren".equals(form.get("status"))) {
                System.out.println("in de if statement");
                luggageModel.setPassenger_id(passengerModel.getId());
                form.error("Passenger" + passengerModel.getFname() + passengerModel.getMname() + passengerModel.getLname());
            }
            form.error("overgeslagen");
            luggageModel.setUsers_id(USER.getUser().getId());

            db.saveLuggage(luggageModel);
            form.error("Luggage saved!");
            return true;
        });

        
        
        HBox box = new HBox();
        box.getChildren().addAll(form.toNode(), table.getTable());

        view.add(box, 0, 0);

        UI.setLeft(view);
        // Zet in de top van de BorderPane  
        UI.setCenter(form.toNode());
    }
}
