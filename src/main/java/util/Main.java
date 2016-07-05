package util;

import dao.OrderDao;
import dao.ProductDao;
import dao.UserDao;
import dao.UserProductDao;
//import factory.Factory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tables.Order;
import tables.Product;
import tables.User;
import tables.UserProduct;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikita on 03.06.16.
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
        ProductDao productDao = applicationContext.getBean("productDao", ProductDao.class);
        UserProductDao userProductDao = applicationContext.getBean("userProduct", UserProductDao.class);
//
////        User user = userDao.getUserById(4);
////        user.setLoginEmail("logmail@logmail.com");
////        userDao.editUser(user);
//
//
//
        User user = userDao.getUserById(3);
        Product product = productDao.getProducById(3);

//        System.out.println(user.getLoginEmail());
//        System.out.println(product.getMpn());

        UserProduct userProduct = new UserProduct();
        userProduct.setUser(user);
        userProduct.setProduct(product);
        userProduct.setBoughtQuantity(777);

        user.getUserProducts().add(userProduct);
        product.getUserProducts().add(userProduct);

        userDao.editUser(user);
        productDao.editProduct(product);







//        User user = userDao.getUserById(1);
//        System.out.println(user.getFirstName());

//        List<User> users = userDao.getAllUsers();
//        for (User user : users) {
//            System.out.println(user.getFirstName() + " " + user.getLastName());
//        }


//        HibernateUtil.getSessionFactory();
//
//        Factory factory = Factory.getInstance();
//        UserDao userDao = factory.getUserDao();
//        ProductDao productDao = factory.getProductDao();
//        OrderDao orderDao = factory.getOrderDao();
//        UserProductDao userProductDao = factory.getUserProductDao();
//
//        User user = userDao.getUserById(3);
//        Product product = productDao.getProducById(3);
//
////        System.out.println(user.getLoginEmail());
////        System.out.println(product.getMpn());
//
//        UserProduct userProduct = new UserProduct();
//        userProduct.setUser(user);
//        userProduct.setProduct(product);
//        userProduct.setBoughtQuantity(777);
//
//        user.getUserProducts().add(userProduct);
//        product.getUserProducts().add(userProduct);
//
//        userDao.editUser(user);
//        productDao.editProduct(product);

//
//
//        User user = userDao.getUserById(1);
//        List<UserProduct>userProducts = userProductDao.getAllUserProdByUser(user);
//        Order order = new Order();
//        order.setUserProducts(userProducts);
//        orderDao.addOrder(order);
//        for (UserProduct userProduct : userProducts) {
//            userProduct.setOrder(order);
//            userProductDao.editUserProduct(userProduct);
//        }



//        User user = userDao.getUserById(1);
//        Product product = productDao.getProducById(2);
//
//        UserProduct userProduct = new UserProduct();
//        userProduct.setProduct(product);
//        userProduct.setUser(user);
//        userProduct.setBoughtQuantity(4);
//
//        user.getUserProducts().add(userProduct);
//        product.getUserProducts().add(userProduct);
//
//        userDao.editUser(user);
//        productDao.editProduct(product);






//        User user = new User();
//        user.setFirstName("Adam");
//        user.setLastName("Smith");
//        user.setAge(23);
//        user.setLoginEmail("adam_smith@gmail.com");
//        user.setPassword("adam_smith");
//        userDao.addUser(user);
//
//        User user1 = new User();
//        user1.setFirstName("Kevin");
//        user1.setLastName("Gallow");
//        user1.setAge(43);
//        user1.setLoginEmail("kevin_gallow@gmail.com");
//        user1.setPassword("kevin_gallow");
//        userDao.addUser(user1);
//
//        User user2 = new User();
//        user2.setFirstName("John");
//        user2.setLastName("Doe");
//        user2.setAge(56);
//        user2.setLoginEmail("john_doe@gmail.com");
//        user2.setPassword("john_doe");
//        userDao.addUser(user2);
//
//
//        Product product = new Product();
//        product.setBrand("Lenovo");
//        product.setModel("FG-45");
//        product.setMpn(32435);
//        product.setStock(1000);
//        productDao.addProduct(product);
//
//        Product product1 = new Product();
//        product1.setBrand("Asus");
//        product1.setModel("HB.3S");
//        product1.setMpn(5436);
//        product1.setStock(800);
//        productDao.addProduct(product1);
//
//        Product product2 = new Product();
//        product2.setBrand("LG");
//        product2.setModel("AQW5-&8");
//        product2.setMpn(320035);
//        product2.setStock(4000);
//        productDao.addProduct(product2);

    }

}
