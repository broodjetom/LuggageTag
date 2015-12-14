package UI;

import java.util.Map;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * Create a Chart
 * @author Kah Kit & Alex
 */
public class LuggageChart{
    
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> bc = 
            new BarChart<>(xAxis,yAxis);
    
    String[] setXCoord;
    
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
        bc.getData().add(series1);
    }
    
    public BarChart<String, Number> getChart(){
        return bc;
    }
}