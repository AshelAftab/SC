import java.io.FileWriter;
import java.io.IOException;


public class OrderRepository {
    private final String fileName = "order_data.txt";


    public void save(OrderSummary summary) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write("U:" + summary.getUserName() + " P:" + summary.getProductId() + " T:" + summary.getTotal() + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
    }
}