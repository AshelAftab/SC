// Engine interface
interface Engine {
    void move();
}

// Driver interface
interface Driver {
    void navigate();
}

// Concrete engines
class CombustionEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Combustion engine moving...");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Electric engine moving silently...");
    }
}

// Concrete drivers
class Robot implements Driver {
    @Override
    public void navigate() {
        System.out.println("Robot driver navigating via sensors...");
    }
}

class Human implements Driver {
    @Override
    public void navigate() {
        System.out.println("Human driver navigating manually...");
    }
}

// Transport class using composition
class Transport {
    private Engine engine;
    private Driver driver;

    public Transport(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    public void deliver(String destination, String cargo) {
        System.out.println("Delivering " + cargo + " to " + destination);
        engine.move();
        driver.navigate();
    }
}

public class MainFig2 {
    public static void main(String[] args) {
        Transport truck = new Transport(new CombustionEngine(), new Human());
        truck.deliver("Warehouse", "Furniture");

        Transport drone = new Transport(new ElectricEngine(), new Robot());
        drone.deliver("Downtown", "Package");
    }
}

