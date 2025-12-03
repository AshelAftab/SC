// ---- File: MegaSystemManager.java ----
import java.time.LocalDate;


public class MegaSystemManager {
    private Settings settings;
    private LogService logService;
    private OrderService orderService;
    private UserNotifier notifier;


    public MegaSystemManager() {
        this.logService = new LogService();
        this.settings = new Settings(UserType.REGULAR, PaymentType.CASH);
        this.orderService = new OrderService(new DiscountService(), new OrderRepository(), logService);
        this.notifier = new UserNotifier();
    }


    public void loadSettings(String fileName) {
        SettingsLoader loader = new SettingsLoader();
        Settings s = loader.load(fileName);
        if (s != null) this.settings = s;
        logService.add("Settings loaded: userType=" + settings.getUserType() + " payType=" + settings.getPaymentType());
    }


    public void processOrder(OrderRequest request) {
        OrderSummary summary = orderService.process(request);
        System.out.println("Order processed for: " + summary.getUserName());
    }


    public void exportLogs(String fileName) {
        logService.export(fileName);
    }


    public void notifyUser(String user, String msg) {
        notifier.notify(user, msg);
    }


    public static void main(String[] args) {
        MegaSystemManager m = new MegaSystemManager();
        m.loadSettings("settings.conf");


        OrderRequest req = new OrderRequest(
                "Ali",
                101,
                2,
                999.99,
                "Karachi",
                true,
                "Handle carefully",
                LocalDate.of(2025, 11, 12)
        );


        m.processOrder(req);


        double discounted = new DiscountService().apply(m.settings.getUserType(), 5000);
        System.out.println("Discounted total: " + discounted);


        int shipping = new ShippingService().calculate(35);
        System.out.println("Shipping cost: " + shipping);


        m.exportLogs("logs.txt");
        m.notifyUser("Ali", "Your order has been processed successfully!");
    }
}