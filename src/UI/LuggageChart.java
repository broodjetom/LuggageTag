package UI;

import java.util.Map;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * Create a Chart
 * @author Kah Kit &amp; Alex
 */
public class LuggageChart{
    
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> bc = 
            new BarChart<>(xAxis,yAxis);
    
    
    /**
     * Set the label for the X axis
     * @param label
     */
    public void setLabelX( String label ){
        xAxis.setLabel(label);
    }
    
    /**
     * Set the label for the Y axis
     * @param label
     */
    public void setLabelY( String label ){
        yAxis.setLabel(label);
    }
    
    /**
     * Add a serie to the chart
     * @param name Human readable name of the chart
     * @param map Data for the chart
     */
    public void addSerie( String name, Map<String, Double> map ){
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(name);
        
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            series1.getData().add(new XYChart.Data(key, value)); 
        }
        bc.getData().add(series1);
    }
    
    /**
     * Return JavaFX BarChart Node
     * @return
     */
    public BarChart<String, Number> getChart(){
        return bc;
    }
}