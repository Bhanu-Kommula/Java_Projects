import java.util.Scanner;

class Acess {

    private double balance = 0;

    public void deposit(double b) {

        if (b > 0) {
            this.balance += b;
            System.out.println("Successfully Deposited: $" + b + "  available balance is $" + this.balance);
        } else {
            System.out.println("Deposit amount must be greater than Zero");
        }
    }

    public void withdraw(double b) {

        if (b <= 0) {
            System.out.println("Withdraw amount should be greater than Zero");
        } else if (balance - b < 0) {
            System.out.println("Insufficient Balance");
        } else {
            this.balance -= b;
            System.out.println("Successfully Withdrawn $ " + b + "  available balance is $ " + this.balance);
        }
    }

    public void checkBalance() {
        System.out.println("Your Available Balance is : $" + this.balance);
    }

}

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Acess obj = new Acess();

        while (true) {

            System.out.println("\nWelcome to our bank");
            System.out.println("\nplease slect \n1 To Deposit \n2 To Withdraw \n3 To Check Balance \n0 To Exit");
            int op = sc.nextInt();
            if (op == 0) {
                System.out.println("System Exiting");
                break;
            }
            switch (op) {
                case 1:
                    System.out.println("Please enter the amount you want to Deposit");
                    double deposit_amount = sc.nextDouble();
                    obj.deposit(deposit_amount);
                    break;
                case 2:
                    System.out.println("Please enter the amount you want to Withdraw");
                    double Withdraw_amount = sc.nextDouble();
                    obj.withdraw(Withdraw_amount);
                    break;
                case 3:
                    obj.checkBalance();

                    break;

                default:
                    System.out.println("Please select a valid Operation");
                    break;
            }
        }

        sc.close();

    }
}
