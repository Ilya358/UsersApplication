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

    public User getUserById(long id)  {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("select * from user where name='" + id + "'");
            ResultSet result = stmt.getResultSet();
            if (result.next()) {
                Long id1 = result.getLong(1);
                String name = result.getString(2);
                String surname = result.getString(3);
                User user = new User(id1, name, surname);
                result.close();
                stmt.close();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
}
