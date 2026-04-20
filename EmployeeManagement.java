import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class EmployeeManagement {
    static ArrayList<Employee> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Employee
    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        list.add(new Employee(id, name, salary));
        System.out.println("✅ Employee Added!");
    }

    // View Employees
    static void viewEmployees() {
        if (list.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee e : list) {
            System.out.println("ID: " + e.id +
                    ", Name: " + e.name +
                    ", Salary: " + e.salary);
        }
    }

    // Search Employee
    static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Employee e : list) {
            if (e.id == id) {
                System.out.println("✅ Found: " +
                        e.id + ", " + e.name + ", " + e.salary);
                return;
            }
        }
        System.out.println("❌ Employee not found.");
    }

    // Delete Employee
    static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.id == id) {
                it.remove();
                System.out.println("🗑️ Employee Deleted!");
                return;
            }
        }
        System.out.println("❌ Employee not found.");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Employee Menu =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
