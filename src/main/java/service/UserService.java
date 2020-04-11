package service;

import dao.UserDao;
import factory.DaoFactory;
import factory.UserDaoFactory;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService;
    private UserDao userDao;
    private DaoFactory daoFactory = UserDaoFactory.getDaoFactory();

    private UserService() {
        this.userDao = daoFactory.createDao();
}
    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public User getUserById(long id) throws SQLException {
            return userDao.getUserById(id);
    }

    public void deleteUser(Long id) throws SQLException {
        userDao.deleteUser(id);
    }

    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }

    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }
    public void creatAdmin() throws SQLException {
        userDao.creatAdmin();
    }
    public boolean validateUser(String name, String password) throws SQLException {
        return userDao.validateUser(name, password);
    }
    public User getUserByNameAndPassword(String name, String password) throws SQLException {
        return userDao.getUserByNameAndPassword(name, password);
    }
}
