import java.time.LocalDate;


public class OrderRequest {
    private final String userName;
    private final int productId;
    private final int quantity;
    private final double price;
    private final String address;
    private final boolean urgent;
    private final String notes;
    private final LocalDate date;


    public OrderRequest(String userName, int productId, int quantity, double price, String address, boolean urgent, String notes, LocalDate date) {
        this.userName = userName;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.address = address;
        this.urgent = urgent;
        this.notes = notes;
        this.date = date;
    }


    public String getUserName() { return userName; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getAddress() { return address; }
    public boolean isUrgent() { return urgent; }
    public String getNotes() { return notes; }
    public LocalDate getDate() { return date; }
}