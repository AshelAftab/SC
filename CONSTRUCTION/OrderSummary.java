import java.time.LocalDate;


public class OrderSummary {
    private final String userName;
    private final int productId;
    private final int quantity;
    private final double total;
    private final LocalDate orderDate;


    public OrderSummary(String userName, int productId, int quantity, double total, LocalDate orderDate) {
        this.userName = userName;
        this.productId = productId;
        this.quantity = quantity;
        this.total = total;
        this.orderDate = orderDate;
    }


    public String getUserName() { return userName; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getTotal() { return total; }
    public LocalDate getOrderDate() { return orderDate; }
}
