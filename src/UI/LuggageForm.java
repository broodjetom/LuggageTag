package UI;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * Create a Form
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
    public Map<String, Boolean> comboBoxRequired = new HashMap<>();

    private Map<String, String> keyValues = new HashMap<>();
    private Map<String, Object> keyElement = new HashMap<>();

    private final String BORDER_COLOR = "D9D9D9";

    /**
     * Constructor initializes the form itself
     *
     * @param UI The LuggageUI
     */
    public LuggageForm(LuggageUI UI) {
        this.UI = UI;
        grid.setPadding(new Insets(5));
        grid.setHgap(10);
        grid.setVgap(10);
        errorText = UI.createText("", UI.COLOR_RED);
    }

    /**
     * Creates a new row to start building at
     */
    public void addRow() {
        row++;
        col = 0;
    }

    /**
     * Add a column (creates new element at the next column)
     */
    public void addCol() {
        col++;
    }

    /**
     * Add node to the grid
     *
     * @param node
     */
    public void add(Node node) {
        grid.add(node, col, row);
        addCol();
    }

    /**
     * Get the value of an input field
     *
     * @param id
     * @return String the value of an element
     */
    public String get(String id) {
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

    public Object getComboBoxSelected(String id) {
        return this.comboBox.get(id).getSelectionModel().getSelectedItem();
    }

    /**
     * Adds a label
     *
     * @param text
     */
    public void addLabel(String text) {
        Label label = UI.createText(text);
        label.setStyle("-fx-font-weight: bold;");
        add(label);
    }

    /**
     * Adds a text field to the form
     *
     * @param id ID to set for this field
     * @param required Make element required, or not
     */
    public void addTextField(String id, Boolean required) {
        addTextField(id, required, "");
    }

    /**
     * Adds a text field to the form
     *
     * @param id ID to set for this field
     * @param required Make element required, or not
     * @param value Default value of the field
     */
    public void addTextField(String id, Boolean required, String value) {
        TextField textField = new TextField();
        textField.setText(value);
        textField.setStyle("-fx-border-radius: 6px; -fx-background-color: white; -fx-border-color: #" + BORDER_COLOR);
        textFields.put(id, textField);
        textFieldsRequired.put(id, required);
        add(textField);
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    fireSubmitEvent();
                }
            }
        });
    }

    /**
     * Adds a password field to the form
     *
     * @param id ID to set for this field
     * @param required Make element required, or not
     */
    public void addPassField(String id, Boolean required) {
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-border-radius: 6px; -fx-background-color: white; -fx-border-color: #" + BORDER_COLOR);
        textFields.put(id, passwordField);
        textFieldsRequired.put(id, required);
        add(passwordField);
        passwordField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    fireSubmitEvent();
                }
            }
        });
    }

    /**
     * Adds a text area to the form
     *
     * @param id ID to set for this field
     * @param required Make element required, or not
     */
    public void addTextArea(String id, Boolean required) {
        TextArea textArea = new TextArea();
        textArea.setStyle("-fx-border-radius: 6px; -fx-background-color: white; -fx-border-color: #" + BORDER_COLOR);
        System.out.println(textArea.getPrefColumnCount());
        textAreas.put(id, textArea);
        textAreasRequired.put(id, required);
        add(textArea);
    }
    
    /**
     * Adds a text area to the form
     *
     * @param id ID to set for this field
     * @param required Make element required, or not
     * @param text Default text
     * @param prefColumnCount Width of text area in columns
     */
    public void addTextArea(String id, Boolean required, String text) {
        TextArea textArea = new TextArea(text);
        textArea.setStyle("-fx-border-radius: 6px; -fx-background-color: white; -fx-border-color: #" + BORDER_COLOR);
        textAreas.put(id, textArea);
        textAreasRequired.put(id, required);
        add(textArea);
    }
    
    /**
     * Adds a text area to the form
     *
     * @param id ID to set for this field
     * @param required Make element required, or not
     * @param text Default text
     * @param prefColumnCount Width of text area in columns
     */
    public void addTextArea(String id, Boolean required, String text, int prefColumnCount) {
        TextArea textArea = new TextArea(text);
        textArea.setStyle("-fx-border-radius: 6px; -fx-background-color: white; -fx-border-color: #" + BORDER_COLOR);
        textArea.setPrefColumnCount(prefColumnCount);
        textAreas.put(id, textArea);
        textAreasRequired.put(id, required);
        add(textArea);
    }
    
    public void addComboBox(String id, String[] elements) {
        addComboBox(id, elements, false);
    }
    
    /**
     * Adds a combobox to the form
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     */
    public void addComboBox(String id, String[] elements, Boolean required) {
        ComboBox theBox = new ComboBox();
        theBox.setPromptText("- Select -");
        theBox.setEditable(true);
        for (String el : elements) {
            theBox.getItems().add(el);
        }
        comboBoxRequired.put(id, required);
        comboBox.put(id, theBox);
        add(theBox);
    }
    
    /**
     * Adds a combobox to the form
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     */
    public void addComboBox(String id, String[] elements, Boolean required, Object selected) {
        ComboBox theBox = new ComboBox();
        theBox.setPromptText("- Select -");
        theBox.setEditable(true);
        for (String el : elements) {
            theBox.getItems().add(el);
        }
        theBox.setValue(selected);
        comboBoxRequired.put(id, required);
        comboBox.put(id, theBox);
        add(theBox);
    }
    
    /**
     * Adds a combobox to the form
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     * @param selected The default selected object
     */
    public void addComboBox(String id, ObservableList elements, Object selected) {
        addComboBox(id, elements, false, selected);
    }
    
    /**
     * Adds a combobox to the form
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     */
    public void addComboBox(String id, ObservableList elements) {
        addComboBox(id, elements, false, null);
    }

    /**
     * Adds a combobox to the form
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     * @param required Field is required
     */
    public void addComboBox(String id, ObservableList elements, Boolean required, Object selected) {
        ComboBox theBox = new ComboBox(elements);
        theBox.setPromptText("- Select -");
        theBox.setEditable(true);
        
        theBox.setValue(selected);
        
        comboBoxRequired.put(id, required);
        comboBox.put(id, theBox);
        add(theBox);
    }

    /**
     * Adds horizontally aligned radio buttons
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     */
    public void addHRadioButtons(String id, String[] elements) {
        addHRadioButtons(id, elements, elements[0]);
    }

    /**
     * Adds horizontally aligned radio buttons with one default selected
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     * @param selected The default selected element (must be the same string as
     * in elements)
     */
    public void addHRadioButtons(String id, String[] elements, String selected) {
        ToggleGroup group = new ToggleGroup();

        for (String element : elements) {
            RadioButton rb = new RadioButton(element);

            if (element.equals(selected)) {
                rb.setSelected(true);
            }

            rb.setToggleGroup(group);
            add(rb);
        }

        radioFields.put(id, group);
    }

    /**
     * Adds vertically aligned radio button
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     */
    public void addVRadioButtons(String id, String[] elements) {
        addVRadioButtons(id, elements, elements[0]);
    }

    /**
     * Adds vertically aligned radio buttons with one default selected
     *
     * @param id ID to set for this field
     * @param elements The elements to add to the group of the combobox
     * @param selected The default selected element (must be the same string as
     * in elements)
     */
    public void addVRadioButtons(String id, String[] elements, String selected) {
        ToggleGroup group = new ToggleGroup();

        for (String element : elements) {
            RadioButton rb = new RadioButton(element);

            if (element.equals(selected)) {
                rb.setSelected(true);
            }

            rb.setToggleGroup(group);
            add(rb);
            addRow();
        }

        radioFields.put(id, group);

    }

    /**
     * Adds a submit button to the form
     *
     * @param text the value of the button
     */
    public void addSubmitButton(String text) {
        Button login = UI.createSecondaryButton(text, false, (Callable) () -> {
            fireSubmitEvent();
            return true;
        });

        grid.add(login, col, row);
        addCol();
    }

    /**
     * Adds an error message to the form, usually used in the onSubmit event
     *
     * @param error error message to be shown
     */
    public void error(String error) {
        addRow();
        errorText.setText(error);
        if (!errorSet) {
            grid.add(errorText, 0, 0);
            addRow();
            errorSet = true;
        }
    }

    /**
     * Returns the node element to be added to the UI
     *
     * @return Node grid
     */
    public Node toNode() {
        return grid;
    }

    /**
     * Event listener when the submit button is clicked
     *
     * @param event Callable event
     */
    public void onSubmit(Callable event) {
        onSubmit = event;
    }

    /**
     * Handles all the input field, if they are required, and gets the values of
     * it
     */
    private void fireSubmitEvent() {
        try {
            keyValues.clear();
            for (Map.Entry<String, TextField> entry : textFields.entrySet()) {
                String value = entry.getValue().getText();
                keyValues.put(entry.getKey(), value);

                if (textFieldsRequired.get(entry.getKey()) && value.equals("")) {
                    entry.getValue().setStyle("-fx-border-color: red; -fx-border-radius: 6px;");
                } else {
                    entry.getValue().setStyle("-fx-border-color: #" + BORDER_COLOR + "; -fx-border-radius: 6px;");
                }
            }

            for (Map.Entry<String, ComboBox> entry : comboBox.entrySet()) {

                if (comboBoxRequired.get(entry.getKey()) && entry.getValue().getSelectionModel().getSelectedIndex() == -1) {
                    entry.getValue().setStyle("-fx-border-color: red; -fx-border-radius: 6px;");
                } else {
                    entry.getValue().setStyle("-fx-border-color: #" + BORDER_COLOR + "; -fx-border-radius: 6px;");
                }
            }

            for (Map.Entry<String, TextArea> entry : textAreas.entrySet()) {
                String value = entry.getValue().getText();
                keyValues.put(entry.getKey(), value);

                if (textAreasRequired.get(entry.getKey()) && value.equals("")) {
                    entry.getValue().setStyle("-fx-border-color: red; -fx-border-radius: 6px;");
                } else {
                    entry.getValue().setStyle("-fx-border-color: #" + BORDER_COLOR + "; -fx-border-radius: 6px;");
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
