package models;
/**
 * Author: Tom Scholten
 * Class:
 * Made on:
 */
public class Materials {
    private int id = 0;
    private String material;

    /**
     *
     */
    public Materials() {
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
    public String getMaterial() {
        return material;
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        return material;
    }

    /**
     *
     * @param material
     */
    public void setMaterial(String material) {
        this.material = material;
    }
    
    
}
