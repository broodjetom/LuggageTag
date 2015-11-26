package models;

/**
 * @Author: Tom Scholten
 * @Class:
 * @Date
 */
public class Locations {

    private int id = 0;
    private String location;

    /**
     *
     */
    public Locations() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

}
