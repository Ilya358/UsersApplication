package dao;

import java.sql.SQLException;
import java.util.List;

import model.User;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.DBHelper;

import javax.persistence.NoResultException;


public class UserHibernateDao implements UserDao{
    private SessionFactory sessionFactory;

    public UserHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> user = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User getUserById(Long id) {
        User user = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        user = session.load(User.class, id);
        Hibernate.initialize(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.openSession();
        User user;
        Transaction transaction = session.beginTransaction();
        user = session.load(User.class, id);
        session.delete(user);
        session.flush();
        transaction.commit();
        session.close();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    public void creatAdmin()  {
        Session session = sessionFactory.openSession();
        User admin = new User ("admin", "admin", "08211208", "admin");
        session.save(admin);
        session.close();
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        User user = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where name = :name" +
                " and password = :password");
        query.setParameter("name", name);
        query.setParameter("password", password);
        user = (User) query.getSingleResult();
        session.close();
        return user;
    }

    @Override
    public boolean validateUser(String name, String password) {
        User user = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where name = :name" +
                " and password = :password");
        query.setParameter("name", name);
        query.setParameter("password", password);
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        session.close();
        return user.getPassword().equals(password);
    }
}
