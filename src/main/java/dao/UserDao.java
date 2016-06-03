package dao;

import tables.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 03.06.16.
 */
public interface UserDao {

    void addUser(User user) throws SQLException;
    void editUser(User user) throws SQLException;
    User getUserById(int userId) throws SQLException;
    List<User> getAllUsers() throws SQLException;

}
