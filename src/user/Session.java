/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 * Singleton class, call 
 * @author Alex
 */
public class Session {
   private static Session instance = null;
   private models.Users user = new models.Users();
   
   protected Session() {
      // Protect the constructor
   }
   
   /**
    * Get instance of the object
    * @return Session
    */
   public static Session getInstance() {
      if(instance == null) {
         instance = new Session();
      }
      return instance;
   }

    /**
     * @return the user
     */
    public models.Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(models.Users user) {
        this.user = user;
    }
    
    public void logout(){
        this.user = new models.Users();
    }
}