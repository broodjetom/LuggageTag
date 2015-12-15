package models;
/**
 * @author Tom Scholten
 */
public class Email {
    private int id = 0;
    private int passenger_id;
    private String email;

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Returns the email, used in JavaFX classes
     * @return the email
     */
    public String toString() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
}
