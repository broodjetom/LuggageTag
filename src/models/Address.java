package models;
/**
 * @Author Tom Scholten
 * @Class
 * @Date 
 */
public class Address {
    private int id = 0;
    private int passengerluggage_id;
    private String address;
    private String zip;
    private String land;

    /**
     *
     */
    public Address() {
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
     * @return the passengerluggage_id
     */
    public int getPassengerluggage_id() {
        return passengerluggage_id;
    }

    /**
     * @param passengerluggage_id the passengerluggage_id to set
     */
    public void setPassengerluggage_id(int passengerluggage_id) {
        this.passengerluggage_id = passengerluggage_id;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the land
     */
    public String getLand() {
        return land;
    }

    /**
     * @param land the land to set
     */
    public void setLand(String land) {
        this.land = land;
    }
}
