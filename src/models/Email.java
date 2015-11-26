package models;
/**
 * @Author Tom Scholten
 * @Class
 * @Date 
 */
public class Email {
    private int id = 0;
    private int passengerluggage_id;
    private String email;

    /**
     *
     */
    public Email() {
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
