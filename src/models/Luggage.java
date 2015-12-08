package models;

import java.util.Date;

/**
 * @Author Tom Scholten
 * @Class
 * @Date 
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

    public Luggage(){
        this.date_added = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
        this.date_finished = "1970-01-01";
    }
    
    public int getPassenger_id(){
        return passenger_id;
    }
    
    public void setPassenger_id(int passenger_id){
        this.passenger_id = passenger_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
    }

    /**
     * @return the users_id
     */
    public int getUsers_id() {
        return users_id;
    }

    /**
     * @param users_id the users_id to set
     */
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "/" + date.getMonth() + "/" + date.getDate();
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
    
    
    
}
    
    
