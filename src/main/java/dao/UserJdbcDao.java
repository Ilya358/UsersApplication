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

    @Override
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
                String role = resultSet.getString(2);
                String name = resultSet.getString(3);
                String password = resultSet.getString(4);
                String surname = resultSet.getString(5);
                User user = new User(id1, role, name, password, surname);
                list.add(user);
            }
            resultSet.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        User user = null;
        String getUserById = "SELECT * FROM user WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(getUserById);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Long id1 = resultSet.getLong(1);
            String role = resultSet.getString(2);
            String name = resultSet.getString(3);
            String password = resultSet.getString(4);
            String surname = resultSet.getString(5);
            user = new User(id1, role, name, password, surname);
            resultSet.close();
            preparedStatement.close();
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String update = "UPDATE user SET name = ?, surname = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setLong(3, user.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        String update = "delete from user where id=?";
        PreparedStatement pstmt = connection.prepareStatement(update);
        pstmt.setLong(1, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void addUser(User user) throws SQLException {
        String update = "insert into user(role, name, password, surname) values(?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(update);
        pstmt.setString(1, user.getRole());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());
        pstmt.setString(4, user.getSurname());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void creatAdmin() throws SQLException {
        String update = "insert into user(role, name, password, surname) values(?, ?, ?, ?)";
        User admin = new User ("admin", "admin", "08211208", "admin");
        PreparedStatement pstmt = connection.prepareStatement(update);
        pstmt.setString(1, admin.getRole());
        pstmt.setString(2, admin.getName());
        pstmt.setString(3, admin.getPassword());
        pstmt.setString(4, admin.getSurname());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public boolean validateUser(String name, String password) throws SQLException {
        String update = "select password from user where name = ?";
        PreparedStatement pstmt = connection.prepareStatement(update);
        pstmt.setString(1, name);
        pstmt.execute();
        ResultSet resultSet = pstmt.getResultSet();
        if (resultSet.next()) {
            String password1 = resultSet.getString(1);
            pstmt.close();
            return password.equals(password1);
        } else {
            return false;
        }
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) throws SQLException {
        User user = null;
        String getUserByName = "SELECT * FROM user WHERE name = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(getUserByName);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Long id1 = resultSet.getLong(1);
            String role = resultSet.getString(2);
            String name1 = resultSet.getString(3);
            String password1 = resultSet.getString(4);
            String surname = resultSet.getString(5);
            user = new User(id1, role, name1, password1, surname);
            resultSet.close();
            preparedStatement.close();
        }
        return user;
    }
}
