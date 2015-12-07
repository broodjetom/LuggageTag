package models;
/**
 * @Author Tom Scholten
 * @Class
 * @Date 
 */
public class Phone {
    private int id = 0;
    private int passenger_id;
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
     * @return the passenger_id
     */
    public int getPassenger_id() {
        return passenger_id;
    }

    /**
     * @param passenger_id the passenger_id to set
     */
    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
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
