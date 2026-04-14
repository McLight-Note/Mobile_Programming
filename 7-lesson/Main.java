import java.util.ArrayList;

class Student {
    private int studentId;
    private String studentName;
    private double gradePointAverage;

    public Student(int studentId, String studentName, double gradePointAverage) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gradePointAverage = gradePointAverage;
    }

    public int getId() {
        return studentId;
    }

    public String getName() {
        return studentName;
    }

    public double getGpa() {
        return gradePointAverage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ", name='" + studentName + '\'' +
                ", gpa=" + gradePointAverage +
                '}';
    }
}

class Course {
    private String courseTitle;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseTitle) {
        this.courseTitle = courseTitle;
        this.enrolledStudents = new ArrayList<>();
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println("Student " + student.getName() + " added to " + courseTitle);
    }

    public void removeStudent(int studentId) {
        for (int index = 0; index < enrolledStudents.size(); index++) {
            if (enrolledStudents.get(index).getId() == studentId) {
                System.out.println("Student " + enrolledStudents.get(index).getName() + " removed from " + courseTitle);
                enrolledStudents.remove(index);
                return;
            }
        }
        System.out.println("Student with id " + studentId + " not found");
    }

    public void printAllStudents() {
        System.out.println("\n=== Students in " + courseTitle + " ===");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println(student);
            }
        }
    }

    public String getCourseTitle() {
        return courseTitle;
    }
}

public class Main {
    public static void main(String[] args) {
        Course javaProgrammingCourse = new Course("Java Programming");

        Student student1 = new Student(101, "Alice Johnson", 3.8);
        Student student2 = new Student(102, "Bob Smith", 3.5);
        Student student3 = new Student(103, "Charlie Brown", 3.9);

        javaProgrammingCourse.addStudent(student1);
        javaProgrammingCourse.addStudent(student2);
        javaProgrammingCourse.addStudent(student3);

        javaProgrammingCourse.printAllStudents();

        javaProgrammingCourse.removeStudent(102);

        javaProgrammingCourse.printAllStudents();

        javaProgrammingCourse.removeStudent(999);
    }
}
