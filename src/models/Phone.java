package models;
/**
 * @Author Tom Scholten
 * @Class
 * @Date 
 */
public class Phone {
    private int id = 0;
    private int passengerluggage_id;
    private String phone;

    /**
     *
     */
    public Phone() {
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
}
