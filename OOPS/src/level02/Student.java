package level02;

public class Student {
    String Name;
    int rollNo;
    double marks;

    Student(String Name,int rollNo,double marks){
        this.Name=Name;
        this.rollNo=rollNo;
        this.marks=marks;
    }
    void Grades(int marks){
        if(marks>=90){
            System.out.println("Grade is :"+"A");
        }else if(marks>=80 && marks<90){
            System.out.println("Grade is :"+"B");
        }else if(marks>=70 && marks<80){
            System.out.println("Grade is :"+"C");
        }else{
            System.out.println("Not satisfactory marks !");
        }
    }
    void Display(){
        System.out.println("Student's name is : "+Name);
        System.out.println("Student's rollNo is : "+rollNo);
        System.out.println("Student's marks is : " +marks);

    }

    public static void main(String[] args) {
        Student st = new Student("Atul Gupta",15,95);
        st.Display();
    }
}
