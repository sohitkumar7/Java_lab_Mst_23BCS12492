import java.util.*;

// Custom Exception for Employee not found
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

public class EmployeeMapApp {
    private Map<Integer, String> employeeMap = new HashMap<>();

    // 1. Add an employee
    public void addEmployee(int id, String name) {
        employeeMap.put(id, name);
    }

    // 2. Retrieve employee name by ID (throws exception if not found)
    public String getEmployeeName(int id) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Error: Employee ID not found!");
        }
        return employeeMap.get(id);
    }

    // 3. Display all employees
    public void displayEmployees() {
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Main Method
    public static void main(String[] args) {
        EmployeeMapApp app = new EmployeeMapApp();

        System.out.println("Adding employees...");
        app.addEmployee(101, "John");
        app.addEmployee(102, "Jane");
        app.addEmployee(103, "Mike");

        // Show full map
        System.out.println("Employee Map: " + app.employeeMap);

        try {
            // Valid ID
            System.out.println("Name for ID 102: " + app.getEmployeeName(102));

            // Invalid ID
            System.out.println("Name for ID 999: " + app.getEmployeeName(999));
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
