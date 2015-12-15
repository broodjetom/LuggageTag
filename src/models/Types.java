package models;
/**
 * author: Tom Scholten
 */
public class Types {
    private int id = 0;
    private String type;

    /**
     * Get the id of the type
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the type
     * @param id int id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the type name
     * @return String type name
     */
    public String getType() {
        return type;
    }
    
    /**
     * Returns the type user for JavaFX classes that call this method
     * @return String type name
     */
    public String toString() {
        return type;
    }

    /**
     * Set the type name
     * @param type String type name
     */
    public void setType(String type) {
        this.type = type;
    }
    
    
}
