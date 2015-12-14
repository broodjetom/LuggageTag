/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Tom Scholten
 */
public class F1Screen {

    private LuggageUI UI;
    private DatabaseManager db;
    public GridPane view = new GridPane();
    private final int MAX_LINE_COUNT = 150;

    private static final user.Session USER = user.Session.getInstance();

    public F1Screen(LuggageUI UI, DatabaseManager db) throws FileNotFoundException, IOException {

        this.UI = UI;
        this.db = db;

        view.setPadding(new Insets(50, 50, 50, 50));

        UI.setTitle("Help");

        LuggageForm form = new LuggageForm(UI);

        Label heading = UI.createHeading("Help");
        form.add(heading);
        form.addRow();

        String role = "employee";

        if (USER.getUser().getManager() != 0) {
            role = "manager";
        }

        if (USER.getUser().getAdmin() != 0) {
            role = "admin";
        }

        BufferedReader br = new BufferedReader(new FileReader(role + "Instructions.txt"));

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

//        while ((line = br.readLine()) != null) {
//            boolean repeat = true;
//            while (repeat) {
//                int count = 0;
//                if (line.length() > MAX_LINE_COUNT * (count + 1)) {
//                    String tempLine = line.substring(count * MAX_LINE_COUNT, MAX_LINE_COUNT * (count + 1));
//                    repeat = (tempLine.length() == MAX_LINE_COUNT);
//                    count++;
//                    form.addLabel(tempLine);
//                    form.addRow();
//                } else {
//                    form.addLabel(line);
//                    form.addRow();
//                    repeat = false;
//                }
//            }
//        }

        view.add(form.toNode(), 1, 2);

        UI.setCenter(view);
        UI.setLeft(null);
    }
}
