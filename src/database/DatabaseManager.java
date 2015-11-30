package database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Author: Tom Scholten Class: Made on:
 */
public class DatabaseManager {

    private DatabaseConnection databaseconnection;

    /**
     * Creates a database manager.
     *
     * @throws SQLException
     */
    public DatabaseManager() throws SQLException, IOException {
        this.databaseconnection = new DatabaseConnection();
    }

    /**
     * Saves data, stored in passengerluggage object, to database. if id is stored, the data will be
     * updated, otherwise it will be saved as a new record.
     *
     * @param model.Passengerluggage(), object of passengerluggage
     * @return
     * @throws SQLException
     */
    public models.PassengerLuggage savePassengerLuggage(models.PassengerLuggage model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE `passengerluggage` SET "
                    + "fname ='" + model.getFname() + "', mname = '" + model.getMname()
                    + "', lname = '" + model.getLname() + "', flight = '" + model.getFlight()
                    + "', brand_id = " + model.getBrand_id() + ", color_id = "
                    + model.getColor_id() + ", weight = " + model.getWeight()
                    + ", material_id = " + model.getMaterial_id() + ", stickers = "
                    + model.getStickers() + ", characteristic = '" + model.getCharacteristic()
                    + "', belt = " + model.getBelt() + ", type_id = " + model.getType_id()
                    + ", location_id =" + model.getLocation().getId() + ", comment ='"
                    + model.getComment() + "', users_id = " + model.getUsers_id()
                    + ", date_added =" + model.getDate_added() + ", date_changed ="
                    + model.getDate_changed() + ", date_finished =" + model.getDate_finished()
                    + ", situation = \'" + model.getSituation()
                    + "\' WHERE id = " + model.getId());
        } else {
            databaseconnection.executeQuery("INSERT INTO `passengerluggage`"
                    + "(`fname`, `mname`, `lname`, `flight`, `brand_id`, `color_id`, "
                    + "`weight`, `material_id`, `stickers`, `characteristic`, `belt`, "
                    + "`type_id`, `location_id`, `comment`, `users_id`, `date_added`, "
                    + "`date_changed`, `date_finished`, `situation`)"
                    + "VALUES"
                    + "(\"" + model.getFname() + "\", \"" + model.getMname()
                    + "\", \"" + model.getLname() + "\", \"" + model.getFlight()
                    + "\"," + model.getBrand_id() + "," + model.getColor_id()
                    + ", " + model.getWeight() + ", " + model.getMaterial_id() + ","
                    + "" + model.getStickers() + ", \"" + model.getCharacteristic()
                    + "\", " + model.getBelt() + ", " + model.getType_id() + ", "
                    + model.getLocation_id() + ", \"" + model.getComment() + "\", "
                    + model.getUsers_id() + "," + "\"" + model.getDate_added()
                    + "\", \"" + model.getDate_changed() + "\", \""
                    + model.getDate_finished() + "\", '" + model.getSituation() + "\')");
            model.setId(getLastInsertId("passengerluggage"));
        }
        return model;
    }

    public ObservableList<models.PassengerLuggage> getPassengerLuggage(int id) throws SQLException {
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM passengerluggage "
                + "WHERE id =" + id);

        ObservableList<models.PassengerLuggage> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.PassengerLuggage row = new models.PassengerLuggage();
            row.setId(resultSet.getInt("id"));
            row.setFname(resultSet.getString("fname"));
            row.setMname(resultSet.getString("mname"));
            row.setLname(resultSet.getString("lname"));
            row.setFlight(resultSet.getString("flight"));
            row.setBrand_id(resultSet.getInt("brand_id"));
            row.setBrand(getBrand(resultSet.getInt("brands_id")));
            row.setColor_id(resultSet.getInt("color_id"));
            row.setColor(getColor(resultSet.getInt("color_id")));
            row.setWeight(resultSet.getDouble("weight"));
            row.setMaterial_id(resultSet.getInt("material_id"));
            row.setMaterial(getMaterial(resultSet.getInt("material_id")));
            row.setStickers(resultSet.getInt("stickers"));
            row.setCharacteristic(resultSet.getString("characteristic"));
            row.setType_id(resultSet.getInt("type_id"));
            row.setType(getType(resultSet.getInt("type_id")));
            row.setBelt(resultSet.getInt("belt"));
            row.setLocation_id(resultSet.getInt("location_id"));
            row.setLocation(getLocation(resultSet.getInt("location_id")));
            row.setComment(resultSet.getString("comment"));
            row.setUsers_id(resultSet.getInt("users_id"));
            row.setUser(getUser(resultSet.getInt("users_id")));
            row.setDate_added(resultSet.getString("date_added"));
            row.setDate_changed(resultSet.getString("date_changed"));
            row.setDate_finished(resultSet.getString("date_finished"));
            row.setPhone(getPhones(resultSet.getInt("id")));
            row.setEmail(getEmails(resultSet.getInt("id")));
            row.setAddress(getAddresses(resultSet.getInt("id")));
            row.setSituation(resultSet.getString("situation"));
            results.add(row);
        }
        return results;
    }

    /**
     * Returns a list of records form table passengerluggage, which can be presented in a table.
     *
     * @param model
     * @return ObservableList
     * @throws SQLException
     */
    public ObservableList<models.PassengerLuggage> getPassengerLuggage(models.PassengerLuggage model) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        boolean addWhere = false;

        String query = "SELECT * FROM passengerluggage WHERE ";

        if (model.getFname() != null) {
            System.out.println("Wel");
            query += "fname LIKE '%" + model.getFname() + "%' AND ";
            addWhere = true;
        }

        if (model.getMname() != null) {
            query += "mname LIKE '%" + model.getMname() + "%' AND ";
            addWhere = true;
        }

        if (model.getLname() != null) {
            query += "lname LIKE '%" + model.getLname() + "%' AND ";
            addWhere = true;
        }

        if (model.getFlight() != null) {
            query += "flight LIKE '%" + model.getFlight() + "%' AND ";
            addWhere = true;
        }

        if (model.getBrand_id() != 0) {
            query += "brand_id = " + model.getBrand_id() + " AND ";
            addWhere = true;
        }

        if (model.getColor_id() != 0) {
            query += "color_id = " + model.getColor_id() + " AND ";
            addWhere = true;
        }

        if (model.getWeight() != 0) {
            query += "weight = " + model.getWeight() + " AND ";
            addWhere = true;
        }

        if (model.getMaterial_id() != 0) {
            query += "material_id = " + model.getMaterial_id() + " AND ";
            addWhere = true;
        }

        if (model.getStickers() != 0) {
            query += "stickers = " + model.getStickers() + " AND ";
            addWhere = true;
        }

        if (model.getBelt() != 0) {
            query += "belt = " + model.getBelt() + " AND ";
            addWhere = true;
        }

        if (model.getType_id() != 0) {
            query += "type_id = " + model.getType_id() + " AND ";
            addWhere = true;
        }

        if (addWhere) {
            query = query.substring(0, query.length() - 4);
        } else {
            query = query.substring(0, query.length() - 6);
        }
        System.out.println(query);
        ResultSet resultSet = databaseconnection.executeSelect(query);

        ObservableList<models.PassengerLuggage> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.PassengerLuggage row = new models.PassengerLuggage();
            row.setId(resultSet.getInt("id"));
            row.setFname(resultSet.getString("fname"));
            row.setMname(resultSet.getString("mname"));
            row.setLname(resultSet.getString("lname"));
            row.setFlight(resultSet.getString("flight"));
            row.setBrand_id(resultSet.getInt("brand_id"));
            row.setBrand(getBrand(resultSet.getInt("brand_id")));
            row.setColor_id(resultSet.getInt("color_id"));
            row.setColor(getColor(resultSet.getInt("color_id")));
            row.setWeight(resultSet.getDouble("weight"));
            row.setMaterial_id(resultSet.getInt("material_id"));
            row.setMaterial(getMaterial(resultSet.getInt("material_id")));
            row.setStickers(resultSet.getInt("stickers"));
            row.setCharacteristic(resultSet.getString("characteristic"));
            row.setType_id(resultSet.getInt("type_id"));
            row.setType(getType(resultSet.getInt("type_id")));
            row.setBelt(resultSet.getInt("belt"));
            row.setLocation_id(resultSet.getInt("location_id"));
            row.setLocation(getLocation(resultSet.getInt("location_id")));
            row.setComment(resultSet.getString("comment"));
            row.setUsers_id(resultSet.getInt("users_id"));
            row.setUser(getUser(resultSet.getInt("users_id")));
            row.setDate_added(resultSet.getString("date_added"));
            row.setDate_changed(resultSet.getString("date_changed"));
            row.setDate_finished(resultSet.getString("date_finished"));
            row.setPhone(getPhones(resultSet.getInt("id")));
            row.setEmail(getEmails(resultSet.getInt("id")));
            row.setAddress(getAddresses(resultSet.getInt("id")));
            results.add(row);
        }
        return results;
    }

    /**
     *
     * @param table
     * @return
     * @throws SQLException
     */
    public int getLastInsertId(String table) throws SQLException {
        ResultSet resultSet = databaseconnection.executeSelect("SELECT id FROM "
                + table + " WHERE id = last_insert_id()");
        int id = resultSet.getInt("id");
        return id;
    }

    /**
     * Saves data, stored in Users object, to database. if id is stored, the data will be updated,
     * otherwise it will be saved as a new record.
     *
     * @param model.Users(), object of Users.
     * @throws SQLException
     */
    public void saveUsers(models.Users model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate(
                    "UPDATE users SET username = \'" + model.getUsername() + "\', password =\'"
                    + model.getPassword() + "\', fname = \'" + model.getFname() + "\', mname =\'"
                    + model.getMname() + "\', lname =\'" + model.getLname() + "\', phone=\'"
                    + model.getPhone() + "\', ee_num = \'" + model.getEe_num() + "\', employee ="
                    + model.getEmployee() + ", manager =" + model.getManager()
                    + ", admin =" + model.getAdmin() + ", setting_id =" + model.getLocation_id()
                    + " WHERE id = " + model.getId());
        } else {
            databaseconnection.executeQuery(
                    "INSERT INTO users (`username`, `password`, `fname`, `mname`, `lname`, "
                    + "`phone`, `ee_num`, `employee`, `manager`, `admin`, `setting_id`)"
                    + "VALUES (\"" + model.getUsername() + "\", \"" + model.getPassword() + "\", \""
                    + "\"" + model.getFname() + "\", \"" + model.getMname() + "\", \""
                    + "\"" + model.getLname() + "\", \"" + model.getPhone() + "\", \""
                    + "\"" + model.getEe_num() + "\", \"" + model.getEmployee() + "\", \""
                    + "\"" + model.getManager() + "\", \"" + model.getAdmin() + "\", \""
                    + "\"" + model.getLocation_id() + "\")");
        }
    }

    /**
     * Returns a list of records form table Users, which can be presented in a table.
     *
     * @return ObservableList
     * @throws SQLException
     */
    public ObservableList getUsers(models.Users model) throws SQLException {

        boolean addWhere = false;

        String query = "SELECT * FROM users WHERE ";

        if (!model.getFname().isEmpty()) {
            query += "fname LIKE '%" + model.getFname() + "%' AND ";
            addWhere = true;
        }

        if (!model.getMname().isEmpty()) {
            query += "mname LIKE '%" + model.getMname() + "%' AND ";
            addWhere = true;
        }

        if (!model.getLname().isEmpty()) {
            query += "lname LIKE '%" + model.getLname() + "%' AND ";
            addWhere = true;
        }

        if (model.getLocation_id() != 0) {
            query += "location_id = " + model.getLocation_id() + " AND ";
        }

        if (addWhere) {
            query = query.substring(0, query.length() - 4);
        } else {
            query = query.substring(0, query.length() - 6);
        }

        ResultSet resultSet = databaseconnection.executeSelect(query);

        ObservableList<models.Users> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Users row = new models.Users();
            row.setId(resultSet.getInt("id"));
            row.setFname(resultSet.getString("fname"));
            row.setMname(resultSet.getString("mname"));
            row.setLname(resultSet.getString("lname"));
            row.setPhone(resultSet.getString("phone"));
            row.setEe_num(resultSet.getString("ee_num"));
            row.setEmployee(resultSet.getInt("employee"));
            row.setManager(resultSet.getInt("manager"));
            row.setAdmin(resultSet.getInt("admin"));
            row.setLocation_id(resultSet.getInt("setting_id"));
            results.add(row);
        }
        return results;
    }

    public models.Users getUserForLogin(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username ='" + username + "' AND password ='" + password + "' LIMIT 1";

        ResultSet resultSet = databaseconnection.executeSelect(query);
        
        models.Users model = new models.Users();
        
        while (resultSet.next()){
            model.setId(resultSet.getInt("id"));
            model.setFname(resultSet.getString("fname"));
            model.setMname(resultSet.getString("mname"));
            model.setLname(resultSet.getString("lname"));
            model.setPhone(resultSet.getString("phone"));
            model.setEe_num(resultSet.getString("ee_num"));
            model.setEmployee(resultSet.getInt("employee"));
            model.setManager(resultSet.getInt("manager"));
            model.setAdmin(resultSet.getInt("admin"));
            model.setLocation_id(resultSet.getInt("setting_id"));
        }
        return model;
    }
    
    public boolean getCorrectForLogin(String username, String password) throws SQLException {

        String query = "SELECT * FROM users WHERE username ='" + username + "' AND password ='" + password + "' LIMIT 1";

        ResultSet resultSet = databaseconnection.executeSelect(query);

        models.Users row = new models.Users();
        if (!resultSet.next()) {
            return false;
        }
        return true;
    }

    public models.Users getUser(int id) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        if (id == 0) {
            return new models.Users();
        }

        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM users "
                + "WHERE id=" + id + " limit 1");

        models.Users row = new models.Users();
        row.setId(resultSet.getInt("id"));
        row.setFname(resultSet.getString("fname"));
        row.setMname(resultSet.getString("mname"));
        row.setLname(resultSet.getString("lname"));
        row.setPhone(resultSet.getString("phone"));
        row.setEe_num(resultSet.getString("ee_num"));
        row.setEmployee(resultSet.getInt("employee"));
        row.setManager(resultSet.getInt("manager"));
        row.setAdmin(resultSet.getInt("admin"));
        row.setLocation_id(resultSet.getInt("location_id"));
        row.setLocation(getLocation(resultSet.getInt("location_id")));
        return row;
    }

    /**
     * Saves data, stored in Locations object, to database. if id is stored, the data will be
     * updated, otherwise it will be saved as a new record.
     *
     * @param model.Locations(), object from Locations
     * @return
     * @throws SQLException
     */
    public models.Locations saveLocation(models.Locations model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE locations SET location = \'" + model.getLocation() + "\' "
                    + "WHERE id = " + model.getId());

        } else {
            databaseconnection.executeQuery("INSERT INTO locations (`location`) "
                    + "VALUES (\"" + model.getLocation() + "\")");
        }
        return model;
    }

    /**
     * Returns a list of records form table Locations, which can be presented in a table.
     *
     * @return ObservableList
     * @throws SQLException
     */
    public ObservableList<models.Locations> getLocations() throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM locations");

        ObservableList<models.Locations> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Locations row = new models.Locations();
            row.setId(resultSet.getInt("id"));
            row.setLocation(resultSet.getString("location"));
            results.add(row);
        }
        return results;
    }

    /**
     * Returns a list of records form table Locations, which can be presented in a table.
     *
     * @param id
     * @return ObservableList
     * @throws SQLException
     */
    public models.Locations getLocation(int id) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM locations "
                + "WHERE id=" + id + " limit 1");

        resultSet.next();
        models.Locations row = new models.Locations();
        row.setId(resultSet.getInt("id"));
        row.setLocation(resultSet.getString("location"));
        return row;
    }

    /**
     * Returns a list of records form table Locations, which can be presented in a table.
     *
     * @param location
     * @return ObservableList
     * @throws SQLException
     */
    public ObservableList<models.Locations> getLocations(String location) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM locations "
                + "WHERE location=\"" + location + "\"");

        ObservableList<models.Locations> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Locations row = new models.Locations();
            row.setId(resultSet.getInt("id"));
            row.setLocation(resultSet.getString("location"));
            results.add(row);
        }
        return results;
    }

    public void saveBrand(models.Brands model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE brands SET brand = \'" + model.getBrand() + "\' "
                    + "WHERE id = " + model.getId());

        } else {
            databaseconnection.executeQuery("INSERT INTO brands (`brand`) "
                    + "VALUES ('" + model.getBrand() + "')");

        }
    }

    public ObservableList<models.Brands> getBrands() throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM brands");

        ObservableList<models.Brands> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Brands row = new models.Brands();
            row.setId(resultSet.getInt("id"));
            row.setBrand(resultSet.getString("brand"));
            results.add(row);
        }
        return results;
    }

    public models.Brands getBrand(int id) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM brands "
                + "WHERE id=" + id + " limit 1");

        resultSet.next();
        models.Brands row = new models.Brands();
        row.setId(resultSet.getInt("id"));
        row.setBrand(resultSet.getString("brand"));
        return row;
    }

    public ObservableList<models.Brands> getBrands(String brand) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM brands "
                + "WHERE brand=\"" + brand + "\"");

        ObservableList<models.Brands> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Brands row = new models.Brands();
            row.setId(resultSet.getInt("id"));
            row.setBrand(resultSet.getString("brand"));
            results.add(row);
        }
        return results;
    }

    public void saveColor(models.Colors model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE colors SET color = '" + model.getColor() + "' "
                    + "WHERE id =" + model.getId());

        } else {
            databaseconnection.executeQuery("INSERT INTO colors (`color`) "
                    + "VALUES (\"" + model.getColor() + "\")");

        }
    }

    public ObservableList getColors() throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM colors");

        ObservableList<models.Colors> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Colors row = new models.Colors();
            row.setId(resultSet.getInt("id"));
            row.setColor(resultSet.getString("color"));
            results.add(row);
        }
        return results;
    }

    public models.Colors getColor(int id) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        if (id == 0) {
            return new models.Colors();
        }

        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM colors "
                + "WHERE id=" + id + " limit 1");

        resultSet.next();
        models.Colors row = new models.Colors();
        row.setId(resultSet.getInt("id"));
        row.setColor(resultSet.getString("color"));
        return row;
    }

    public ObservableList getColors(String color) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM locations "
                + "WHERE color=\"" + color + "\"");

        ObservableList<models.Locations> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Locations row = new models.Locations();
            row.setId(resultSet.getInt("id"));
            row.setLocation(resultSet.getString("color"));
            results.add(row);
        }
        return results;
    }

    public void saveMaterial(models.Materials model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE materials SET material = \'"
                    + model.getMaterial() + " WHERE id = " + model.getId());

        } else {
            databaseconnection.executeQuery("INSERT INTO materials (`material`) "
                    + "VALUES (\"" + model.getMaterial() + "\")");
        }
    }

    public ObservableList<models.Materials> getMaterials() throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM materials");

        ObservableList<models.Materials> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Materials row = new models.Materials();
            row.setId(resultSet.getInt("id"));
            row.setMaterial(resultSet.getString("material"));
            results.add(row);
        }
        return results;
    }

    public models.Materials getMaterial(int id) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        if (id == 0) {
            return new models.Materials();
        }

        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM materials "
                + "WHERE id=" + id + " limit 1");

        resultSet.next();
        models.Materials row = new models.Materials();
        row.setId(resultSet.getInt("id"));
        row.setMaterial(resultSet.getString("material"));
        return row;
    }

    public ObservableList<models.Materials> getMaterials(String material) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM materials "
                + "WHERE material=\"" + material + "\"");

        ObservableList<models.Materials> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Materials row = new models.Materials();
            row.setId(resultSet.getInt("id"));
            row.setMaterial(resultSet.getString("color"));
            results.add(row);
        }
        return results;
    }

    public void saveType(models.Types model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE types SET type = " + model.getType()
                    + "WHERE id =" + model.getId());

        } else {
            databaseconnection.executeQuery("INSERT INTO types (`type`) "
                    + "VALUES (\"" + model.getType() + "\")");
        }
    }

    public ObservableList<models.Types> getTypes() throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("select * from types");

        ObservableList<models.Types> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Types row = new models.Types();
            row.setId(resultSet.getInt("id"));
            row.setType(resultSet.getString("type"));
            results.add(row);
        }
        return results;
    }

    public models.Types getType(int id) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        if (id == 0) {
            return new models.Types();
        }

        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM types "
                + "WHERE id=" + id + " limit 1");

        resultSet.next();
        models.Types row = new models.Types();
        row.setId(resultSet.getInt("id"));
        row.setType(resultSet.getString("type"));
        return row;
    }

    public ObservableList<models.Types> getTypes(String type) throws SQLException {
        // Krijg resultaten als PassengerLuggage
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM types "
                + "WHERE type=\"" + type + "\"");

        ObservableList<models.Types> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Types row = new models.Types();
            row.setId(resultSet.getInt("id"));
            row.setType(resultSet.getString("Type"));
            results.add(row);
        }
        return results;
    }

    public models.Phone savePhone(models.Phone model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE phones SET phone = \""
                    + model.getPhone() + "\" "
                    + "WHERE id = " + model.getId());
        } else {
            databaseconnection.executeQuery("INSERT INTO phones (`passengerluggage_id`, `phone`)"
                    + " VALUES (" + model.getPassengerluggage_id()
                    + ", \"" + model.getPhone() + "\")");
            model.setId(getLastInsertId("phones"));
        }
        return model;
    }

    public ObservableList<models.Phone> getPhones(int passengerluggage_id) throws SQLException {
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM phone "
                + "WHERE passengerluggage_id=" + passengerluggage_id);

        ObservableList<models.Phone> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Phone row = new models.Phone();
            row.setId(resultSet.getInt("id"));
            row.setPassengerluggage_id(resultSet.getInt("passengerluggage_id"));
            row.setPhone(resultSet.getString("phone"));
            results.add(row);
        }
        return results;
    }

    public models.Email saveEmail(models.Email model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE emails SET email = \"" + model.getEmail() + "\" "
                    + "WHERE id =" + model.getId());
        } else {
            databaseconnection.executeQuery("INSERT INTO emails (`email`) "
                    + "VALUES (\"" + model.getEmail() + "\")");
            model.getId();
        }
        return model;
    }

    public ObservableList<models.Email> getEmails(int passengerluggage_id) throws SQLException {
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM email "
                + "WHERE passengerluggage_id=" + passengerluggage_id);

        ObservableList<models.Email> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Email row = new models.Email();
            row.setId(resultSet.getInt("id"));
            row.setPassengerluggage_id(resultSet.getInt("passengerluggage_id"));
            row.setEmail(resultSet.getString("email"));
            results.add(row);
        }
        return results;
    }

    public models.Address saveAddress(models.Address model) throws SQLException {
        if (model.getId() != 0) {
            databaseconnection.executeUpdate("UPDATE address SET address = \"" + model.getAddress()
                    + "\", zip = \"" + model.getZip() + "\", land =\"" + model.getLand() + "\"");
        } else {

        }
        return model;
    }

    public ObservableList<models.Address> getAddresses(int passengerluggage_id) throws SQLException {
        ResultSet resultSet = databaseconnection.executeSelect("SELECT * FROM phone "
                + "WHERE passengerluggage_id=" + passengerluggage_id);

        ObservableList<models.Address> results
                = FXCollections.observableArrayList();

        while (resultSet.next()) {
            models.Address row = new models.Address();
            row.setId(resultSet.getInt("id"));
            row.setPassengerluggage_id(resultSet.getInt("passengerluggage_id"));
            row.setAddress(resultSet.getString("address"));
            row.setZip(resultSet.getString("zip"));
            row.setLand(resultSet.getString("land"));
            results.add(row);
        }
        return results;
    }

}
