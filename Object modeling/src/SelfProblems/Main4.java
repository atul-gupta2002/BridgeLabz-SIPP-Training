package SelfProblems;

import java.util.*;

// Faculty class - Aggregated by University, can exist independently
class Faculty {
    private String name;
    private String subject;

    public Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void showDetails() {
        System.out.println("Faculty Name: " + name + ", Subject: " + subject);
    }
}

// Department class - Composed within a University (can't exist without University)
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public void showDepartment() {
        System.out.println("Department: " + name);
    }
}

// University class - Composes Departments and Aggregates Faculty
class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Composition: departments are created inside university
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Aggregation: faculty exists independently and is added to university
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showUniversityStructure() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.showDepartment();
        }
        System.out.println("Faculties:");
        for (Faculty fac : faculties) {
            fac.showDetails();
        }
        System.out.println();
    }

    // Simulate deletion of university (composition effect)
    public void deleteUniversity() {
        departments.clear();  // composed departments are deleted
        faculties.clear();    // aggregated faculties can also be cleared from university
        System.out.println("University '" + name + "' deleted along with all departments.");
    }
}

// Main class
public class Main4 {
    public static void main(String[] args) {
        // Create faculty members (can exist independently)
        Faculty f1 = new Faculty("Dr. Alice", "Physics");
        Faculty f2 = new Faculty("Dr. Bob", "Mathematics");

        // Create university
        University uni = new University("National University");

        // Add departments (Composition)
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical Engineering");

        // Add faculty members (Aggregation)
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        // Show full structure
        uni.showUniversityStructure();

        // Delete university
        uni.deleteUniversity();

        // Faculty still exists independently
        System.out.println("\nFaculty still exists independently:");
        f1.showDetails();
        f2.showDetails();
    }
}

