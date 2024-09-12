import java.util.Scanner;

class emp {

    Scanner sc = new Scanner(System.in);
    int total_emp;
    Double emp_sal;
    Double emp_tax;
    String emp_name;
    int emp_id;
    double net_sal;
    double net_sals[];
    String names[];
    int emp_ID[];

    public void emp_details() {

        System.out.println("Enter total no of employes in the company");
        total_emp = sc.nextInt();
        net_sals = new double[total_emp];
        names = new String[total_emp];

        emp_ID = new int[total_emp];

        for (int i = 0; i < total_emp; i++) {
            System.out.println("Enter Employe ID");
            emp_id = sc.nextInt();

            System.out.println("Enter Employe Name");
            sc.nextLine();
            emp_name = sc.nextLine();

            System.out.println(" ");

            System.out.println("Enter Employe Basic Salary");
            emp_sal = sc.nextDouble();

            if (emp_sal < 0) {
                System.out.print("please enter valid salary \n");
                i--;
                continue;

            }

            System.out.println("Enter Employe Tax rate as percentage");
            emp_tax = sc.nextDouble();
            if (emp_tax > 100 || emp_tax < 0) {
                System.out.print("please enter valid tax rate in range 0-100 \n");
                i--;
                continue;

            }

            Sal(i);

        }
    }

    public void Sal(int i) {

        net_sal = emp_sal - (emp_sal * (emp_tax / 100));
        net_sals[i] = net_sal;
        names[i] = emp_name;
        emp_ID[i] = emp_id;

    }

    public void emp_results() {

        System.out.println("Employe ID   |  Employee Name    |   Net Salary ");

        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < total_emp; i++)
            System.out.println(emp_ID[i] + "         | " + names[i] + "     |     " + net_sals[i]);

    }

}

public class Sal_calc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        emp obj = new emp();
        obj.emp_details();

        System.out.println(" Would you like to: \n 1. Display Salaries \n2. Exit");
        String choice = sc.next();

        switch (choice) {

            case "1":

                obj.emp_results();
                break;

            case "2":
                System.out.println("Exiting, Thank you");
                break;

            default:
                System.out.println("choose a valid option (1 for salary calculation and 2 to exit)");

                break;

        }
        sc.close();

    }

}
