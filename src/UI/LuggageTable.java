package UI;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * Create a table
 * @author Alex
 */
public class LuggageTable {

    private TableView table;

    /**
     * HashMap containing all the columns
     */
    public Map<String, TableColumn> tableColumns = new HashMap<>();
    private Object clicked;
    
    /**
     * Initialize <b>editable</b> table
     * @param editable 
     */
    public LuggageTable(Boolean editable) {
        // Maak een table aan
        this.table = new TableView();

        if (editable) {
            table.setEditable(true);
        }
    }

    /**
     * Initialize <b>uneditable</b> form
     */
    public LuggageTable() {
        this.table = new TableView<>();
    }

    /**
     * The callable callback function is called when the user doubleclicks a
     * filled row in the table
     *
     * Use the getClicked method to retrieve the clicked object
     *
     * @param clickEvent Callable clickevent
     */
    public void onClick(Callable clickEvent) {
        table.setRowFactory(tv -> {
            TableRow<Object> row = new TableRow<>();
            row.setOnMouseClicked((MouseEvent t) -> { // Event Listener
                try {
                    this.clicked = row.getItem();
                    if (t.getClickCount() == 2 && (!row.isEmpty())) { // Ga niet door als iemand op een lege rij klikt
                        clickEvent.call(); // Hier voert het programma de methode aan die je als parameter mee gaf.
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            return row; // Stuur de gelkikte rij terug, is een beetje nutteloos
        });
    }

    /**
     * Get last clicked object Returns empty Object when nothing is clicked
     *
     * @return clicked Object
     */
    public Object getClicked() {
        return this.clicked; // Stuur de geklikte rij terug
    }

    /**
     * Set the keys for the columns
     *
     * @param columnsName String array, =the titles in human readable
     * strings this will be shown on the top of the table
     * @param modelVars String array, the identifiers (the getters in your model)
     */
    public void setTopRow(String[] columnsName, String[] modelVars) {
        int i = 0;
        // Loop door alle elementen heen
        for (String col : columnsName) {
            TableColumn idCol = new TableColumn(col);
            idCol.setMinWidth(0);
            idCol.setCellValueFactory(
                    new PropertyValueFactory<>(modelVars[i])
            );
            tableColumns.put(col, idCol);
            table.getColumns().add(idCol);
            i++;
        }
    }

    /**
     * Set elements in the table
     *
     * @param columns ObservabelList
     */
    public void setContent(ObservableList columns) {
        this.table.setItems(columns);
    }

    /**
     * Returns the Node of the table to be used in JavaFX
     *
     * @return Node TableView
     */
    public TableView getTable() {
        return this.table;
    }

}
