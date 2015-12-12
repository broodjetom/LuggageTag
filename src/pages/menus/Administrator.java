/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.menus;

import UI.LuggageMenu;
import UI.LuggageUI;
import database.DatabaseManager;
import java.util.concurrent.Callable;

/**
 *
 * @author Alex/Thomas
 */
public class Administrator {
    private LuggageUI UI;
    private DatabaseManager db;
    
    private static final user.Session USER = user.Session.getInstance();
    
    public Administrator(LuggageUI UI, DatabaseManager db){
        this.UI = UI;
        this.db = db;
        
        // Maak een nieuwe menu aan met de LuggageMenu class, deze is wel beetje buggy nog
        LuggageMenu menu = new LuggageMenu(UI);
        
        // Maak nieuw element aan, met de text Search Database
        // Active state is waar
        // En weer op dezelfde methode een eventlistener
        menu.addMenuItem("Users", true, (Callable) () -> {
            pages.UsersPage page = new pages.UsersPage(UI, db);
            return true;
        });
        
        menu.addMenuItem("Add user", false, (Callable) () -> {
            pages.AddUser page = new pages.AddUser(UI, db);
            return true;
        });
        
        // Je snapt het idee wel, maar hier is de active state false
        menu.addMenuItem("Locations", false, (Callable) () -> {
            pages.Locations page = new pages.Locations(UI, db);
            return true;
        });
        
        menu.addMenuItem("Add category", false, (Callable) () -> {
            pages.AddCategory page = new pages.AddCategory(UI, db);
            return true;
        });
        
        menu.addMenuItem("Help", false, (Callable)()-> {
            pages.F1Screen page = new pages.F1Screen(UI, db);
            return true;
        });

        menu.addMenuItem("Logout", false, (Callable) () -> {
            USER.logout();
            UI.reset();
            pages.Login page = new pages.Login(UI, db);
            return true;
        });
        UI.setTop(
            menu.toNode() // menu.getMenu geeft et menu terug
        );
    }
}
