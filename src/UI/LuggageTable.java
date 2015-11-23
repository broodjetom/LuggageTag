/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Thomas
 */
public class LuggageTable {

    private TableView table;
    public Map<String, TableColumn> tableColumns = new HashMap<>();

    public LuggageTable(Boolean editable) {
        this.table = new TableView();

        if (editable) {
            table.setEditable(true);
        }
    }

    public LuggageTable() {
        this.table = new TableView<>();
    }

    public void setTopRow(String[] columnsName, String[] modelVars) {
        int i = 0;
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

    public void setContent(ObservableList columns) {
        this.table.setItems(columns);
    }

    public TableView getTable() {
        return this.table;
    }

}
