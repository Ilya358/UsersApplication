package dao;

import java.util.List;

import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.DBHelper;


public class UserHibernateDao implements UserDao{
    private SessionFactory sessionFactory;

    public UserHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> user = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return user;
    }

    public User getUserById(long id) {
        User user = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        user = session.load(User.class, id);
        Hibernate.initialize(user);
        transaction.commit();
        session.close();
        return user;
    }

    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

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
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }
}
