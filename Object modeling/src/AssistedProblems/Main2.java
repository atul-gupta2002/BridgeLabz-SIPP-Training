package AssistedProblems;

import java.util.ArrayList;

// Employee class - Only exists within a Department
class Employee {
    public String name;
    public String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void showDetails() {
        System.out.println("Employee Name: " + name + ", Role: " + role);
    }
}

// Department class - Only exists within a Company
class Department {
    public String name;
    public ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void showDepartment() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            emp.showDetails();
        }
    }
}

// Company class - Composes Departments and Employees
class Company {
    public String companyName;
    public ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName, String role) {
        for (Department dept : departments) {
            if (deptName.equals(dept.name)) {
                dept.addEmployee(empName, role);
                return;
            }
        }
        System.out.println("Department not found: " + deptName);
    }

    public void showCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.showDepartment();
            System.out.println();
        }
    }

    public void deleteCompany() {
        departments.clear();  // All departments and employees are lost with the company
        System.out.println("Company '" + companyName + "' and all its departments/employees are deleted.");
    }
}

// Main class
public class Main2 {
    public static void main(String[] args) {
        Company techCorp = new Company("TechCorp");

        techCorp.addDepartment("Engineering");
        techCorp.addDepartment("HR");

        techCorp.addEmployeeToDepartment("Engineering", "Alice", "Software Engineer");
        techCorp.addEmployeeToDepartment("Engineering", "Bob", "DevOps Engineer");
        techCorp.addEmployeeToDepartment("HR", "Charlie", "HR Manager");

        // Display full company structure
        techCorp.showCompanyStructure();

        // Deleting the company
        techCorp.deleteCompany();
    }
}

