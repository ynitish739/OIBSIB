import java.util.Scanner;

class BankAccount {

    String Bank_account_holder_Name;
    String Unique_userName;
    String Login_Password;
    String User_AccountNo;
    float Bank_Balance = 200000f;
    int Number_of_transactions=0;
    String Transctions_History = "";

    public void Register_s(){
        Scanner scan2 = new Scanner(System.in);
        System.out.print("\nEnter Your full Name - ");
        this.Bank_account_holder_Name = scan2.nextLine();
        System.out.print("\nEnter Your Username (Must remember) - ");
        this.Unique_userName = scan2.nextLine();
        System.out.print("\nEnter Your Password (Must remember) - ");
        this.Login_Password = scan2.nextLine();
        System.out.print("\nEnter Your Account  Number - ");
        this.User_AccountNo = scan2.nextLine();
        System.out.println("\nRegistration completed..Kindly login");
    }

    public boolean Login_s() {
        boolean Login_checker = false;
        Scanner scan = new Scanner(System.in);
        while( !Login_checker) {
            System.out.print("\nEnter Your Username - ");
            String Username = scan.nextLine();
            if( Username.equals(Unique_userName)) {
                while( !Login_checker) {
                    System.out.print("\nEnter Your Password - ");
                    String Password = scan.nextLine();
                    if( Password.equals(Login_Password)) {
                        System.out.print("\nLogin Successfull...");
                        Login_checker = true;
                    }
                    else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            }
            else {
                System.out.println("\nusername not found");
            }
        }
        return Login_checker;
    }

    public void withdraw() {
        System.out.print("\nEnter amount to withdraw - ");
        Scanner scan3 = new Scanner(System.in);
        float Amounts = scan3.nextFloat();
        try {

            if ( Bank_Balance >= Amounts ) {
                Number_of_transactions++;
                Bank_Balance -= Amounts;
                System.out.println("\nWithdraw Successfully");
                String str = Amounts + "Rs Withdrawed\n";
                Transctions_History = Transctions_History.concat(str);
            }
            else {
                System.out.println("\nInsufficient Balance");
            }

        }
        catch( Exception e){
        }
    }

    public void Deposites() {

        System.out.print("\nEnter amount to deposit - ");
        Scanner sc = new Scanner(System.in);
        float amt = sc.nextFloat();
        try {
            if (amt <= 200000f ){
                Number_of_transactions++;
                Bank_Balance += amt;
                System.out.println("\nSuccessfully Deposited");
                String str = amt + " Rs deposited\n";
                Transctions_History = Transctions_History.concat(str);
            }
            else {
                System.out.println("\nSorry Limit is 200000.00");
            }

        }
        catch (Exception e) {
        }
    }
    public void Transfers() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Receipent's Name - ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter amount to transfer - ");
        float Amounts = sc.nextFloat();

        try {
            if (Bank_Balance >= Amounts) {
                if (Amounts <= 60000f) {
                    Number_of_transactions++;
                    Bank_Balance -= Amounts;
                    System.out.println("\nSuccessfully Transfered to " + receipent);
                    String str = Amounts + "Rs transfered to " + receipent + "\n";
                    Transctions_History = Transctions_History.concat(str);
                } else {
                    System.out.println("\n Sorry  limit is 60000.00");
                }
            }
        }
        catch(Exception e){}
    }
    public void Check_Balance() {
        System.out.println("\n"+ Bank_Balance + "Rs");
    }

    public void Trans_History() {
        if(Number_of_transactions == 0) {
            System.out.println("\nEmpty");
        }
        else {
            System.out.println("\n" + Transctions_History);
        }
    }
}
public class AtmInterface {

    public static int takeIntegerInput(int limit) {
        int In_puts = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc =new Scanner(System.in);
                In_puts = sc.nextInt();
                flag = true;
                if(flag && In_puts > limit || In_puts < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return In_puts;
    }

    public static void main(String[] args) {

        System.out.println("\n--------------------------WELCOME TO INDIAN ATM-------------------------------\n");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Enter Your Choice - ");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.Register_s();
            while(true) {
                System.out.println("\n1.Login \n2. Exit");
                System.out.println("Enter Your Choice - ");
                int ch = takeIntegerInput(2);
                if (ch ==1) {
                    if (b.Login_s()) {
                        System.out.println("\n\n--------------------------WELCOME BACK " + b.Bank_account_holder_Name + "--------------------------\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Check Transaction History \n6.isFinished \n");
                            System.out.println("\nEnter your Choice - ");
                            int c =takeIntegerInput(6);
                            switch (c) {
                                case 1 -> b.withdraw();
                                case 2 -> b.Deposites();
                                case 3 -> b.Transfers();
                                case 4 -> b.Check_Balance();
                                case 5 -> b.Trans_History();
                                case 6 -> isFinished = true;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else  {
            System.exit(0);
        }

    }
}
