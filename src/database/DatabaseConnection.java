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
     * @throws SQLException SQL error exeptions
     * @throws java.io.FileNotFoundException IO file error exeptions
     * @throws java.io.IOException IO error exeptions
     */
    public DatabaseConnection() throws SQLException, FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(".env"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
            
            Pattern h = Pattern.compile("HOST=(.+)");
            Pattern d = Pattern.compile("DATABASE=(.+)");
            Pattern u = Pattern.compile("USERNAME=(.+)");
            Pattern p = Pattern.compile("PASSWORD=(.+)");
            Matcher host = h.matcher(everything);
            Matcher db = d.matcher(everything);
            Matcher user = u.matcher(everything);
            Matcher pass = p.matcher(everything);

            if (host.find()) {
                this.host = host.group(1);
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
        
        
        
        this.connection = DriverManager.getConnection("jdbc:mysql://"+ host +"/"+database, user, password);

    }

    /**
     * Executes a query to insert into the database.
     *
     * @param query String query that needs to be executed
     * @throws SQLException SQL error exeptions
     */
    public void executeQuery(String query) throws SQLException {
        this.connection.createStatement().executeQuery(query);
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
     *
     * @param query String query that needs to be executed
     * @throws SQLException SQL error exeptions
     */
    public void executeUpdate(String query) throws SQLException {
        this.connection.createStatement().executeUpdate(query);
    }

}
