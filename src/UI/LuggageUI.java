package UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 * Create main UI
 * @author Alex
 */
public class LuggageUI {

    public Stage primaryStage;
    public Scene scene;
    public BorderPane root;
    
    // Fonts
    public Font uniSansHeavy;
    public Font uniSansSemiBoldItalic;
    public Font openSans;

    public String title;
    
    // De prefix van de titel van de applicatie
    final private String TITLE_PREFIX = "Luggage Tag - ";
    
    final public String GLOBAL_BACKGROUND_COLOR = "FFFFFF";
    
    final public String COLOR_RED = "D81E05";
    final public String COLOR_GREY = "333333";
    
    // Variablen om de primaire kleuren van de knoppen op te slaan
    final public String BUTTON_PRIMARY_BACKGOUND_COLOR = "D81E05";
    final public String BUTTON_PRIMARY_BACKGOUND_HOVER_COLOR = "B81A04";
    final public String BUTTON_PRIMARY_TEXT_COLOR = "FFFFFF";
    
    // Variablen om de secundaire kleuren van de knoppen op te slaan
    final public String BUTTON_SECONDARY_BACKGOUND_COLOR = "1E8410";
    final public String BUTTON_SECONDARY_BACKGOUND_HOVER_COLOR = "26A514";
    final public String BUTTON_SECONDARY_TEXT_COLOR = "FFFFFF";
    
    // Variablen om de grijze kleuren van de knoppen op te slaan
    final public String GREY_BUTTON_BACKGOUND_COLOR = "808080";
    final public String GREY_BUTTON_BACKGOUND_TEXT_COLOR = "FFFFFF";
    
    
    /**
     * Init the UI class
     * @param primaryStage the JavaFX primaryStage
     */
    public LuggageUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new BorderPane();
        root.setStyle("-fx-background-color: #"+GLOBAL_BACKGROUND_COLOR);
        root.maxHeightProperty();
        registerFonts();
    }
    
    /**
     * Set the title of the window, prefixed the the predefined string
     * @param title 
     */
    public void setTitle(String title) {
        primaryStage.setTitle(TITLE_PREFIX + title);
    }
    
    /**
     * Creates a red button
     * @param text Content of the button
     * @param active Active state of the button
     * @param clickEvent Callable callback on click
     * @return Button button
     */
    public Button createRedButton(String text, Boolean active, Callable clickEvent) {
        // Maak een nieuwe knop aan, zet te tekst er in, geef je juiste grote aan, set het lettertype, en de styling
        Button btn = new Button();
        btn.setText(text);
        btn.setPrefSize(200, 50);
        btn.setFont(this.uniSansHeavy);
        btn.setStyle("-fx-text-fill: #" + this.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + this.BUTTON_PRIMARY_BACKGOUND_COLOR);
        
        // Als de button active is, zet de juiste styling
        if (active) {
            btn.setStyle("-fx-text-fill: #" + BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + BUTTON_PRIMARY_BACKGOUND_HOVER_COLOR);
        }
        
        // Als je met je muis over de button heen gaat
        btn.setOnMouseEntered((MouseEvent t) -> {
            btn.setStyle("-fx-text-fill: #" + BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + BUTTON_PRIMARY_BACKGOUND_HOVER_COLOR);
            scene.setCursor(Cursor.HAND);
        });
        
        // Als je muis de button weer verlaat
        btn.setOnMouseExited((MouseEvent t) -> {
            if (!active) {
                btn.setStyle("-fx-text-fill: #" + BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + BUTTON_PRIMARY_BACKGOUND_COLOR);
            }
            scene.setCursor(Cursor.DEFAULT);
        });
        
        // Als je er op klikt
        btn.setOnMouseClicked((MouseEvent t) -> {
            try {
                clickEvent.call(); // Hier voert het programma de methode aan die je als parameter mee gaf.
            } catch (Exception ex) {
                Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return btn; // Geef je volledige button terug
    }
    
    /**
     * Creates a secondary button
     * @param text Content of the button
     * @param active Active state of the button
     * @param clickEvent Callable callback on click
     * @return Button button
     */
    public Button createSecondaryButton(String text, Boolean active, Callable clickEvent) {
        // Maak een nieuwe knop aan, zet te tekst er in, geef je juiste grote aan, set het lettertype, en de styling
        Button btn = new Button();
        btn.setText(text);
        btn.setPrefSize(200, 32);
        btn.setFont(this.uniSansHeavy);
        btn.setStyle("-fx-text-fill: #" + this.BUTTON_SECONDARY_TEXT_COLOR + "; -fx-background-color: #" + this.BUTTON_SECONDARY_BACKGOUND_HOVER_COLOR);
        
        // Als de button active is, zet de juiste styling
        if (active) {
            btn.setStyle("-fx-text-fill: #" + BUTTON_SECONDARY_TEXT_COLOR + "; -fx-background-color: #" + BUTTON_SECONDARY_BACKGOUND_COLOR);
        }
        
        // Als je met je muis over de button heen gaat
        btn.setOnMouseEntered((MouseEvent t) -> {
            btn.setStyle("-fx-text-fill: #" + BUTTON_SECONDARY_TEXT_COLOR + "; -fx-background-color: #" + BUTTON_SECONDARY_BACKGOUND_COLOR);
            scene.setCursor(Cursor.HAND);
        });
        
        // Als je muis de button weer verlaat
        btn.setOnMouseExited((MouseEvent t) -> {
            if (!active) {
                btn.setStyle("-fx-text-fill: #" + BUTTON_SECONDARY_TEXT_COLOR + "; -fx-background-color: #" + BUTTON_SECONDARY_BACKGOUND_HOVER_COLOR);
            }
            scene.setCursor(Cursor.DEFAULT);
        });
        
        // Als je er op klikt
        btn.setOnMouseClicked((MouseEvent t) -> {
            try {
                clickEvent.call(); // Hier voert het programma de methode aan die je als parameter mee gaf.
            } catch (Exception ex) {
                Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return btn; // Geef je volledige button terug
    }
    
    /**
     * Creates a grey button
     * @param text Content of the button
     * @param active Active state of the button
     * @param clickEvent Callable callback on click
     * @return Button button
     */
    public Button createGreyButton(String text, Boolean active, Callable clickEvent) {
        // Maak een nieuwe knop aan, zet te tekst er in, geef je juiste grote aan, set het lettertype, en de styling
        Button btn = new Button();
        btn.setText(text);
        btn.setPrefSize(200, 32);
        btn.setFont(this.uniSansHeavy);
        btn.setStyle("-fx-text-fill: #" + this.GREY_BUTTON_BACKGOUND_TEXT_COLOR + "; -fx-background-color: #" + this.GREY_BUTTON_BACKGOUND_COLOR);
        
        // Als de button active is, zet de juiste styling
        if (active) {
            btn.setStyle("-fx-text-fill: #" + GREY_BUTTON_BACKGOUND_TEXT_COLOR + "; -fx-background-color: #" + GREY_BUTTON_BACKGOUND_COLOR);
        }
        
        // Als je met je muis over de button heen gaat
        btn.setOnMouseEntered((MouseEvent t) -> {
            btn.setStyle("-fx-text-fill: #" + GREY_BUTTON_BACKGOUND_TEXT_COLOR + "; -fx-background-color: #" + GREY_BUTTON_BACKGOUND_COLOR);
            scene.setCursor(Cursor.HAND);
        });
        
        // Als je muis de button weer verlaat
        btn.setOnMouseExited((MouseEvent t) -> {
            if (!active) {
                btn.setStyle("-fx-text-fill: #" + GREY_BUTTON_BACKGOUND_TEXT_COLOR + "; -fx-background-color: #" + GREY_BUTTON_BACKGOUND_COLOR);
            }
            scene.setCursor(Cursor.DEFAULT);
        });
        
        // Als je er op klikt
        btn.setOnMouseClicked((MouseEvent t) -> {
            try {
                clickEvent.call(); // Hier voert het programma de methode aan die je als parameter mee gaf.
            } catch (Exception ex) {
                Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return btn; // Geef je volledige button terug
    }
    
    /**
     * Sets the button to <b>active</b> state
     * @param button the button to be active
     */
    public void primaryButtonActive(Button button) {
        button.setStyle("-fx-text-fill: #" + this.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + this.BUTTON_PRIMARY_BACKGOUND_HOVER_COLOR);
    }

    /**
     * Sets the button to <b>inactive</b> state
     * @param button the button to be active
     */
    public void primaryButtonInactive(Button button) {
        button.setStyle("-fx-text-fill: #" + this.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + this.BUTTON_PRIMARY_BACKGOUND_COLOR);
    }
    
    /**
     * Created a header text
     * @param text String
     * @return Label the header
     */
    public Label createHeading(String text){
       Label label = new Label(text);
       label.setFont(uniSansSemiBoldItalic);
       label.setStyle("-fx-line-height: 37.5px; -fx-font-style: italic bold; -fx-font-size: 25px; -fx-text-fill: #"+ this.COLOR_RED);
       label.setPadding(new Insets(5, 0, 5, 0));
       return label;
    }
    
    /**
     * Create normal text
     * @param text String
     * @return Label the text
     */
    public Label createText(String text){
        return createText(text, COLOR_GREY);
    }
    
    /**
     * 
     * @param text
     * @param color
     * @return 
     */
    public Label createText(String text, String color){
       Label label = new Label(text);
       label.setFont(uniSansSemiBoldItalic);
       label.setStyle("-fx-font-size: 13px; -fx-text-fill: #"+ color);
       label.setPadding(new Insets(0, 0, 5, 0));
       return label;
    }
    
    // Functie om Nodes (elementen) in de top te zetten
    public void setTop(Node value) {
        this.root.setTop(value);
    }
    // Functie om Nodes (elementen) in de center te zetten
    public void setCenter(Node value) {
        this.root.setCenter(value);
    }
    // etc
    public void setBottom(Node value) {
        this.root.setBottom(value);
    }
    
    public void setLeft(Node value) {
        this.root.setLeft(value);
    }
    
    public void setRight(Node value) {
        this.root.setRight(value);
    }
    
    public void reset(){
        setTop(null);
        setCenter(null);
        setBottom(null);
        setLeft(null);
        setRight(null);
    }
    
    // Laat dan uiteindelijk de applicatie zien
    public void show() {
        scene = new Scene(root);
        this.primaryStage.getIcons().add(new Image("file:logo.png"));
        this.primaryStage.setMaximized(true);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
    
    // Laad lettertype in
    private void registerFonts() {
        try {
            this.uniSansHeavy = Font.loadFont(new FileInputStream(new File("uni_sans_heavy.ttf")), 14);
            this.uniSansSemiBoldItalic = Font.loadFont(new FileInputStream(new File("unisans-semibolditalic.ttf")), 14);
            this.openSans = Font.loadFont(new FileInputStream(new File("OpenSans-Regular.ttf")), 14);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
