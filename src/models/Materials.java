package models;
/**
 * author: Tom Scholten
 */
public class Materials {
    private int id = 0;
    private String material;

    /**
     * Get the id
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id
     * @param id int id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the material
     * @return String material
     */
    public String getMaterial() {
        return material;
    }
    
    /**
     * toString returns the materail
     * Used for JavaFX that looks for this method
     * @return String material name
     */
    public String toString() {
        return material;
    }

    /**
     * Set the material
     * @param material String material name
     */
    public void setMaterial(String material) {
        this.material = material;
    }
    
    
}
