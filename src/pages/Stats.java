/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import UI.LuggageChart;
import UI.LuggageForm;
import UI.LuggageUI;
import database.DatabaseManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author ...
 */
public class Stats {

    private static final user.Session USER = user.Session.getInstance();
    private final LuggageUI UI;
    private final DatabaseManager DB;

    public GridPane view = new GridPane();

    public Stats(LuggageUI UI, DatabaseManager db) throws SQLException {
        this.UI = UI;
        this.DB = db;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        String today = dateFormat.format(date);
        String monthAgo = dateFormat.format(c.getTime());

        LuggageForm left = new LuggageForm(UI);
        view.setPadding(new Insets(50, 50, 50, 50));

        Label heading = UI.createHeading("Time");
        Label subtext = UI.createText("Format: yyyy-mm-dd");
        left.add(heading);
        left.addRow();
        left.add(subtext);
        left.addRow();

        left.addLabel("From");
        left.addTextField("from", true, monthAgo);
        left.addRow();
        left.addLabel("To");
        left.addTextField("to", true, today);

        left.addRow();
        left.addCol();
        left.addSubmitButton("Show");


        view.add(left.toNode(), 1, 2);

        UI.setTitle("Statistics");

        LuggageChart chart = new LuggageChart();

        chart.setLabelX("Amount");
        chart.setLabelX("Date");

        Map<String, Double> lost = db.getLostStatistics(monthAgo, today);
        Map<String, Double> found = db.getFoundStatistics(monthAgo, today);
        Map<String, Double> finished = db.getFinishedStatistics(monthAgo, today);

        //chart.setXCoords(new String[]{"2015-11-27"});
        chart.addSerie("Lost", lost);
        chart.addSerie("Found", found);
        chart.addSerie("Resolved", finished);
        
        left.onSubmit((Callable) () -> {
            String from = left.get("from");
            String to = left.get("to");
            
            LuggageChart chartChange = new LuggageChart();

            chartChange.setLabelX("Amount");
            chartChange.setLabelX("Date");

            Map<String, Double> lostChange = db.getLostStatistics(from, to);
            Map<String, Double> foundChange = db.getFoundStatistics(from, to);
            Map<String, Double> finishedChange = db.getFinishedStatistics(from, to);
            
            chartChange.addSerie("Lost", lostChange);
            chartChange.addSerie("Found", foundChange);
            chartChange.addSerie("Resolved", finishedChange);
            
            UI.setCenter(chartChange.getChart());
            return true;
        });

        UI.setLeft(view);
        UI.setCenter(chart.getChart());
    }

}
