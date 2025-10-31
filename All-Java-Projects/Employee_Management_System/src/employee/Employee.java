package employee;

import exception.CustomException;
import department.Department;

public class Employee {
    private static int counter = 1;

    private String empId;
    private String name;
    private Department department;  // Now department is an object
    private double salary;

    public Employee(String name, Department dept, double salary) throws CustomException {
        if (name.length() < 3) throw new CustomException("Name must have at least 3 characters.");
        if (salary < 10000) throw new CustomException("Salary must be at least 10000.");

        this.empId = "EMP" + (1000 + counter++);
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    public String getEmpId() { return empId; }
    public String getName() { return name; }
    public Department getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void updateSalary(double newSalary) throws CustomException {
        if (newSalary < 10000) throw new CustomException("Salary cannot be less than 10000.");
        this.salary = newSalary;
        System.out.println("Salary updated for " + name + ". New Salary = " + salary);
    }

    @Override
    public String toString() {
        return "Employee{id='" + empId + "', name='" + name + "', dept=" + department.getDeptName() + ", salary=" + salary + "}";
    }
}
