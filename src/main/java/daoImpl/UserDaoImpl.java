package daoImpl;

import dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tables.User;
//import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 03.06.16.
 */
@Repository(value = "userDao")
@Transactional
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory;
    private User user;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addUser(User user) throws SQLException {
//        sessionFactory.getCurrentSession().save(user);
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }


    public void editUser(User user) throws SQLException {
//        sessionFactory.getCurrentSession().update(user);
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }


    public User getUserById(int userId) throws SQLException {
//        User user = null;
//        user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
//        return user;
        //User user = null;
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            user = (User) session.get(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
                System.out.println("session is closed");
            }
        }
        return user;
    }


    public List<User> getAllUsers() throws SQLException {
//        List<User> users = null;
//        users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
//        return users;
//    }
        List<User>users = null;
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            users = session.createCriteria(User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return users;
    }

}
