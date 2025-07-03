package assistedProblems;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: $" + salary);
    }
}
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
class Intern extends Employee {
    String schoolName;

    Intern(String name, int id, double salary, String schoolName) {
        super(name, id, salary);
        this.schoolName = schoolName;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("School Name: " + schoolName);
    }
}

public class EmployeeManagementTest {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 1001, 90000, 5);
        Employee developer = new Developer("Bob", 1002, 75000, "Java");
        Employee intern = new Intern("Charlie", 1003, 20000, "ABC University");

        Employee[] employees = {manager, developer, intern};
        for (Employee emp : employees) {
            System.out.println("----- Employee Details -----");
            emp.displayDetails();
            System.out.println();
        }
    }
}

