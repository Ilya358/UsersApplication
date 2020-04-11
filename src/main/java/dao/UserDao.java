package dao;

import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    void updateUser(User user) throws SQLException;
    void deleteUser(Long id) throws SQLException;
    void addUser(User user) throws SQLException;
    User getUserById(Long id) throws SQLException;
    void creatAdmin() throws SQLException;
    User getUserByNameAndPassword(String name, String password) throws SQLException;
    boolean validateUser(String name, String password) throws SQLException;
}
