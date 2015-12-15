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
            default:
                image = new ImageView("file:files/images//help/default.png");
                break;
        }
        return image;
    }
}
