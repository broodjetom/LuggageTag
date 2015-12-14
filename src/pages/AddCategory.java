package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * @Author Tom Scholten
 * @Class
 * @Date
 */
public class AddCategory {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public AddCategory(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Categorieën toevoegen");

        VBox vBox = new VBox();

        LuggageForm form = new LuggageForm(UI);
        form.add(heading);

        form.addRow();
        LuggageForm brandForm = new LuggageForm(UI);
        brandForm.addLabel("Brand:\t\t");
        brandForm.addTextField("brand", false);
        brandForm.addSubmitButton("Toevoegen");
        brandForm.onSubmit((Callable) () -> {
            if (brandForm.get("brand").isEmpty()) {
                brandForm.error("Field is empty");
            } else {
                models.Brands brandModel = new models.Brands();
                brandModel.setBrand(brandForm.get("brand"));
                db.saveBrand(brandModel);
                brandForm.error("Brand saved!");
            }
            return true;
        });

        brandForm.addRow();
        LuggageForm colorForm = new LuggageForm(UI);
        colorForm.addLabel("Color:\t\t");
        colorForm.addTextField("color", false);
        colorForm.addSubmitButton("Toevoegen");
        colorForm.onSubmit((Callable) () -> {
            if (colorForm.get("color").isEmpty()) {
                colorForm.error("Field is empty!");
            } else {
                models.Colors colorModel = new models.Colors();
                colorModel.setColor(colorForm.get("color"));
                db.saveColor(colorModel);
                colorForm.error("Color saved!");
            }
            return true;
        });

        colorForm.addRow();
        LuggageForm materialForm = new LuggageForm(UI);
        materialForm.addLabel("Material:\t");
        materialForm.addTextField("material", false);
        materialForm.addSubmitButton("Toevoegen");
        materialForm.onSubmit((Callable) () -> {
            if (materialForm.get("material").isEmpty()) {
                materialForm.error("Field is empty!");
            } else {
                models.Materials materialModel = new models.Materials();
                materialModel.setMaterial(materialForm.get("material"));
                db.saveMaterial(materialModel);
                materialForm.error("Material saved!");
            }
            return true;
        });

        materialForm.addRow();
        LuggageForm typeForm = new LuggageForm(UI);
        typeForm.addLabel("Type:\t\t");
        typeForm.addTextField("type", false);

        typeForm.addSubmitButton("Toevoegen");
        typeForm.onSubmit((Callable) () -> {
            if (typeForm.get("type").isEmpty()) {
                typeForm.error("Field is empty!");
            } else {
                models.Types typeModel = new models.Types();
                typeModel.setType(typeForm.get("type"));
                db.saveType(typeModel);
                typeForm.error("Type saved!");
            }
            return true;
        });

        typeForm.addRow();
        LuggageForm locationForm = new LuggageForm(UI);
        locationForm.addLabel("Location:\t");
        locationForm.addTextField("location", true);
        locationForm.addLabel("Address:");
        locationForm.addTextField("address", true);
        locationForm.addLabel("Zip:");
        locationForm.addTextField("zip", true);
        locationForm.addLabel("Country:");
        locationForm.addTextField("land", true);
        locationForm.addSubmitButton("Toevoegen");
        locationForm.onSubmit((Callable) () -> {
            if (locationForm.get("location").isEmpty()) {
                locationForm.error("Field is empty!");
            } else {
                models.Locations locationModel = new models.Locations();
                locationModel.setLocation(locationForm.get("location"));
                locationModel.setAddress(locationForm.get("address"));
                locationModel.setZip(locationForm.get("zip"));
                locationModel.setLand(locationForm.get("land"));
                db.saveLocation(locationModel);
                locationForm.error("Location saved!");
            }
            return true;
        });

        vBox.getChildren().addAll(form.toNode(), brandForm.toNode(), colorForm.toNode(), materialForm.toNode(),
                typeForm.toNode(), locationForm.toNode());

        view.add(vBox, 1, 2);

        UI.setCenter(view);
        UI.setLeft(view);

    }
}
