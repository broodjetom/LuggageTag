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
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public SearchLuggage(LuggageUI UI, DatabaseManager db) throws SQLException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));
        
        UI.setTitle("Search Database");

        LuggageTable table = new LuggageTable();
        
        table.onClick((Callable) () -> {
            models.Passenger row = (models.Passenger)table.getClicked();
            System.out.println(row.getFname());
            return true;
        });

        String[] topText = {"Voornaam", "Tussenvoegsel", "Achternaam", "Vluchtnummer", "Merk", "Kleur", "Gewicht", "Materiaal", "Stickers", "Kofferriem", "Koffer soort", "Opmerkingen", "Gebruikers", "Datum toegevoegd", "Datum gewijzigd", "Datum Afgehandeld"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "flight", "brand", "color", "weight", "material", "stickers", "belt", "type", "comment", "users_id", "date_added", "date_changed", "date_finished"}; // De variable namen van het object gesorteerd op de topText 
        
        // Zoeken naar passenger
        models.Passenger zoek = new models.Passenger();
        
        
        ObservableList<models.Passenger> passengers = db.getPassenger( zoek );
        
        
        // Set de top rij
        table.setTopRow(topText, topVars);
        
        // Set de data voor in de tabel
        table.setContent(passengers);
        
        GridPane test = new GridPane();
        test.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Zoeken");

        test.add(heading, 1, 1);
        
        LuggageForm form = new LuggageForm(UI);
        form.addLabel("Voornaam: ");
        form.addTextField("fname", false);
        form.addRow();
        
        form.addLabel("Tussenvoegsel: ");
        form.addTextField("mname", false);
        form.addRow();
        
        form.addLabel("Achternaam: ");
        form.addTextField("lname", false);
        form.addRow();
        
        form.addLabel("Vluchtnummer: ");
        form.addTextField("flight", false);
        form.addRow();
        
        form.addLabel("Merk: ");
        ObservableList<models.Brands> brandsModel = this.db.getBrands();
        form.addComboBox("brand_id", brandsModel);
        form.addRow();
        
        form.addLabel("Kleur: ");
        ObservableList<models.Colors> colorsModel = this.db.getColors();
        form.addComboBox("color_id", colorsModel);
        form.addRow();
        
        form.addLabel("Gewicht: ");
        form.addTextField("weight", false);
        form.addRow();
        
        form.addLabel("Materiaal: ");
        ObservableList<models.Materials> materialsModel = this.db.getMaterials();
        form.addComboBox("material_id", materialsModel);
        form.addRow();
        
        form.addLabel("Stickers: ");
        form.addTextField("stickers", false);
        form.addRow();  
        
        form.addLabel("Kofferriem: ");
        form.addTextField("belt", false);
        form.addRow();
        
        form.addLabel("Type bagage: ");
        
        ObservableList<models.Types> typeModel = this.db.getTypes();
        form.addComboBox("type_id", typeModel);
        form.addRow();
       
        form.addRow();
        form.addLabel("Status:");
        
        
        form.addComboBox("status", new String[]{"Gevonden", "Verloren", "Afgehandeld"});
        form.addRow();
        
        Button forgotPassword = UI.createGreyButton("Clear", false, (Callable) () -> {
            return true;
        });

        form.add(forgotPassword);
        form.addSubmitButton("Search");
        
        form.onSubmit((Callable) () -> {
            models.Passenger zoekNew = new models.Passenger();
            
            zoekNew.setFname(form.get("fname"));
            zoekNew.setMname(form.get("mname"));
            zoekNew.setLname(form.get("lname"));
            zoekNew.setFlight(form.get("flight"));
            //zoekNew.setWeight(Double.parseDouble(form.get("weight")));
            //zoekNew.setStickers(Integer.parseInt(form.get("stickers")));
           // zoekNew.setBelt(Integer.parseInt(form.get("belt")));
           
            models.Brands brandBox = (models.Brands)form.getComboBoxSelected("brand_id");
            if( brandBox != null )
                zoekNew.setBrand_id(brandBox.getId());
            
            models.Colors colorBox = (models.Colors)form.getComboBoxSelected("color_id");
            if( colorBox != null )
                zoekNew.setColor_id(colorBox.getId());
            
            models.Materials materialBox = (models.Materials)form.getComboBoxSelected("material_id");
            if( materialBox != null )
                zoekNew.setMaterial_id(materialBox.getId());
            
            models.Types typeBox = (models.Types)form.getComboBoxSelected("type_id");
            if( typeBox != null )
                zoekNew.setType_id(typeBox.getId());
            
            
            
            ObservableList<models.Passenger> passengersZoek = db.getPassenger( zoekNew );
            
            table.setContent(passengersZoek);
            return true;
        });
        
        test.add(form.toNode(), 1, 2);
        
        UI.setLeft(test);
        // Zet in de top van de BorderPane
        UI.setCenter(table.getTable());
        

    }
}
