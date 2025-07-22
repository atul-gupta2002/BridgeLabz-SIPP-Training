import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


abstract class CourseType {
    String courseName;
    CourseType(String courseName) {
        this.courseName = courseName;
    }
    abstract void evaluationMethod();
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName) {
        super(courseName);
    }
    @Override
    void evaluationMethod() {
        System.out.println(courseName + " evaluated through Exams.");
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName) {
        super(courseName);
    }
    @Override
    void evaluationMethod() {
        System.out.println(courseName + " evaluated through Assignments.");
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName) {
        super(courseName);
    }
    @Override
    void evaluationMethod() {
        System.out.println(courseName + " evaluated through Research Papers.");
    }
}

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    void addCourse(T course) {
        courses.add(course);
    }

    void displayCourses() {
        for (T course : courses) {
            course.evaluationMethod();
        }
    }

    static void displayAllCourses(List<? extends CourseType> courseList) {
        for (CourseType course : courseList) {
            course.evaluationMethod();
        }
    }
}

public class MultiLevelUniversityCourseManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics"));
        examCourses.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("History"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("Artificial Intelligence"));

        System.out.println("Displaying Exam Courses:");
        examCourses.displayCourses();

        System.out.println("\nDisplaying Assignment Courses:");
        assignmentCourses.displayCourses();

        System.out.println("\nDisplaying All Courses with Wildcards:");
        List<CourseType> allCourses = Arrays.asList(
                new ExamCourse("Chemistry"),
                new AssignmentCourse("Sociology"),
                new ResearchCourse("Data Science")
        );
        Course.displayAllCourses(allCourses);
    }
}
