package models;

import java.util.Date;

/**
 * @author Tom Scholten
 */
public class Luggage {

    private Date date = new Date();
    private int id = 0;
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
    private String date_added;
    private String date_changed;
    private String date_finished;
    private String situation;
    private Brands brand;
    private Colors color;
    private Types type;
    private Materials material;
    private Locations location;
    private int passenger_id;

    /**
     * Constructor sets dates to correct format
     */
    public Luggage(){
        this.date_added = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
        this.date_finished = "1970-01-01";
    }
    
    /**
     * Get the passenger id
     * @return passenger_id
     */
    public int getPassenger_id(){
        return passenger_id;
    }
    
    /**
     * Set the passenger id
     * @param passenger_id int passenger_id foreign key
     */
    public void setPassenger_id(int passenger_id){
        this.passenger_id = passenger_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the brand_id
     * @return the brand_id
     */
    public int getBrand_id() {
        return brand_id;
    }

    /**
     * Set the brand_id
     * @param brand_id the brand_id to set
     */
    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the color_id
     * @return the color_id
     */
    public int getColor_id() {
        return color_id;
    }

    /**
     * Set the color_id
     * @param color_id the color_id to set
     */
    public void setColor_id(int color_id) {
        this.color_id = color_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the weight
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set the weight
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the material_id
     * @return the material_id
     */
    public int getMaterial_id() {
        return material_id;
    }

    /**
     * Set the material_id
     * @param material_id the material_id to set
     */
    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the stickers
     * @return int the stickers
     */
    public int getStickers() {
        return stickers;
    }

    /**
     * Set the stickers
     * @param stickers the stickers to set
     */
    public void setStickers(int stickers) {
        this.stickers = stickers;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the characteristic
     * @return the characteristic
     */
    public String getCharacteristic() {
        return characteristic;
    }

    /**
     * Set the characteristic
     * @param characteristic the characteristic to set
     */
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the belt
     * @return the belt
     */
    public int getBelt() {
        return belt;
    }

    /**
     * Set the belt
     * @param belt the belt to set
     */
    public void setBelt(int belt) {
        this.belt = belt;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the type_id
     * @return the type_id
     */
    public int getType_id() {
        return type_id;
    }

    /**
     * Set the type_id
     * @param type_id the type_id to set
     */
    public void setType_id(int type_id) {
        this.type_id = type_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the location_id
     * @return the location_id
     */
    public int getLocation_id() {
        return location_id;
    }

    /**
     * Set the location_id
     * @param location_id the location_id to set
     */
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the comment
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the users_id the user who added/edited the luggage
     * @return the users_id
     */
    public int getUsers_id() {
        return users_id;
    }

    /**
     * Set the users_id the user who added/edited the luggage
     * @param users_id the users_id to set
     */
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the date the luggage was added
     * @return the date_added
     */
    public String getDate_added() {
        return date_added;
    }

    /**
     * Set the date the luggage is added
     * @param date_added the date_added to set
     */
    public void setDate_added(String date_added) {
        this.date_added = date_added;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the date when luggage was last changed
     * @return the date_changed
     */
    public String getDate_changed() {
        return date_changed;
    }

    /**
     * Set the date when luggage is changed
     * @param date_changed the date_changed to set
     */
    public void setDate_changed(String date_changed) {
        this.date_changed = date_changed;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the date the luggage was finished
     * @return the date_finished or null
     */
    public String getDate_finished() {
        return date_finished;
    }

    /**
     * Set the date the luggage is finished
     * @param date_finished the date_finished to set
     */
    public void setDate_finished(String date_finished) {
        this.date_finished = date_finished;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the current situation of the luggage
     * - Gevonden
     * - Verloren
     * - Afgehandeld
     * @return the situation
     */
    public String getSituation() {
        return situation;
    }

    /**
     * Set the situation of the luggage
     * - Gevonden
     * - Verloren
     * - Afgehandeld
     * @param situation the situation to set
     */
    public void setSituation(String situation) {
        this.situation = situation;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the brand
     * @return models.Brands
     */
    public Brands getBrand() {
        return brand;
    }

    /**
     * Set the brand
     * @param brand models.Brands
     */
    public void setBrand(Brands brand) {
        this.brand = brand;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the color
     * @return models.Colors
     */
    public Colors getColor() {
        return color;
    }

    /**
     * Set the color
     * @param color models.Colors
     */
    public void setColor(Colors color) {
        this.color = color;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the type
     * @return models.Types
     */
    public Types getType() {
        return type;
    }

    /**
     * Set the type
     * @param type models.Types
     */
    public void setType(Types type) {
        this.type = type;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the material
     * @return models.Materials
     */
    public Materials getMaterial() {
        return material;
    }

    /**
     * Set the materail
     * @param material models.Materials
     */
    public void setMaterial(Materials material) {
        this.material = material;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * Get the location
     * @return models.Locations
     */
    public Locations getLocation() {
        return location;
    }

    /**
     * Set the location
     * @param location models.Locations
     */
    public void setLocation(Locations location) {
        this.location = location;
    }
    
    
    
}
    
    
