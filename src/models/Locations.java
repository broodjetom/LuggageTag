package models;

/**
 * @author: Tom Scholten
 */
public class Locations {

    private int id = 0;
    private String location;
    private String address;
    private String zip;
    private String land;

    /**
     * Get the address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address
     * @param address String address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get zip code
     * @return zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Set zio cide
     * @param zip String zip code
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Get country
     * @return String country name
     */
    public String getLand() {
        return land;
    }

    /**
     * Set the country
     * @param land String land name
     */
    public void setLand(String land) {
        this.land = land;
    }

    /**
     * Get the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the location name
     * @return the location
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * toString function return the location
     * Used within javaFX classes
     * @return the location
     */
    public String toString() {
        return location;
    }

    /**
     * Set the location name
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

}
