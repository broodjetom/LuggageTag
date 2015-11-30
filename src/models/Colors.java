package models;
/**
 * Author: Tom Scholten
 * Class:
 * Made on:
 */
public class Colors {
    private int id = 0;
    private String color;

    /**
     *
     */
    public Colors() {
        
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    
}
