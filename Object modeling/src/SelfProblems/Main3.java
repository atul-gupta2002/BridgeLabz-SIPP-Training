package SelfProblems;

import java.util.*;

// Course class - associated with many students
class Course1 {
    private String name;
    private List<Student> enrolledStudents;

    public Course1(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this);  // maintain bidirectional link
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + name + " - Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("• " + s.getName());
        }
        System.out.println();
    }
}

// Student class - aggregated by School, associated with many courses
class Student {
    private String name;
    private List<Course1> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course1 course) {
        course.enrollStudent(this);  // enroll through Course to maintain bidirectional association
    }

    protected void addCourse(Course1 course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    public void showCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course1 c : enrolledCourses) {
            System.out.println("• " + c.getName());
        }
        System.out.println();
    }
}

// School class - aggregates students
class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void admitStudent(Student student) {
        students.add(student);  // aggregation: student exists outside but is part of this school
    }

    public void showStudents() {
        System.out.println("School: " + name + " - Students:");
        for (Student s : students) {
            System.out.println("• " + s.getName());
        }
        System.out.println();
    }
}

// Main class to demonstrate everything
public class Main3 {
    public static void main(String[] args) {
        // Create school
        School school = new School("Green Valley High School");

        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Admit students to school (Aggregation)
        school.admitStudent(alice);
        school.admitStudent(bob);

        // Create courses
        Course1 math = new Course1("Mathematics");
        Course1 science = new Course1("Science");
        Course1 history = new Course1("History");

        // Students enroll in courses (Association)
        alice.enrollInCourse(math);
        alice.enrollInCourse(science);

        bob.enrollInCourse(science);
        bob.enrollInCourse(history);

        // Display structure
        school.showStudents();

        alice.showCourses();
        bob.showCourses();

        math.showEnrolledStudents();
        science.showEnrolledStudents();
        history.showEnrolledStudents();
    }
}

