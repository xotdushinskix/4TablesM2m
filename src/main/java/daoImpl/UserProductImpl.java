package daoImpl;

import dao.UserProductDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tables.Product;
import tables.User;
import tables.UserProduct;
//import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 03.06.16.
 */
@Repository(value = "userProduct")
@Transactional
public class UserProductImpl implements UserProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserProduct getUserProduct(int userProdId) throws SQLException {
        UserProduct userProducts = null;
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            userProducts = (UserProduct) session.get(UserProduct.class, userProdId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return userProducts;
    }



    public void editUserProduct(UserProduct userProduct) throws SQLException {
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(userProduct);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }



    public void deleteUserProduct(UserProduct userProduct) throws SQLException {
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(userProduct);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }



    public List<UserProduct> getAllUserProduct() throws SQLException {
        List<UserProduct> userProducts = null;
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            userProducts = session.createCriteria(UserProduct.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return userProducts;
    }



    public UserProduct getUsProdByUserAndProds(User user, Product product) throws SQLException {
        Session session = null;
        UserProduct userProduct = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(UserProduct.class)
                    .add(Restrictions.like("user", user))
                    .add(Restrictions.like("product", product));
            userProduct = (UserProduct) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } if ((session != null) && (session.isOpen())) {
            session.close();
        }
        return userProduct;
    }



    public List<UserProduct> getAllUserProdByUser(User user) throws SQLException {
        List<UserProduct> userProducts = null;
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(UserProduct.class).add(Restrictions.like("user", user));
            userProducts = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return userProducts;
    }


}
