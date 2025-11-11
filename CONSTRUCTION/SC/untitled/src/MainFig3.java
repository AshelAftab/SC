import java.util.*;

// Employee interface
interface Employee {
    void doWork();
}

// Concrete employees
class Designer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Designer designing graphics...");
    }
}

class Programmer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Programmer writing code...");
    }
}

class Tester implements Employee {
    @Override
    public void doWork() {
        System.out.println("Tester testing the software...");
    }
}

class Artist implements Employee {
    @Override
    public void doWork() {
        System.out.println("Artist creating game assets...");
    }
}

// Base Company class
abstract class Company {
    public abstract List<Employee> getEmployees();

    public void createSoftware() {
        for (Employee e : getEmployees()) {
            e.doWork();
        }
    }
}

// Concrete companies
class GameDevCompany extends Company {
    @Override
    public List<Employee> getEmployees() {
        return Arrays.asList(new Designer(), new Artist());
    }
}

class OutsourcingCompany extends Company {
    @Override
    public List<Employee> getEmployees() {
        return Arrays.asList(new Programmer(), new Tester());
    }
}

public class MainFig3 {
    public static void main(String[] args) {
        Company gameDev = new GameDevCompany();
        System.out.println("GameDev Company creating software:");
        gameDev.createSoftware();

        Company outsource = new OutsourcingCompany();
        System.out.println("\nOutsourcing Company creating software:");
        outsource.createSoftware();
    }
}
