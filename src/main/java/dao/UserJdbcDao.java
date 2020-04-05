package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao{

    private Connection connection;

    public UserJdbcDao(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String update = "select * from user";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(update);
            pstmt.execute();
            ResultSet resultSet = pstmt.getResultSet();
            while (resultSet.next()) {
                Long id1 = resultSet.getLong(1);
                String name1 = resultSet.getString(2);
                String surname = resultSet.getString(3);
                User user = new User(id1, name1, surname);
                list.add(user);
            }
            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateUser(User user) throws SQLException {
        String update = "UPDATE user SET name = ?, surname = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setLong(3, user.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }


    public void deleteUser(Long id) throws SQLException {
        String update = "delete from user where id=?";
        PreparedStatement pstmt = connection.prepareStatement(update);
        pstmt.setLong(1, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void addUser(User user) throws SQLException {
        String update = "insert into user(name, surname) values(?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(update);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getSurname());
        pstmt.executeUpdate();
        pstmt.close();
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
    private static UserJdbcDao getUserDao() {
        return new UserJdbcDao(getMysqlConnection());
    }
}
