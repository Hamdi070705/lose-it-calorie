package loseitcalorie.controllers;

import java.sql.ResultSet;

import loseitcalorie.config.DbConfig;
import loseitcalorie.models.User;

public class UserController extends DbConfig {
    public static boolean addUser(String name, String gender) {
        String query = "INSERT INTO User (name, gender) VALUES (?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, gender);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User isUserLoggedIn() {
        String query = "SELECT * FROM User";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            try (ResultSet userResultSet = preparedStatement.executeQuery()) {
                if (userResultSet.next()) {
                    int userId = userResultSet.getInt("id");
                    String name = userResultSet.getString("name");
                    String gender = userResultSet.getString("gender");
                    User user = new User(userId, name, gender);
                    return user;
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean updateUser(String name, String gender) {
       String query = "UPDATE User SET name=?, gender=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, gender);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteUser(String name) {
        String query = "DELETE FROM User WHERE name=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
