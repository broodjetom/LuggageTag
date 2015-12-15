package models;
/**
 * author: Tom Scholten
 */
public class Colors {
    private int id = 0;
    private String color;

    /**
     * Get the id of the color
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the color
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the color name
     * @return color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Returns the color, used in JavaFX classes
     * @return
     */
    public String toString() {
        return color;
    }

    /**
     * Set the color name
     * @param color String color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    
}
