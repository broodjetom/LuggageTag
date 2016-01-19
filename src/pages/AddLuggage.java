package pages;

/**
 * Imports die deze class nodig heeft.
 */
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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;

/**
 *
 * @author Tom Scholten
 */
public class AddLuggage {

    private LuggageUI UI;
    private DatabaseManager db;
    
    /**
     * Maakt een nieuwe GridPane voor, een Gridpane zorgt voor de plaatsing en uiterlijk
     * van het programma, dus waar een knop staat en welke kleur de achtergrond is etc.
     */
    private GridPane view = new GridPane();
    
    /**
     * Objecten Models.pass en user.sess worden aangemaakt met naam.
     * models.Passenger is een leeg model die data kan ophalen uit de database.
     * User session maakt het mogelijk om in te loggen als een gebruiker, 
     * de data van je "Account" word hier bewaard.
     */
    private models.Passenger passengerModel = new models.Passenger();
    private static final user.Session USER = user.Session.getInstance();

    /**
     * Show add luggage page
     * @param UI
     * @throws SQLException
     * @throws IOException
     */
    public AddLuggage(LuggageUI UI) throws SQLException, IOException {
        
        /**
         * Maakt de standaard UI aan, en zorgt dat de page "ADDluggage" word geopend
         */
        
        this.UI = UI;
        this.db = DatabaseManager.getInstance();
        
        /**
         * setCurpage zorgt ervoor dat het programma weet welke pagina 
         * de gebruiker ziet, zodat het F1 scherm overeenkomt met het 
         * scherm dat de gebruiker ziet.
         */
        UI.setCurPage("AddLuggage");
        
        /**
         * Zet de "Padding" voor de pagina, dus van boven,rechts,onder,links
         * 50,50,50,50. Ruimte.
         */
        view.setPadding(new Insets(50, 50, 50, 50));
        
        /**
         * Maakt een nieuwe titel aan van de pagina, om duidelijker te maken
         * voor de gebruiker welke pagina hij zich bevindt
         */
        Label heading = UI.createHeading("Bagage toevoegen");
        
        //Roept de form aan.
        LuggageForm form = new LuggageForm(UI);
        form.add(heading); //maakt een plaats aan voor de heading
        form.addRow(); //Gaat naar de volgende regel

        form.addRow();
        form.addLabel("Brand: "); //Voegt een label toe voor het scherm
        ObservableList<models.Brands> brandsModel = this.db.getBrands(); //Haalt het model op voor de brands(db model) "GETbrands"
        form.addComboBox("brand_id", brandsModel); //maakt een combobox knop aan voor gebruiker, "brand_id" is voor db
        form.addRow();

        form.addLabel("Color: ");
        ObservableList<models.Colors> colorsModel = this.db.getColors();
        form.addComboBox("color_id", colorsModel);
        form.addRow(); //Idem

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
        form.addLabel("Belt: ");
        form.addComboBox("belt", new String[]{"Yes", "No"});

        form.addRow();
        form.addLabel("Type: ");
        ObservableList<models.Types> typeModel = this.db.getTypes();
        form.addComboBox("type_id", typeModel);
        form.addRow();

        form.addRow();
        form.addLabel("Location: ");
        ObservableList<models.Locations> locationsModel = this.db.getLocations();
        form.addComboBox("location_id", locationsModel);
        form.addRow();

        form.addRow();
        form.addLabel("Comment: ");
        form.addTextArea("comment", false);

        form.addRow();
        form.addLabel("Status:");
        form.addHRadioButtons("status", new String[]{"Gevonden", "Verloren"}, "Gevonden");

        
        LuggageTable table = new LuggageTable(); //Maakt een tabel aan in het programma om alle waarde van passenger op te tonen

        table.onClick((Callable) () -> { //Maakt het mogelijk om op een record te klikken 
            passengerModel = (models.Passenger) table.getClicked(); //Haalt hiermee de geklikte record op in de database.
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //Maakt object aan, voor een "warning screen"
            alert.setTitle("Link new user"); //Titel van popup scherm
            alert.setHeaderText("You're about to change the linked passenger"); //Text in de pup op
            alert.setContentText("Cange passenger to " + passengerModel.getFullName() + "?"); 

            Optional<ButtonType> result = alert.showAndWait(); //-----------------------------------------------------------------------------------------------------------------
            if (result.get() == ButtonType.OK) {
                
            } else {
                passengerModel = null;
            }
            return true;
        });

        String[] topText = {"First name", "Insertion", "Last name", "Date added", "Date edited"}; // texten die bovenaan de tabel verschijnen
        String[] topVars = {"fname", "mname", "lname", "date_added", "date_changed"}; // De variable namen van het object gesorteerd op de topText 

        models.Passenger zoek = new models.Passenger(); 

        ObservableList<models.Passenger> passengers = db.getPassenger(zoek);

        table.setTopRow(topText, topVars); //Zet de Strings topText en topVars in tabel

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
        form2.onSubmit((Callable) () -> {  //als er op submit word gedrukt.
            models.Passenger zoekNew = new models.Passenger(); //Nieuw model passenger genaamd zoekNew
            
            zoekNew.setFname(form2.get("fname"));  //Methode voor tijdelijk opslaan van data (fname)
            zoekNew.setMname(form2.get("mname"));
            zoekNew.setLname(form2.get("lname"));
            
            ObservableList<models.Passenger> passengersZoek = db.getPassenger( zoekNew ); //Data word opgehaald uit de OSL
            
            table.setContent(passengersZoek); //Hier word de data in de tabel gezet.
            return true;
        });

        form.addRow();
        form.addCol();
        form.addSubmitButton("Save");
        
        //ADD LUGGAGE
        form.onSubmit((Callable) () -> { //als er op submit word gedrukt
            models.Luggage luggageModel = new models.Luggage(); //Nieuw model word aangemaakt 
            Object beltBox = form.getComboBoxSelected("belt"); //data word gecheckt voordat het naar de database gaat.
            models.Brands brandsBox = (models.Brands) form.getComboBoxSelected("brand_id"); //alle modellen worden gecheckt of er data in zit
            if (brandsBox != null) { //als dat niet zo is
                luggageModel.setBrand_id(brandsBox.getId()); //word de standaard constructor aangeroepen die de waarde null meegeeft
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
            luggageModel.setStickers(Integer.parseInt(form.get("stickers"))); //alle data word opgehaald om het model te vullen
            luggageModel.setCharacteristic(form.get("characteristics"));

            String beltString = beltBox.toString();
            switch (beltString) { //switch, als yes setbelt 1 etc..
                case "Yes":
                    luggageModel.setBelt(1);
                    break;
                case "No":
                    luggageModel.setBelt(0);
                    break;
                default:
                    luggageModel.setBelt(0);
                    break;
            }
            
            luggageModel.setBelt((form.get("belt") == ("Yes")) ? 1 : 0);
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
            
            if( passengerModel != null )
                luggageModel.setPassenger_id(passengerModel.getId()); //Wat doet dit en waarom?
            
            if ("Verloren".equals(form.get("status"))) {
                form.error("Passenger" + passengerModel.getFullName());
            }
            form.error("overgeslagen");
            luggageModel.setUsers_id(USER.getUser().getId());

            db.saveLuggage(luggageModel);
            form.error("Luggage saved!");
            return true;
        });

        
        
        HBox box = new HBox(); //Hbox?
        box.getChildren().addAll(form.toNode(), table.getTable());
        
        view.add(form2.toNode(), 0, 0);
        view.add(box, 0, 1);

        UI.setLeft(view);
        // Zet in de top van de BorderPane  
        UI.setCenter(form.toNode());
    }
}
