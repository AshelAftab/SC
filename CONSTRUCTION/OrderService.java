import java.time.LocalDate;


public class OrderService {
    private final DiscountService discountService;
    private final OrderRepository orderRepository;
    private final LogService logService;


    public OrderService(DiscountService discountService, OrderRepository orderRepository, LogService logService) {
        this.discountService = discountService;
        this.orderRepository = orderRepository;
        this.logService = logService;
    }


    public OrderSummary process(OrderRequest request) {
        logService.add("Start:" + request.getUserName());


        int qty = adjustQuantityForUrgency(request.getQuantity(), request.isUrgent());
        validateOrder(qty, request.getPrice());


        double subtotal = calculateTotal(qty, request.getPrice());
        double afterDiscount = discountService.apply(UserType.REGULAR, subtotal);


        OrderSummary summary = new OrderSummary(request.getUserName(), request.getProductId(), qty, afterDiscount, request.getDate());
        orderRepository.save(summary);
        printReport(summary);
        logService.add("End:" + request.getUserName());
        return summary;
    }


    private double calculateTotal(int qty, double price) {
        final int FIXED_A = 10;
        final int FIXED_B = 20;
        return qty * price + FIXED_A + FIXED_B;
    }


    private int adjustQuantityForUrgency(int qty, boolean urgent) {
        return urgent ? qty + 1 : qty;
    }


    private void validateOrder(int qty, double price) {
        if (qty <= 0 || price <= 0) throw new IllegalArgumentException("Invalid quantity or price");
    }


    private void printReport(OrderSummary summary) {
        System.out.println("----- ORDER REPORT -----");
        System.out.println("User: " + summary.getUserName());
        System.out.println("Product: " + summary.getProductId());
        System.out.println("Quantity: " + summary.getQuantity());
        System.out.println("Total: " + summary.getTotal());
        System.out.println("Date: " + summary.getOrderDate());
        System.out.println("----- ORDER SUMMARY -----");
        System.out.println("User: " + summary.getUserName());
        System.out.println("Total: " + summary.getTotal());
    }
}