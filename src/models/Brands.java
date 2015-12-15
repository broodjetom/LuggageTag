package models;
/**
 * Author: Tom Scholten
 * Class:
 * Made on:
 */
public class Brands {
    private int id = 0;
    private String brand;

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
    public String getBrand() {
        return brand;
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        return brand;
    }

    /**
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
}
