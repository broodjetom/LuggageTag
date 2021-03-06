package pages;

import UI.LuggageForm;
import UI.LuggageTable;
import UI.LuggageUI;
import database.DatabaseManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.Callable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * @author Tom Scholten
 */
public class EditLuggage {

    private LuggageUI UI;
    private DatabaseManager db;

    private GridPane view = new GridPane();

    private models.Passenger passengerModel = new models.Passenger();
    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show edit luggage page
     * @param UI
     * @param model models.Luggage to edit
     * @throws SQLException
     * @throws IOException
     */
    public EditLuggage(LuggageUI UI, models.Luggage model) throws SQLException, IOException {
        this.UI = UI;
        this.db = DatabaseManager.getInstance();

        view.setPadding(new Insets(50, 50, 50, 50));

        passengerModel = db.getPassenger(model.getPassenger_id());

        UI.setTitle("Edit luggage");

        LuggageForm form = new LuggageForm(UI);

        form.addRow();
        form.addLabel("Brand: ");
        ObservableList<models.Brands> brandsModel = this.db.getBrands();
        form.addComboBox("brand_id", brandsModel, model.getBrand());
        form.addRow();

        form.addLabel("Color: ");
        ObservableList<models.Colors> colorsModel = this.db.getColors();
        form.addComboBox("color_id", colorsModel, model.getColor());
        form.addRow();

        form.addRow();
        form.addLabel("Weight: ");
        form.addTextField("weight", false, String.valueOf(model.getWeight()));

        form.addRow();
        form.addLabel("Material: ");
        ObservableList<models.Materials> materialsModel = this.db.getMaterials();
        form.addComboBox("material_id", materialsModel, model.getMaterial());
        form.addRow();

        form.addRow();
        form.addLabel("Stickers: ");
        form.addTextField("stickers", false, String.valueOf(model.getStickers()));

        form.addRow();
        form.addLabel("Characteristics: ");
        form.addTextArea("characteristics", false, model.getCharacteristic());

        form.addRow();
        form.addLabel("Belt: ");
        form.addComboBox("belt", new String[]{"Ja", "Nee"});

        form.addRow();
        form.addLabel("Type: ");
        ObservableList<models.Types> typeModel = this.db.getTypes();
        form.addComboBox("type_id", typeModel, model.getType());
        form.addRow();

        form.addRow();
        form.addLabel("Location");
        ObservableList<models.Locations> locationsModel = this.db.getLocations();
        form.addComboBox("location_id", locationsModel, model.getLocation());
        form.addRow();

        form.addRow();
        form.addLabel("Comment: ");
        form.addTextArea("comment", false, model.getComment());

        form.addRow();
        form.addLabel("Status:");
        form.addHRadioButtons("status", new String[]{"Gevonden", "Verloren"}, "Gevonden");
        
        LuggageTable table = new LuggageTable();

        table.onClick((Callable) () -> {
            passengerModel = (models.Passenger) table.getClicked();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Link new user");
            alert.setHeaderText("You're about to change the linked passenger");
            alert.setContentText("Are you sure you want to change the passenger to " + passengerModel.getFullName() + "?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                models.Luggage luggageModel = model;
                luggageModel.setPassenger_id(passengerModel.getId());
                db.saveLuggage(luggageModel);
            } else {
                // ... user chose CANCEL or closed the dialog
            }
            return true;
        });

        String[] topText = {"First name", "Insertion", "Last name", "Date added", "Date edited"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "date_added", "date_changed"}; // De variable namen van het object gesorteerd op de topText 

        models.Passenger zoek = new models.Passenger();

        ObservableList<models.Passenger> passengers = db.getPassenger(zoek);

        table.setTopRow(topText, topVars);

        table.setContent(passengers);
        
        LuggageForm form2 = new LuggageForm(UI);
        form2.addLabel("First name: ");
        form2.addTextField("fname", false);
        form2.addRow();
        
        form2.addLabel("Insertion: ");
        form2.addTextField("mname", false);
        form2.addRow();
        
        form2.addLabel("Last name: ");
        form2.addTextField("lname", false);
        form2.addRow();
        
        form2.addCol();
        form2.addSubmitButton("Search");
        form2.addRow();
        form2.onSubmit((Callable) () -> {
            models.Passenger zoekNew = new models.Passenger();
            
            zoekNew.setFname(form2.get("fname"));
            zoekNew.setMname(form2.get("mname"));
            zoekNew.setLname(form2.get("lname"));
            
            ObservableList<models.Passenger> passengersZoek = db.getPassenger( zoekNew );
            
            table.setContent(passengersZoek);
            return true;
        });
        
        form.addRow();
        form.addCol();
        form.addSubmitButton("Save");

        form.onSubmit((Callable) () -> {
            models.Luggage luggageModel = model;
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
            //if ("Verloren".equals(form.get("status"))) { Moet met elke status kunnen
            System.out.println("in de if statement");
            luggageModel.setPassenger_id(passengerModel.getId());
            form.error("Passenger" + passengerModel.getFname() + passengerModel.getMname() + passengerModel.getLname());
            //}
            form.error("overgeslagen");
            luggageModel.setUsers_id(USER.getUser().getId());

            db.saveLuggage(luggageModel);
            form.error("Luggage saved!");
            return true;
        });

        HBox box = new HBox();
        box.getChildren().addAll(form.toNode(), table.getTable());
        
        view.add(form2.toNode(), 0, 0);
        view.add(box, 0, 1);

        UI.setLeft(view);
        // Zet in de top van de BorderPane  
        UI.setCenter(form.toNode());

    }
}
