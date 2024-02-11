import java.util.List;

public class ResponseOrderList {
    private List<ResponseOrder> orders;

    public ResponseOrderList(List<ResponseOrder> orders) {
        this.orders = orders;
    }

    public ResponseOrderList() {
    }

    public List<ResponseOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ResponseOrder> orders) {
        this.orders = orders;
    }
}
