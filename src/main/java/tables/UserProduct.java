package tables;

import javax.persistence.*;

/**
 * Created by nikita on 03.06.16.
 */
@Entity
@Table(name = "user_product")
public class UserProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_prod_id")
    private int userProdId;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "bought_quantity")
    private int boughtQuantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    public UserProduct() {

    }


    public int getUserProdId() {
        return userProdId;
    }

    public void setUserProdId(int userProdId) {
        this.userProdId = userProdId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setBoughtQuantity(int boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
