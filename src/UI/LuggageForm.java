/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alex
 */
public class LuggageForm {

    private LuggageUI UI;
    private GridPane grid = new GridPane();
    private int row = 1;
    private int col = 0;
    private Callable onSubmit;
    
    private boolean errorSet = false;
    Label errorText;
    
    public Map<String, TextField> textFields = new HashMap<>();
    private Map<String, Boolean> textFieldsRequired = new HashMap<>();
    
    public Map<String, TextArea> textAreas = new HashMap<>();
    private Map<String, Boolean> textAreasRequired = new HashMap<>();
    
    public Map<String, ToggleGroup> radioFields = new HashMap<>();
    public Map<String, ComboBox> comboBox = new HashMap<>();
    
    private Map<String, String> keyValues = new HashMap<>();
    private Map<String, Object> keyElement = new HashMap<>();
    
    private final String BORDER_COLOR = "D9D9D9";

    public LuggageForm(LuggageUI UI) {
        this.UI = UI;
        grid.setPadding(new Insets(5));
        grid.setHgap(10);
        grid.setVgap(10);
        errorText = UI.createText("", UI.COLOR_RED);
    }

    public void addRow() {
        row++;
        col = 0;
    }

    public void addCol() {
        col++;
    }
    
    public void add(Node node){
        grid.add(node, col, row);
        addCol();
    }
    
    public String get( String id ){
        keyValues.clear();
        for (Map.Entry<String, TextField> entry : textFields.entrySet()) {
            String value = entry.getValue().getText();
            keyValues.put(entry.getKey(), value);
        }
        for (Map.Entry<String, TextArea> entry : textAreas.entrySet()) {
            String value = entry.getValue().getText();
            keyValues.put(entry.getKey(), value);
        }
        for (Map.Entry<String, ToggleGroup> group : radioFields.entrySet()) {
            RadioButton button = (RadioButton) group.getValue().getSelectedToggle();
            String value = button.getText();
            keyValues.put(group.getKey(), value);
        }
        
        return keyValues.get(id);
    }

    public void addLabel(String text) {
        Label label = UI.createText(text);
        label.setStyle("-fx-font-weight: bold;");
        add(label);
    }

    public void addTextField(String id, Boolean required) {
        TextField textField = new TextField();
        textField.setStyle("-fx-border-radius: 6px; -fx-background-color: white; -fx-border-color: #"+ BORDER_COLOR);
        textFields.put(id, textField);
        textFieldsRequired.put(id, required);
        add(textField);
    }
    
    public void addPassField(String id, Boolean required) {
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-border-radius: 6px; -fx-background-color: white; -fx-border-color: #"+ BORDER_COLOR);
        textFields.put(id, passwordField);
        textFieldsRequired.put(id, required);
        add(passwordField);
    }
    
    public void addTextArea(String id, Boolean required){
        TextArea textArea = new TextArea();
        textArea.setStyle("-fx-border-radius: 6px; -fx-background-color: white; -fx-border-color: #"+ BORDER_COLOR);
        textAreas.put(id, textArea);
        textAreasRequired.put(id, required);
        add(textArea);
    }
    
    public void addComboBox(String id, String[] elements){
        ComboBox theBox = new ComboBox();
        theBox.setPromptText("- Select -");
        theBox.setEditable(true);       
        for (String el: elements) {
            theBox.getItems().add(el);
        }
        comboBox.put(id, theBox);
        add(theBox);
    }
    
    public void addHRadioButtons(String id, String[] elements){
        addHRadioButtons(id, elements, elements[0]);
    }
    
    public void addHRadioButtons(String id, String[] elements, String selected){
        ToggleGroup group = new ToggleGroup();
        
        for(String element: elements){
            RadioButton rb = new RadioButton(element);
            
            if( element.equals(selected) )
                   rb.setSelected(true);
            
            rb.setToggleGroup(group);
            add(rb);
        }
        
        radioFields.put(id, group);
    }
    
    public void addVRadioButtons(String id, String[] elements){
        addVRadioButtons(id, elements, elements[0]);
    }
    
    public void addVRadioButtons(String id, String[] elements, String selected){
        ToggleGroup group = new ToggleGroup();
        
        for(String element: elements){
            RadioButton rb = new RadioButton(element);
            
            if( element.equals(selected) )
                   rb.setSelected(true);
            
            rb.setToggleGroup(group);
            add(rb);
            addRow();
        }
        radioFields.put(id, group);
        
    }
    
    public void addSubmitButton(String text){
        Button login = UI.createSecondaryButton(text, false, (Callable) () -> {
            fireSubmitEvent();
            return true;
        });
        
        grid.add(login, col, row);
        addCol();
    }
    
    public void error( String error ){
        addRow();
        errorText.setText(error);
        if( !errorSet ){
            grid.add(errorText, 0, 0);
            addRow();
            errorSet = true;
        }
    }

    public Node toNode() {
        return grid;
    }
    
    public void onSubmit(Callable event){
        onSubmit = event;
    }
    
    private void fireSubmitEvent(){
        try {
            keyValues.clear();
            for (Map.Entry<String, TextField> entry : textFields.entrySet()) {
                String value = entry.getValue().getText();
                keyValues.put(entry.getKey(), value);
                
                if( textFieldsRequired.get(entry.getKey()) && value.equals("")){
                    entry.getValue().setStyle("-fx-border-color: red; -fx-border-radius: 6px;");
                } else {
                    entry.getValue().setStyle("-fx-border-color: #"+ BORDER_COLOR +"; -fx-border-radius: 6px;");
                }
            }
            
            for (Map.Entry<String, TextArea> entry : textAreas.entrySet()) {
                String value = entry.getValue().getText();
                keyValues.put(entry.getKey(), value);
                
                if( textAreasRequired.get(entry.getKey()) && value.equals("")){
                    entry.getValue().setStyle("-fx-border-color: red; -fx-border-radius: 6px;");
                } else {
                    entry.getValue().setStyle("-fx-border-color: #"+ BORDER_COLOR +"; -fx-border-radius: 6px;");
                }
            }
            
            for (Map.Entry<String, ToggleGroup> group : radioFields.entrySet()) {
                RadioButton button = (RadioButton) group.getValue().getSelectedToggle();
                
                String value = button.getText();

                keyValues.put(group.getKey(), value);
            }
            
            onSubmit.call();
        } catch (Exception ex) {
            Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
