package daoImpl;

import dao.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tables.Product;
//import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 03.06.16.
 */
@Repository(value = "productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProduct(Product product) throws SQLException {
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }



    public void editProduct(Product product) throws SQLException {
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }



    public Product getProducById(int productId) throws SQLException {
        Product product = null;
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            product = (Product) session.get(Product.class, productId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return product;
    }



    public List<Product> getAllProducts() throws SQLException {
        List<Product>products = null;
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            products = session.createCriteria(Product.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return products;
    }
}
