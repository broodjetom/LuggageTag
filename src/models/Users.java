package models;
/**
 * Author: Tom Scholten
 * Class:
 * Made on:
 */
public class Users {
    
    private int id = 0;
    private String username = "";
    private String password = "";
    private String fname = "";
    private String mname = "";
    private String lname = "";
    private String phone = "";
    private String ee_num = "";
    private int employee;
    private int manager;
    private int admin;
    private int location_id;
    private Locations location;

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the ee_num
     */
    public String getEe_num() {
        return ee_num;
    }

    /**
     * @param ee_num the ee_num to set
     */
    public void setEe_num(String ee_num) {
        this.ee_num = ee_num;
    }

    /**
     * @return the employee
     */
    public int getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(int employee) {
        this.employee = employee;
    }

    /**
     * @return the manager
     */
    public int getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(int manager) {
        this.manager = manager;
    }

    /**
     * @return the admin
     */
    public int getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(int admin) {
        this.admin = admin;
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
