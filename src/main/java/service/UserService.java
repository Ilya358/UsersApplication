package service;

import dao.UserDao;
import dao.UserHibernateDao;
import dao.UserJdbcDao;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static SessionFactory sessionFactory;
    private static UserService userService;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }

    public List<User> getAllUser() {
        return new UserHibernateDao(sessionFactory.openSession()).getAllUser();
    }

    public void deleteUser(Long id) throws SQLException {
        new UserHibernateDao(sessionFactory.openSession()).deleteUser(id);
    }

    public void addUser(User user) throws SQLException {
        new UserHibernateDao(sessionFactory.openSession()).addUser(user);
    }

    public void updateUser(User user) throws SQLException {
        new UserHibernateDao(sessionFactory.openSession()).updateUser(user);
    }
//    public UserDao userDao() {
//        return userDao;
//    }
}
