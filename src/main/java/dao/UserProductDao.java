package dao;

import tables.Product;
import tables.User;
import tables.UserProduct;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 03.06.16.
 */
public interface UserProductDao {

    UserProduct getUserProduct(int userProdId) throws SQLException;
    void editUserProduct(UserProduct userProduct) throws SQLException;
    void deleteUserProduct(UserProduct userProduct) throws SQLException;
    List<UserProduct> getAllUserProduct() throws SQLException;
    UserProduct getUsProdByUserAndProds(User user, Product product) throws SQLException;
    List<UserProduct> getAllUserProdByUser(User user) throws SQLException;

}
