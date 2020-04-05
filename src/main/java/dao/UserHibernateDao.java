package dao;

import java.util.List;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.DBHelper;

import static util.DBHelper.getSessionFactory;

public class UserHibernateDao implements UserDao{
    private Session session;

    public UserHibernateDao(Session session) {
        this.session = session;
    }


    public List<User> getAllUser() {

        Transaction transaction = session.beginTransaction();
        List<User> user = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return user;
    }
    public void updateUser(User user) {
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(Long id) {
        User user;
        Transaction transaction = session.beginTransaction();
        user = session.load(User.class, id);
        session.delete(user);
        session.flush();
        transaction.commit();
        session.close();
    }
    public void addUser(User user) {
        session.save(user);
        session.close();
    }
}
