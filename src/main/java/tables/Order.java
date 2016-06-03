package tables;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikita on 03.06.16.
 */
@Entity
@Table(name = "order_last")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @OneToMany(mappedBy = "order")
    private List<UserProduct>userProducts = new ArrayList<UserProduct>();

    public Order() {

    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<UserProduct> getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(List<UserProduct> userProducts) {
        this.userProducts = userProducts;
    }
}
