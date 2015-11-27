package UI;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

class LuggageChart{
    
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> bc = 
            new BarChart<>(xAxis,yAxis);
    
    String[] setXCoord;
    
    public LuggageChart(){
        
    }
    
    public void setLabelX( String label ){
        xAxis.setLabel("Year");
    }
    
    public void setLabelY( String label ){
        yAxis.setLabel("Lost luggage");
    }
    
    public void setXCoords( String[] values ){
        setXCoord = values;
    }
    
    public void addSerie( String name ){
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(name);
    }
    
    public BarChart<String, Number> getChart(){
        return bc;
    }
}