
package pages.menus;

import UI.LuggageMenu;
import UI.LuggageUI;
import database.DatabaseManager;
import java.util.concurrent.Callable;
import pages.*;

/**
 *
 * @author Alex
 */
public class Employee {
    private LuggageUI UI;
    private DatabaseManager db;
    
    private static final user.Session USER = user.Session.getInstance();
    
    public Employee( LuggageUI UI, DatabaseManager db ){
        this.UI = UI;
        this.db = db;
        
        // Maak een nieuwe menu aan met de LuggageMenu class, deze is wel beetje buggy nog
        LuggageMenu menu = new LuggageMenu(UI);
        
        // Maak nieuw element aan, met de text Search Database
        // Active state is waar
        // En weer op dezelfde methode een eventlistener
        menu.addMenuItem("Search Customer", true, (Callable) () -> {
            pages.SearchCustomer page = new pages.SearchCustomer(UI, db);
            return true;
        });
        
        // Je snapt het idee wel, maar hier is de active state false
        menu.addMenuItem("Add new Customer", false, (Callable) () -> {
            pages.AddCustomer page = new pages.AddCustomer(UI, db);
            return true;
        });
        
        menu.addMenuItem("Search Luggage", false, (Callable) () -> {
           pages.SearchLuggage page = new pages.SearchLuggage(UI, db);
            return true;
        });
        
        menu.addMenuItem("Add Luggage", false, (Callable) () -> {
           pages.AddLuggage page = new pages.AddLuggage(UI, db);
            return true;
        });
        
        menu.addMenuItem("Help", false, (Callable) () -> {
           // pages.SearchLuggage page = new pages.SearchLuggage(UI, db);   //!!!!JUISTER PAGE NOG TOEWIJZEN
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
    