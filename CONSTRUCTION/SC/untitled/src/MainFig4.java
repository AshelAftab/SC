// Shipping interface
interface Shipping {
    double getCost(Order order);
    String getDate(Order order);
}

// Concrete shipping types
class Ground implements Shipping {
    @Override
    public double getCost(Order order) {
        if (order.getTotal() > 100) return 0;
        return Math.max(10, order.getTotalWeight() * 1.5);
    }

    @Override
    public String getDate(Order order) {
        return "3-5 business days";
    }
}

class Air implements Shipping {
    @Override
    public double getCost(Order order) {
        return order.getTotalWeight() * 3.0;
    }

    @Override
    public String getDate(Order order) {
        return "1-2 business days";
    }
}

// Order class using composition (Strategy Pattern)
class Order {
    private double total;
    private double totalWeight;
    private Shipping shipping;

    public Order(double total, double totalWeight, Shipping shipping) {
        this.total = total;
        this.totalWeight = totalWeight;
        this.shipping = shipping;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public double getShippingCost() {
        return shipping.getCost(this);
    }

    public String getShippingDate() {
        return shipping.getDate(this);
    }
}

public class MainFig4 {
    public static void main(String[] args) {
        Order groundOrder = new Order(80, 5, new Ground());
        System.out.println("Ground Shipping Cost: " + groundOrder.getShippingCost());
        System.out.println("Delivery Time: " + groundOrder.getShippingDate());

        Order airOrder = new Order(120, 3, new Air());
        System.out.println("\nAir Shipping Cost: " + airOrder.getShippingCost());
        System.out.println("Delivery Time: " + airOrder.getShippingDate());
    }
}
