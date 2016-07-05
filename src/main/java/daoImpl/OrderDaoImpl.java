package daoImpl;

import dao.OrderDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tables.Order;
//import util.HibernateUtil;

import java.sql.SQLException;

/**
 * Created by nikita on 03.06.16.
 */
@Repository(value = "orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Order getOrderById(int orderId) throws SQLException {
        Order order = null;
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            order = (Order) session.get(Order.class, orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return order;
    }



    public void addOrder(Order order) throws SQLException {
        Session session = null;
        try {
            //session = HibernateUtil.getSessionFactory().openSession();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }
}
