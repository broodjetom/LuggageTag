/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.LuggageUI;
import database.DatabaseManager;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Alex
 */
public class Charts {
    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();

    private static final user.Session USER = user.Session.getInstance();

    public Charts(LuggageUI UI, DatabaseManager db) {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));
    }
}
