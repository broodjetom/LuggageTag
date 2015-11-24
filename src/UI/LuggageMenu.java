/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

/**
 *
 * @author Alex
 */
public class LuggageMenu {

    private ToolBar menu;
    private final Group menuGroup = new Group();
    private final HBox menuGroupRow = new HBox();
    private int nodeCount = 0;

    // Logo settings
    final private ImageView LOGO = new ImageView("file:Corendon_logo_2015.png");
    final private double LOGOWITDH = 240;

    // Menu settings
    final private double BUTTONWIDTH = 200;
    final private double BUTTONHEIGHT = 50;

    LuggageUI UI;

    /**
     * Initializes the menu and adds the logo
     *
     * @param UI the LuggageUI object
     */
    public LuggageMenu(LuggageUI UI) {
        this.UI = UI;

        menu = new ToolBar();
        menu.setStyle("-fx-background-color: #f7f7f7; -fx-padding: 20px;");

        LOGO.setFitWidth(LOGOWITDH);
        LOGO.setPreserveRatio(true);
        menu.getItems().add(LOGO);
    }

    /**
     * Adds a spacer
     *
     * @param width
     */
    public void addSpacer(double width) {
        Pane pane = new Pane();
        pane.setMinWidth(width);
        menu.getItems().add(pane);
    }

    /**
     * toNode gives you the Node of the menu to be used in the UI
     *
     * @return Node menu
     */
    public ToolBar toNode() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double center = (primaryScreenBounds.getWidth() / 2) - (nodeCount * BUTTONWIDTH / 2) - LOGOWITDH;

        addSpacer(center);
        menuGroupRow.setAlignment(Pos.CENTER);
        menuGroup.getChildren().add(menuGroupRow);
        add(menuGroup);
        return menu;
    }

    /**
     * Adds node to the menu
     *
     * @param value Node to be added
     */
    public void add(Node value) {
        menu.getItems().add(value);
    }

    /**
     * Add a menu item to the menu
     *
     * @param text value of the button
     * @param active active state of the button
     * @param clickEvent Callable callback on click
     */
    public void addMenuItem(String text, Boolean active, Callable clickEvent) {
        addMenuItem(text, active, clickEvent, false);
    }

    /**
     * Returns a menu item if r is false
     *
     * @param text Value of the button
     * @param active Active state of the button
     * @param clickEvent Callable callback on click
     * @param r If true, this returns the button and does <b>not</b> add it to
     * the menu
     * @return
     */
    public Button addMenuItem(String text, Boolean active, Callable clickEvent, Boolean r) {
        Button btn = new Button();
        btn.setText(text);
        btn.setMinWidth(BUTTONWIDTH);
        btn.setMinHeight(BUTTONHEIGHT);

        btn.setUserData(active);

        btn.setFont(UI.uniSansHeavy);
        btn.setStyle("-fx-background-radius: 0; -fx-text-fill: #" + UI.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + UI.BUTTON_PRIMARY_BACKGOUND_COLOR);

        if (active) {
            btn.setStyle("-fx-background-radius: 0; -fx-text-fill: #" + UI.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + UI.BUTTON_PRIMARY_BACKGOUND_HOVER_COLOR);
            try {
                clickEvent.call();
            } catch (Exception ex) {
                Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        btn.setOnMouseEntered((MouseEvent t) -> {
            btn.setStyle("-fx-background-radius: 0; -fx-text-fill: #" + UI.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + UI.BUTTON_PRIMARY_BACKGOUND_HOVER_COLOR);
            UI.scene.setCursor(Cursor.HAND);
        });

        btn.setOnMouseExited((MouseEvent t) -> {
            if (!"true".equals(btn.getUserData().toString())) {
                btn.setStyle("-fx-background-radius: 0; -fx-text-fill: #" + UI.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + UI.BUTTON_PRIMARY_BACKGOUND_COLOR);
            }
            UI.scene.setCursor(Cursor.DEFAULT);
        });

        btn.setOnMouseClicked((MouseEvent t) -> {
            menuGroupRow.getChildren().forEach(b
            -> {
                b.setStyle("-fx-background-radius: 0; -fx-text-fill: #" + UI.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + UI.BUTTON_PRIMARY_BACKGOUND_COLOR);
                b.setUserData(false);
            }
            );
            btn.setUserData(true);

            btn.setStyle("-fx-background-radius: 0; -fx-text-fill: #" + UI.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + UI.BUTTON_PRIMARY_BACKGOUND_HOVER_COLOR);
            try {
                clickEvent.call();
            } catch (Exception ex) {
                Logger.getLogger(LuggageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        if (!r) {
            nodeCount++;
            menuGroupRow.getChildren().add(btn);
        }
        return btn;
    }

    /**
     * Adds a dropdown, this is not working correctly
     *
     * @param text Value of the button
     * @param active Active state of te button
     * @param clickEvent Callable callback on click
     */
    public void addDropDown(String text, Boolean active, Callable clickEvent) {
        Button btn = addMenuItem(text, active, clickEvent, true);
        Button btn2 = addMenuItem("test", active, clickEvent, true);
        Button btn3 = addMenuItem("test2", active, clickEvent, true);

        VBox Hmenu = new VBox();
        VBox HHack = new VBox();
        HHack.setUserData(active);

        HHack.toFront();
        HHack.setUserData(false);

        Hmenu.setVisible(false);
        Hmenu.getChildren().add(btn2);
        Hmenu.getChildren().add(btn3);

        HHack.getChildren().addAll(btn, Hmenu);

        HHack.setOnMouseEntered((MouseEvent t) -> {
            btn.setStyle("-fx-background-radius: 0; -fx-text-fill: #" + UI.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + UI.BUTTON_PRIMARY_BACKGOUND_HOVER_COLOR);
            UI.scene.setCursor(Cursor.HAND);
            Hmenu.setVisible(true);
            HHack.setUserData(true);
        });

        HHack.setOnMouseExited((MouseEvent t) -> {
            if (!"true".equals(btn.getUserData().toString())) {
                btn.setStyle("-fx-background-radius: 0; -fx-text-fill: #" + UI.BUTTON_PRIMARY_TEXT_COLOR + "; -fx-background-color: #" + UI.BUTTON_PRIMARY_BACKGOUND_COLOR);
            }
            Hmenu.setVisible(false);
            UI.scene.setCursor(Cursor.DEFAULT);
        });
        nodeCount++;
        menuGroupRow.getChildren().add(HHack);
    }
}
