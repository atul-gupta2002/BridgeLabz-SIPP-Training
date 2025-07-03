package multiLevelInheritance;

class Course {
    String courseName;
    int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    public void displayOnlineCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // in percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public void displayPaidCourseInfo() {
        super.displayOnlineCourseInfo();
        System.out.println("Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Effective Fee after Discount: ₹" + getDiscountedFee());
    }

    public double getDiscountedFee() {
        return fee - (fee * discount / 100);
    }
}
public class CourseDemo {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Programming", 8, "Udemy", true, 4999.0, 20.0);
        course.displayPaidCourseInfo();
    }
}

