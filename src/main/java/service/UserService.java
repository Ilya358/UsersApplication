package service;

import dao.UserDao;
import model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public UserService() {
    }

    public User getUserById(long id) {
        try {
            return getUserDao().getUserById(id);
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    public List<User> getAllUser() {
        return getUserDao().getAllUser();
    }

    public static void deleteUser(Long id) throws SQLException {
        getUserDao().deleteUser(id);
    }

    public static void addUser(User user) throws SQLException {
        getUserDao().addUser(user);
    }

    public static void updateUser(User user) throws SQLException {
        getUserDao().updateUser(user);
    }

    public void cleanUp() {
        UserDao dao = getUserDao();
        try {
            dao.dropTable();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }
    public void createTable() {
        UserDao dao = getUserDao();
        try {
            dao.createTable();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=12345678").       //password
                    append("&serverTimezone=GMT");   //timeZone

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());

            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserDao getUserDao() {
        return new UserDao(getMysqlConnection());
    }
}
