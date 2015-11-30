package models;

import javafx.collections.ObservableList;

/**
 * Author: Tom Scholten Class: Made on:
 */
public class PassengerLuggage {

    private int id = 0;
    private String fname;
    private String mname;
    private String lname;
    private String flight;
    private int brand_id;
    private int color_id;
    private double weight;
    private int material_id;
    private int stickers;
    private String characteristic;
    private int belt;
    private int type_id;
    private int location_id;
    private String comment;
    private int users_id;
    private String date_added = "2012/12/12 12:12:12";
    private String date_changed = "2012/12/12 12:12:12";
    private String date_finished = "2012/12/12 12:12:12";
    private String situation;
    private Locations location;
    private Colors color;
    private Brands brand;
    private Materials material;
    private Types type;
    private Users user;
    public ObservableList<models.Phone> phone;
    public ObservableList<models.Email> email;
    public ObservableList<models.Address> address;
    

    /**
     *
     */
    public PassengerLuggage() {
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
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the mname
     */
    public String getMname() {
        return mname;
    }

    /**
     * @param mname the mname to set
     */
    public void setMname(String mname) {
        this.mname = mname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the flight
     */
    public String getFlight() {
        return flight;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlight(String flight) {
        this.flight = flight;
    }

    /**
     * @return the brand_id
     */
    public int getBrand_id() {
        return brand_id;
    }

    /**
     * @param brand_id the brand_id to set
     */
    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    /**
     * @return the color_id
     */
    public int getColor_id() {
        return color_id;
    }

    /**
     * @param color_id the color_id to set
     */
    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the material_id
     */
    public int getMaterial_id() {
        return material_id;
    }

    /**
     * @param material_id the material_id to set
     */
    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    /**
     * @return the stickers
     */
    public int getStickers() {
        return stickers;
    }

    /**
     * @param stickers the stickers to set
     */
    public void setStickers(int stickers) {
        this.stickers = stickers;
    }

    /**
     * @return the characteristic
     */
    public String getCharacteristic() {
        return characteristic;
    }

    /**
     * @param characteristic the characteristic to set
     */
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    /**
     * @return the belt
     */
    public int getBelt() {
        return belt;
    }

    /**
     * @param belt the belt to set
     */
    public void setBelt(int belt) {
        this.belt = belt;
    }

    /**
     * @return the type_id
     */
    public int getType_id() {
        return type_id;
    }

    /**
     * @param type_id the type_id to set
     */
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    /**
     * @return the location_id
     */
    public int getLocation_id() {
        return location_id;
    }

    /**
     * @param location_id the location_id to set
     */
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the users_id
     */
    public int getUsers_id() {
        return users_id;
    }

    /**
     * @param users_id
     */
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    /**
     * @return the date_added
     */
    public String getDate_added() {
        return date_added;
    }

    /**
     * @param date_added the date_added to set
     */
    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    /**
     * @return the date_changed
     */
    public String getDate_changed() {
        return date_changed;
    }

    /**
     * @param date_changed the date_changed to set
     */
    public void setDate_changed(String date_changed) {
        this.date_changed = date_changed;
    }

    /**
     * @return the date_finished
     */
    public String getDate_finished() {
        return date_finished;
    }

    /**
     * @param date_finished the date_finished to set
     */
    public void setDate_finished(String date_finished) {
        this.date_finished = date_finished;
    }

    /**
     * @return the location
     */
    public Locations getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Locations location) {
        this.location = location;
    }

    /**
     * @return the phone
     */
    public ObservableList<Phone> getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(ObservableList<Phone> phone) {
        this.phone = phone;
    }

    /**
     * @return the color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Colors color) {
        this.color = color;
    }

    /**
     * @return the brand
     */
    public Brands getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    /**
     * @return the material
     */
    public Materials getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Materials material) {
        this.material = material;
    }

    /**
     * @return the type
     */
    public Types getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Types type) {
        this.type = type;
    }

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return the email
     */
    public ObservableList<Email> getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(ObservableList<Email> email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public ObservableList<Address> getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(ObservableList<Address> address) {
        this.address = address;
    }

    /**
     * @return the situation
     */
    public String getSituation() {
        return situation;
    }

    /**
     * @param situation the situation to set
     */
    public void setSituation(String situation) {
        this.situation = situation;
    }

}
