import java.util.Scanner;
import java.util.ArrayList;

class Person {

    private String name;
    private int age;

    public void setdetails(String n, int a) {

        this.name = n;
        this.age = a;
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    public void displayDetails() {

        System.out.println("Name is; " + name);
        System.out.println("Age is " + age);
    }

}

class Teacher extends Person {

    private String subject;
    private double salary;

    public void teachsubject(String s) {

        this.subject = s;
    }

    public void setSalary(double sal) {

        this.salary = sal;

    }

    public void displayTeachers() {

        System.out.println(
                " name : " + getname() + " Age : " + getage() + " Subject : " + subject + " salary : $" + salary);
    }

}

class Student extends Person {

    private int rollnum;
    private int marks[] = new int[5];
    private String grade;
    int totalmarks;
    double percent;

    public void setroll(int n) {
        rollnum = n;

    }

    public void cal_total_marks(int[] m) {
        
        totalmarks = 0;
        percent = 0;

        marks = m;

        for (int i : marks) {
            totalmarks += i;

        }
        percent = ((double) totalmarks / 100) * 100;

    }

    public double getTotalMarks() {
        return percent;
    }

    public void displaystudent() {

        System.out.println(" Name : " + getname() + " Age : " + getage() + " Marks : " + " S1 - " + marks[0] + " S2 - "
                + marks[1] + " S3 - " + marks[2] + " S4 - " + marks[3] + " S5 - " + marks[4]);

    }

    public void cal_Grades() {

        if (percent >= 90) {
            grade = "A";

            System.out.println(getname() + " your grade is " + grade);

        } else if (percent >= 70 && percent <= 89) {
            grade = "B";
            System.out.println(getname() + " your grade is " + grade);

        } else if (percent > 40 && percent <= 69) {
            grade = "C";
            System.out.println(getname() + " Your Grade is " + grade);
        } else {
            grade = "F";
            System.out.println(getname() + " You are failed in exam Dont worry keep trying.. Your Grade is: " + grade);
        }

    }

}

public class School_mngmnt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Teacher> Teachers = new ArrayList<>();
        ArrayList<Student> Students = new ArrayList<>();

        int choice;

        while (true) {

            try {
                System.out.println(
                        "\n Welcome, please select your choice \n 1  Add a New Teacher \n 2 Add a new student \n 3 Display all teachers \n 4 Display all Students \n 5 calculate and display grades \n 6. exit the system");

                choice = sc.nextInt();
                sc.nextLine();

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Please select a valid choice in numbers only");
                sc.nextLine();

                continue;
            }

            if (choice == 6) {
                System.out.println(" Exiting System, Thank you");
                break;

            }

            switch (choice) {

                case 1:

                    Teacher teacher = new Teacher();

                    System.out.println("Please enter name of the teacher");

                    String name = sc.nextLine();

                    System.out.println(" Please enter the age of the Teacher");

                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.println(" Please enter the Subject of the teacher " + name);
                    String sub = sc.nextLine();

                    System.out.println();

                    System.out.println("Please enter the salary for the teacher " + name);
                    double sal = sc.nextDouble();

                    teacher.setdetails(name, age);
                    teacher.teachsubject(sub);
                    teacher.setSalary(sal);

                    Teachers.add(teacher);

                    break;

                case 2:
                    Student student = new Student();

                    System.out.println("Please enter the name of the Student");

                    String names = sc.nextLine();

                    System.out.println(" Please enter the age of the Student " + names);
                    int a = sc.nextInt();
                    sc.nextLine();

                    System.out.println(" Please enter the roll number of the Student " + names);
                    int roll = sc.nextInt();

                    System.out.println("Please enter the marks for the Student " + names + " by each subject at once");
                    int mark[] = new int[5];

                    for (int i = 0; i < 5; i++) {
                        System.out.println("Subject " + (i + 1) + " marks/20");
                        int marks = sc.nextInt();

                        mark[i] = marks;
                        if (mark[i] > 20 || mark[i] < 0) {
                            System.out.println(" Please Enter valid scores 20 marks per subject");
                            i--;
                        }

                    }
                    student.setdetails(names, a);
                    student.setroll(roll);
                    student.cal_total_marks(mark);

                    Students.add(student);

                    break;

                case 3:
                    for (Teacher t : Teachers) {
                        t.displayTeachers();
                        System.out.println("----------------");
                    }
                    break;
                case 4:
                    for (Student s : Students) {
                        s.displaystudent();
                        System.out.println("---------------");
                    }
                    break;

                case 5:
                    for (Student s : Students) {
                        s.cal_Grades();
                        System.out.println("---------------");
                    }

                    break;
                default:
                    System.out.println("Pick a correct choice");
                    break;

            }
        }

    }

}
