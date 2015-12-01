package models;
/**
 * Author: Tom Scholten
 * Class:
 * Made on:
 */
public class Types {
    private int id = 0;
    private String type;

    /**
     *
     */
    public Types() {
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
    public String getType() {
        return type;
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    
}
