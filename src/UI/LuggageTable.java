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
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Thomas
 */
public class LuggageTable {

    private TableView table;
    public Map<String, TableColumn> tableColumns = new HashMap<>();
    private Object clicked;

    public LuggageTable(Boolean editable) {
        this.table = new TableView();

        if (editable) {
            table.setEditable(true);
        }
    }

    public LuggageTable() {
        this.table = new TableView<>();
    }
    
    public void onClick(Callable clickEvent){
        table.setRowFactory(tv -> {
            TableRow<Object> row = new TableRow<>();
            row.setOnMouseClicked((MouseEvent t) -> {
                try {
                    this.clicked = row.getItem();
                    if (t.getClickCount() == 2 && (! row.isEmpty()) ) {
                        clickEvent.call(); // Hier voert het programma de methode aan die je als parameter mee gaf.
                    }
                } catch (Exception ex) {
                    Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            return row;
        });
    }
    
    public Object getClicked(){
        return this.clicked;
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
