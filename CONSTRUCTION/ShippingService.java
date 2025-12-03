public class ShippingService {
    private static final int ZONE_NEAR = 50;
    private static final int ZONE_MEDIUM = 100;


    public int calculate(int distance) {
        if (distance < 10) return 50;
        if (distance < ZONE_NEAR) return 100;
        if (distance < ZONE_MEDIUM) return 150;
        return 200;
    }
}