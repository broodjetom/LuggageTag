package pages.menus;

import UI.LuggageMenu;
import UI.LuggageUI;
import database.DatabaseManager;
import java.util.concurrent.Callable;
import pages.*;

/**
 *
 * @author Alex/Thomas
 */
public class Manager {

    private LuggageUI UI;
    private DatabaseManager db;

    private static final user.Session USER = user.Session.getInstance();

    public Manager(LuggageUI UI, DatabaseManager db) {
        this.UI = UI;
        this.db = db;

        // Maak een nieuwe menu aan met de LuggageMenu class, deze is wel beetje buggy nog
        LuggageMenu menu = new LuggageMenu(UI);

        // Maak nieuw element aan, met de text Search Database
        // Active state is waar
        // En weer op dezelfde methode een eventlistener
        menu.addMenuItem("Logs", true, (Callable) () -> {
            pages.Logs page = new pages.Logs(UI, db);
            return true;
        });

        

        menu.addMenuItem("Stats", false, (Callable) () -> {
            pages.Stats page = new pages.Stats(UI, db);
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
