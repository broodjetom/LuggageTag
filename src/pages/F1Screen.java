/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import javafx.scene.image.ImageView;

/**
 *
 * @author Alex Lisenkov
 */
public class F1Screen {

    /**
     * getImage returns ImageView of the page
     *
     * @param page
     * @return ImageView image
     */
    public ImageView getImage(String page) {
        ImageView image;
        switch (page) {
            case "SearchLuggage":
                image = new ImageView("file:files/images/help/SearchLuggage.png");
                break;
            case "AddLuggage":
                image = new ImageView("file:files/images/help/AddLuggage.png");
                break;
            case "AddPassenger":
                image = new ImageView("file:files/images/help/AddPassenger.png");
                break;
            case "Login":
                image = new ImageView("file:files/images/help/InlogScherm.png");
                break;
            case "Stats":
                image = new ImageView("file:files/images/help/Stats.png");
                break;
            case "Overview":
                image = new ImageView("file:files/images/help/Overview.png");
                break;
            case "AddUser":
                image = new ImageView("file:files/images/help/AddUser.png");
                break;
            case "Users":
                image = new ImageView("file:files/images/help/Users.png");
                break;
            case "Locations":
                image = new ImageView("file:files/images/help/Locations.png");
                break;
            case "AddCatagory":
                image = new ImageView("file:files/images/help/AddCatagory.png");
                break;
            case "SearchPassenger":
                image = new ImageView("file:files/images/help/SearchPassenger.png");
                break;
            case "ForgotPassword":
                image = new ImageView("file:files/images/help/ForgotPassword.png");
                break;

            default:
                image = new ImageView("file:files/images//help/default.png");
                break;
        }
        return image;
    }
}
