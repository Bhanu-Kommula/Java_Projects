package Projects;

import java.util.Collections;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

class Task implements Comparable<Task> {

    private String Title;
    private String Description;
    private LocalDate Date;
    private int priority;
    private String Status;

    public void setDetails(String t, String des, LocalDate date, int p, String s) {

        Title = t;

        Description = des;

        this.Date = date;

        priority = p;

        Status = s;
    }

    public int compareTo(Task other) {

        return this.priority - other.priority;

    }

    public void display_EditTasks(int i) {

        System.out.println("SNo " + i + ". " + "  " + Title);

    }

    public void editTitle(String s) {

        this.Title = s;

    }

    public void editDescription(String t) {
        Description = t;

    }

    public void editDate(LocalDate t) {
        Date = t;

    }

    public void editPriority(int t) {
        priority = t;

    }

    public String getStatus() {
        return Status;

    }

    public void editStatus(String t) {

        LocalDate today = LocalDate.now();

        if (t.equals("Yes")) {
            Status = " YES";

        } else if (Date.isBefore(today) && Status.equals("No")) {
            Status = " OverDue";
        } else {

            Status = t;
        }
    }

    public void displayEditedTasks(int n) {

        LocalDate today = LocalDate.now();
        if (Date.isBefore(today) && Status.equals("No")) {
            Status = " OverDue";
        }
        String priorityText = priority == 1 ? "High" : priority == 2 ? "Medium" : "Low";

        System.out.println(
                "\n      Title -- " + Title + " \n\n Description -- " + Description + " \n\n Due_Date -- " + Date
                        + " \n\n  Priority_Level -- " + priorityText + " \n\n  Completion_Status -- " + Status + " \n");

    }

    public void displayTasks() {

        LocalDate today = LocalDate.now();
        if (Date.isBefore(today) && Status.equals("No")) {
            Status = "OverDue";
        }

        String priorityText = priority == 1 ? "High" : priority == 2 ? "Medium" : "Low";

        System.out.println(

                "\n   Title --   " + Title + "\n\n  Description -- " + Description + "\n\n  Due_Date -- " + Date
                        + " \n\n  Priority_Level -- " + priorityText + " \n\n Completion_Status -- " + Status + " \n");

        System.out.println("==================================== \n ");
    }

}

public class TODO_list {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Task> Tasks = new ArrayList(); // here we are creating a arraylist for the obj task

        while (true) {

            int choice;

            System.out.println(
                    " \n Hey, welcome, please enter your choice \n 1 - Add Task \n 2 - Edit Task \n 3 - Delete Task \n 4 - Update Status \n 5 - Display Tasks \n 6 - Exit ");

            try {
                choice = sc.nextInt();

                if (choice == 6) {
                    System.out.println(" Thankyou, Closing Application ... ");
                    break;
                }

                switch (choice) {
                    case 1:
                        System.out.println("\n Please enter the TITLE");
                        sc.nextLine();

                        String title = sc.nextLine();

                        System.out.println(" Please enter the Description");
                        String descp = sc.nextLine();

                        System.out.println(" Please enter the Due Date in format MM-dd-yyyy");
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                        String date = sc.nextLine();
                        LocalDate Date;
                        try {
                            Date = LocalDate.parse(date, format);

                        } catch (Exception e) {

                            System.out.println("Please enter date in MM-dd-yyyy format");
                            break;
                        }

                        System.out.println(" Please enter the Priority \n 1 for High \n 2 for Medium \n 3 for Low ");
                        int p = sc.nextInt();

                        System.out.println(" Please enter the Completion Status \n 1 for yes  or 2 for no");
                        int s = sc.nextInt();
                        String status;
                        if (s == 1) {
                            status = "Yes";
                        } else {
                            status = "No";
                        }

                        Task T = new Task(); // creating obj for task it has to decleared here only

                        T.setDetails(title, descp, Date, p, status);

                        Tasks.add(T); // add() is used to add the obj into array list

                        break;

                    case 2:

                        System.out.println(" Enter the task S.No  which you want to EDIT");

                        for (int i = 0; i < Tasks.size(); i++) { // So here we are using size() method to get the
                                                                 // total
                                                                 // size
                                                                 // of array list

                            Tasks.get(i).display_EditTasks(i + 1); // here get() is used to get the object data
                                                                   // stored
                                                                   // at
                                                                   // that paticular index

                        }

                        int sno = sc.nextInt();

                        while (true) {
                            System.out.println(
                                    " Please enter \n 1 - Edit Title \n 2 - Edit Description \n 3- Edit Due_Date \n 4 - Edit Priority \n 5 - Edit Completion_Status \n 6 - View Edited Task \n 7 - Save and Exit");

                            int option = sc.nextInt();
                            sc.nextLine();

                            if (sno < 1 || sno > Tasks.size()) {
                                System.out.println("Invalid task number. Please try again.");
                                break;
                            }
                            Task edit = Tasks.get(sno - 1);

                            if (option == 7) {
                                System.out.println(" Saving and exiting the Application");
                                break;
                            }
                            switch (option) {
                                case 1:

                                    System.out.println(" Please enter the new Title");
                                    String t = sc.nextLine();
                                    edit.editTitle(t);
                                    System.out.println("Successfully Updated \n");
                                    break;

                                case 2:

                                    System.out.println(" Please enter the new Description");
                                    String des = sc.nextLine();
                                    edit.editDescription(des);
                                    System.out.println("Successfully Updated \n");

                                    break;

                                case 3:

                                    System.out.println(" Please enter the new Date");
                                    DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");

                                    String d = sc.nextLine();

                                    try {
                                        LocalDate D = LocalDate.parse(d, format1);
                                        edit.editDate(D);

                                    } catch (Exception e) {

                                        System.out.println("Please enter date in MM-dd-yyyy format");
                                        break;
                                    }
                                    System.out.println("Successfully Updated \n");

                                    break;

                                case 4:

                                    System.out.println(" Please enter the new Priority");
                                    int pr = sc.nextInt();
                                    edit.editPriority(pr);
                                    System.out.println("Successfully Updated \n");

                                    break;

                                case 5:

                                    System.out.println(" Please enter the new Status \n 1 for Yes \n 2 for No");
                                    int sts = sc.nextInt();
                                    String st;
                                    if (sts == 1) {
                                        st = "Yes";

                                    } else {

                                        st = "No";
                                    }

                                    edit.editStatus(st);
                                    System.out.println("Successfully Updated \n");

                                    break;

                                case 6:

                                    System.out.println(" Viewing Updated Task");
                                    Tasks.get(sno - 1).displayEditedTasks(sno - 1);

                                    break;

                                default:
                                    System.out.println("Choice a correct option");
                                    break;
                            }

                        }

                        break;

                    case 3:

                        System.out.println(" Please choose the task number you want to DElETE");

                        for (int i = 0; i < Tasks.size(); i++) {

                            Tasks.get(i).display_EditTasks(i + 1);

                        }
                        int num = sc.nextInt();

                        Tasks.remove(num - 1);
                        System.out.println(" Task Deleted ");

                        break;

                    case 4:
                        System.out.println(" Please choose the task you want UPDATE the Status");

                        for (int i = 0; i < Tasks.size(); i++) {

                            Tasks.get(i).display_EditTasks(i + 1);

                        }

                        int u = sc.nextInt();

                        System.out.println(" Current Status is " + Tasks.get(u - 1).getStatus());
                        System.out.println("Please Update the Status \n 1 - Yes \n 2 - No ");

                        String up = sc.next();
                        if (up.equals("1")) {
                            up = "yes";
                        } else {
                            up = "No";
                        }

                        Tasks.get(u - 1).editStatus(up);

                        break;

                    case 5:

                        Collections.sort(Tasks);
                        for (Task t : Tasks) {

                            t.displayTasks();
                        }

                        break;

                    default:
                        System.out.println(" please enter a correct chioce");
                        break;

                }

            } catch (Exception e) {
                sc.nextLine();

                System.out.println(" Please choose a vaild choice ");
                continue;
            }
        }

    }

}