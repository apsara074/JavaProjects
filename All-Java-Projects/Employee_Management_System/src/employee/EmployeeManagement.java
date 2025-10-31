package employee;

import exception.CustomException;
import department.Department;
import employee.Employee;

import java.util.*;

public class EmployeeManagement {
    private static Scanner sc = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            menu();
            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1: addEmployee(); break;
                    case 2: showEmployees(); break;
                    case 3: updateSalary(); break;
                    case 0: run = false; break;
                    default: System.out.println("Invalid choice.");
                }
            } catch (CustomException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void menu() {
        System.out.println("\n--- Employee Menu ---");
        System.out.println("1. Add Employee");
        System.out.println("2. Show Employees");
        System.out.println("3. Update Salary");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    private static void addEmployee() throws CustomException {
        System.out.print("Name: ");
        String n = sc.nextLine();

        System.out.print("Department ID: ");
        String did = sc.nextLine();
        System.out.print("Department Name: ");
        String dname = sc.nextLine();
        Department dept = new Department(did, dname);

        System.out.print("Salary: ");
        double s = sc.nextDouble();
        sc.nextLine();

        Employee e = new Employee(n, dept, s);
        employees.add(e);
        System.out.println("Added: " + e);
    }

    private static void showEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }

    private static void updateSalary() throws CustomException {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        for (Employee e : employees) {
            if (e.getEmpId().equalsIgnoreCase(id)) {
                System.out.print("New Salary: ");
                double ns = sc.nextDouble();
                sc.nextLine();
                e.updateSalary(ns);
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
/* --- Employee Menu ---
1. Add Employee
2. Show Employees
3. Update Salary
0. Exit
Choice: 1
Name: Apsara
Department ID: IT
Department Name: Information Technology
Salary: 30000
Added: Employee{id='EMP1001', name='Apsara', dept=Information Technology, salary=30000.0}

--- Employee Menu ---
1. Add Employee
2. Show Employees
3. Update Salary
0. Exit
Choice: 2
Employee{id='EMP1001', name='Apsara', dept=Information Technology, salary=30000.0}
 */