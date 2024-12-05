import java.util.ArrayList;

// Abstract Employee class
abstract class Employee {
    protected int id;
    protected String name;
    protected String department;
    
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public abstract void displayDetails();
}

// Developer class
class Developer extends Employee {
    private String programmingLanguage;
    
    public Developer(int id, String name, String department, String programmingLanguage) {
        super(id, name, department);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Role: Developer, Programming Language: " + programmingLanguage);
    }
}

// Tester class
class Tester extends Employee {
    private String testingTool;
    
    public Tester(int id, String name, String department, String testingTool) {
        super(id, name, department);
        this.testingTool = testingTool;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Role: Tester, Testing Tool: " + testingTool);
    }
}

// SoftwareEngineer class
class SoftwareEngineer extends Employee {
    private ArrayList<Developer> developers = new ArrayList<>();
    private ArrayList<Tester> testers = new ArrayList<>();

    public SoftwareEngineer(int id, String name) {
        super(id, name, "Software");
    }

    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }

    public void addTester(Tester tester) {
        testers.add(tester);
    }

    @Override
    public void displayDetails() {
        System.out.println("Software Engineer Lead: " + name);
        
        System.out.println("=== Developers ===");
        for (Developer d : developers) {
            d.displayDetails();
        }
        
        System.out.println("=== Testers ===");
        for (Tester t : testers) {
            t.displayDetails();
        }
    }
}

// HardwareEngineer class
class HardwareEngineer extends Employee {
    private ArrayList<Developer> developers = new ArrayList<>();
    private ArrayList<Tester> testers = new ArrayList<>();

    public HardwareEngineer(int id, String name) {
        super(id, name, "Hardware");
    }

    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }

    public void addTester(Tester tester) {
        testers.add(tester);
    }

    @Override
    public void displayDetails() {
        System.out.println("Hardware Engineer Lead: " + name);

        System.out.println("=== Developers ===");
        for (Developer d : developers) {
            d.displayDetails();
        }

        System.out.println("=== Testers ===");
        for (Tester t : testers) {
            t.displayDetails();
        }
    }
}

// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating a software engineer and adding employees
        SoftwareEngineer softwareLead = new SoftwareEngineer(1, "Alice");
        softwareLead.addDeveloper(new Developer(2, "Bob", "Software", "Java"));
        softwareLead.addDeveloper(new Developer(3, "Tom", "Software", "Python"));
        softwareLead.addTester(new Tester(4, "Charlie", "Software", "Selenium"));
        softwareLead.addTester(new Tester(5, "Eve", "Software", "JUnit"));

        // Creating a hardware engineer and adding employees
        HardwareEngineer hardwareLead = new HardwareEngineer(6, "David");
        hardwareLead.addDeveloper(new Developer(7, "Frank", "Hardware", "C++"));
        hardwareLead.addTester(new Tester(8, "Grace", "Hardware", "JMeter"));

        // Display employee details
        softwareLead.displayDetails();
        System.out.println();  // Blank line for separation
        hardwareLead.displayDetails();
    }
}
