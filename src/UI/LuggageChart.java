package UI;

import java.util.Map;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * Creates a line chart representing the luggage that is lost, taken care of and
 * found.
 *
 * @author Kah Kit Version 1.0
 */
public class LuggageChart {

    //Defining the axes
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();        
    final LineChart<String,Number> lineChart = new LineChart<>(xAxis,yAxis);

    String[] setXCoord;
    
    //Creating the default constructor
    public LuggageChart() {

    }

    public void setLabelX( String label ){
        xAxis.setLabel(label);
    }
    
    public void setLabelY( String label ){
        yAxis.setLabel(label);
    }
    
    public void setXCoords( String[] values ){
        setXCoord = values;
    }
    
    public void addSerie( String name, Map<String, Double> map ){
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(name);
        
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            series1.getData().add(new XYChart.Data(key, value)); 
        }
        lineChart.getData().add(series1);
    }
    
    public LineChart<String, Number> getChart(){
        return lineChart;
    }
}
