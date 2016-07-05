//package factory;
//
//import dao.OrderDao;
//import dao.ProductDao;
//import dao.UserDao;
//import dao.UserProductDao;
//import daoImpl.OrderDaoImpl;
//import daoImpl.ProductDaoImpl;
//import daoImpl.UserDaoImpl;
//import daoImpl.UserProductImpl;
//
///**
// * Created by nikita on 03.06.16.
// */
//public class Factory {
//
//    private static Factory instance = null;
//    private static UserDao userDao = null;
//    private static ProductDao productDao = null;
//    private static OrderDao orderDao = null;
//    private static UserProductDao userProductDao = null;
//
//
//    public static synchronized Factory getInstance() {
//        if (instance == null) {
//            instance = new Factory();
//        }
//        return instance;
//    }
//
//
//    public static synchronized UserDao getUserDao() {
//        if (userDao == null) {
//            userDao = new UserDaoImpl();
//        }
//        return userDao;
//    }
//
//
//    public static synchronized ProductDao getProductDao() {
//        if (productDao == null) {
//            productDao = new ProductDaoImpl();
//        }
//        return productDao;
//    }
//
//
//    public static synchronized OrderDao getOrderDao() {
//        if (orderDao == null) {
//            orderDao = new OrderDaoImpl();
//        }
//        return orderDao;
//    }
//
//
//    public static synchronized UserProductDao getUserProductDao() {
//        if (userProductDao == null) {
//            userProductDao = new UserProductImpl();
//        }
//        return userProductDao;
//    }
//
//}
