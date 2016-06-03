package dao;

import tables.Order;

import java.sql.SQLException;

/**
 * Created by nikita on 03.06.16.
 */
public interface OrderDao {

    Order getOrderById(int orderId) throws SQLException;
    void addOrder(Order order) throws SQLException;

}
