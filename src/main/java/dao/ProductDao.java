package dao;

import tables.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 03.06.16.
 */
public interface ProductDao {

    void addProduct(Product product) throws SQLException;
    void editProduct(Product product) throws SQLException;
    Product getProducById(int productId) throws SQLException;
    List<Product> getAllProducts() throws SQLException;

}
