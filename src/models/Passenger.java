package models;

import java.util.Date;
import javafx.collections.ObservableList;

/**
 * Author: Tom Scholten Class: Made on:
 */
public class Passenger {

    private Date date = new Date();
    private int id = 0;
    private String fname;
    private String mname;
    private String lname;
    private String comment;
    private int users_id;
    private Users user;

    private String date_added;
    private String date_changed;

    public ObservableList<models.Phone> phone;
    public ObservableList<models.Email> email;
    public ObservableList<models.Address> address;

    /**
     *
     */
    public Passenger() {

        this.date_added = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
    }

    /**
     * @return the fname
     */
    public String getFname() {

        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
    }

    /**
     * @return the users_id
     */
    public int getUsers_id() {
        return users_id;
    }
    
    /**
     * @return the the full name formatted correctly
     */
    public String getFullName() {
        return this.getFname() + (this.getMname().length() != 0 ? " "+this.getMname()+" " : " ") + this.getLname();
    }

    /**
     * @param users_id
     */
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
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
        this.date_changed = "" + (date.getYear() + 1900) + "-" + date.getMonth() + "-" + date.getDate();
    }
}
