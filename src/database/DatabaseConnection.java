package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Tom Scholten Class: Made on:
 */
public class DatabaseConnection {

    private java.sql.Connection connection;
    
    private String host;
    private String database;
    private String user;
    private String password;

    /**
     * Makes a connection to the database.
     *
     * @throws SQLException SQL error exceptions
     * @throws java.io.FileNotFoundException IO file error exceptions
     * @throws java.io.IOException IO error exceptions
     */
    public DatabaseConnection() throws SQLException, FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(".env")); //Reads a (text)file
        try {
            StringBuilder sb = new StringBuilder(); //builds strings
            String line = br.readLine(); //Read the .env file per line

            while (line != null) {
                sb.append(line); //Adds a line to the stringbuilder
                sb.append(System.lineSeparator()); //Adds a break to the Stringbuilder
                line = br.readLine(); //Reads another line that will be added next
            }
            String everything = sb.toString(); //Total String of the .env file
            System.out.println(everything); //Test in the console
            
            /*
            The regex is a tool to find specific text in a String. To find the text you use different
            symbols, all these symboles have their own definition. The dot stands for everything except
            the linebreaks, the plus stands for everything that comes after the thing I did before this,
            except what comes after a linebreak. So Down here I say HOST=(.+), it takes everything 
            after the "HOST=" because of the dot, the plus makes sure it stops at the linebreak. Since
            the .env excist out of four lines with break between them, we can get the HOST, DATABASE,
            USERNAME and PASSWORD all individually and save them in a variable.
            */
            
            Pattern h = Pattern.compile("HOST=(.+)"); //These are the patterns
            Pattern d = Pattern.compile("DATABASE=(.+)");
            Pattern u = Pattern.compile("USERNAME=(.+)");
            Pattern p = Pattern.compile("PASSWORD=(.+)");
            
            Matcher host = h.matcher(everything); //Here it tells it with what is should be matched
            Matcher db = d.matcher(everything);
            Matcher user = u.matcher(everything);
            Matcher pass = p.matcher(everything);

            if (host.find()) {
                this.host = host.group(1); //Here it finds the match
            }
            if (db.find()) {
                this.database = db.group(1);
            }
            if (user.find()) {
                this.user = user.group(1);
            }
            if (pass.find()) {
                this.password = pass.group(1);
            }
        } finally {
            br.close(); 
        }
        //Down here it uses the different variables to make a connection with the database.
        this.connection = DriverManager.getConnection("jdbc:mysql://"+ host +"/"+database, user, password);

    }

    /**
     * Executes a query to select from the database
     *
     * @param query String query that needs to be executed
     * @return Resultset, results of select
     * @throws SQLException SQL error exeptions
     */
    public ResultSet executeSelect(String query) throws SQLException {
        return this.connection.createStatement().executeQuery(query);
    }

    /**
     * Used for inserting, deleting and updating the database with a query.
     * 
     * @param query String query that needs to be executed
     * @throws SQLException SQL error exeptions
     */
    public void executeUpdate(String query) throws SQLException {
        this.connection.createStatement().executeUpdate(query);
    }

}
