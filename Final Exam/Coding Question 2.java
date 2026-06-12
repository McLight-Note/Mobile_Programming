public class Student {
    int id;
    String name;
    double gpa;

    Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | GPA: " + gpa);
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Muhammad", 3.8);
        Student s2 = new Student(2, "Ali", 3.5);
        Student s3 = new Student(3, "Sara", 3.9);

        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();
    }
}
