package hierarchicalInhertance;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role: Teacher");
        displayPersonInfo();
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role: Student");
        displayPersonInfo();
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        System.out.println("Role: Staff");
        displayPersonInfo();
        System.out.println("Department: " + department);
    }
}
public class SchoolSystemDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Aarav", 15, 10);
        Staff staff = new Staff("Ms. Meena", 35, "Administration");

        System.out.println("---- TEACHER ----");
        teacher.displayRole();

        System.out.println("\n---- STUDENT ----");
        student.displayRole();

        System.out.println("\n---- STAFF ----");
        staff.displayRole();
    }
}
