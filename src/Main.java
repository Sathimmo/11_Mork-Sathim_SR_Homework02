import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static CheckingAccount checkingAccount = null;
    private static SavingAccount savingAccount = null;
    private static String username;
    private static String dob;
    private static String gender;
    private static String phoneNum;
    private static double transferMoney;

    private static void InputUserData( ){
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter date of birth (dd-mm-yyyy): ");
        dob = scanner.nextLine();
        System.out.print("Enter gender: ");
        gender = scanner.nextLine();
        System.out.print("Enter phone number: ");
        phoneNum = scanner.nextLine();
    }

    private static void createAccount() {
        String subChioce;
        do {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    Create Account   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
            System.out.println("1. Checking Account");
            System.out.println("2. Saving Account");
            System.out.println("3. Back");
            System.out.println("-______________________________________________________________________________________-");
            System.out.print("Choose an option: ");
            subChioce = scanner.nextLine();
            switch (subChioce) {
                case "1":
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Account Information  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
                    if (checkingAccount == null){
                        InputUserData();
                        checkingAccount = new CheckingAccount(username, dob, gender,phoneNum );
                    }
                    System.out.println("-========================================================================================-");
                    System.out.println("Your checking account has been created successfully!");
                    break;
                case "2":
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Account Information  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
                    if (savingAccount == null){
                        InputUserData();
                        savingAccount = new SavingAccount(username, dob, gender,phoneNum);
                    }
                    System.out.println("-========================================================================================-");
                    System.out.println("Your saving account has been created successfully!");
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Please Choose Option above!!");
            }
        } while (!subChioce.equals("3"));
    }

    private static void depositMoney() {
        if (checkingAccount == null && savingAccount == null){
            System.out.println("Doesn't have account, please create account!");
            return;
        }
        String subChioce;
        do {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    Deposit Money   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
            System.out.println("1. Checking Account");
            System.out.println("2. Saving Account");
            System.out.println("3. Back");
            System.out.println("-______________________________________________________________________________________-");
            System.out.print("Choose an option: ");
            subChioce = scanner.nextLine();
            switch (subChioce){
                case "1":
                    if (checkingAccount != null){
                        System.out.print("Enter money to deposit: ");
                        String deposit = scanner.nextLine();
                        double depoitNum;
                        depoitNum = Double.parseDouble(deposit);
                        checkingAccount.deposit(depoitNum);
                        System.out.println("========================================================================================\n");
                        System.out.println("Deposit successful!");
                    }else
                        System.out.println("Please try again!!");
                    break;
                case "2":
                    if (savingAccount != null){
                        System.out.print("Enter money to deposit: ");
                        String deposit = scanner.nextLine();
                        double depoitNum;
                        depoitNum = Double.parseDouble(deposit);
                        savingAccount.deposit(depoitNum);
                        System.out.println("========================================================================================\n");
                        System.out.println("Deposit successful!");
                    }else
                        System.out.println("Please try again!!");
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Please Choose Option above!!");
            }
        }while (!subChioce.equals("3"));
    }

    private static void withdrawMoney() {
        if (checkingAccount == null && savingAccount == null){
            System.out.println("Doesn't have account, please create account!");
            return;
        }
        String subChioce;
        do {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    Withdraw Money   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
            System.out.println("1. Checking Account");
            System.out.println("2. Saving Account");
            System.out.println("3. Back");
            System.out.println("-______________________________________________________________________________________-");
            System.out.print("Choose an option: ");
            subChioce = scanner.nextLine();
            switch (subChioce){
                case "1":
                    if (checkingAccount != null){
                        System.out.print("Enter money to withdraw: ");
                        String withdraw = scanner.nextLine();
                        double withdrawNum;
                        withdrawNum = Double.parseDouble(withdraw);
                        System.out.println("\t\t\t\t Checking Account ");
                        checkingAccount.withdraw(withdrawNum);
                        System.out.println("========================================================================================\n");
                        System.out.println("Withdraw successful!");
                    }else
                        System.out.println("Please try again!!");
                    break;
                case "2":
                    if (savingAccount != null){
                        System.out.print("Enter money to withdraw: ");
                        String withdraw = scanner.nextLine();
                        double withdrawNum;
                        withdrawNum = Double.parseDouble(withdraw);
                        System.out.println("\t\t\t\t Checking Account ");
                        savingAccount.withdraw(withdrawNum);
                        System.out.println("========================================================================================\n");
                        System.out.println("Withdraw successful!");
                    }else
                        System.out.println("Please try again!!");
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Please Choose Option above!!");
            }
        }while (!subChioce.equals("3"));
    }

    private static void transferMoney(){
        if (checkingAccount == null && savingAccount == null){
            System.out.println("Doesn't have account, please create account!");
            return;
        }
        String subChioce;
        do {
            //Transfer
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Transfer Moneys  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
            System.out.println("1. Checking Account -> Saving Account");
            System.out.println("2. Saving Account -> Checking Account");
            System.out.println("3. Back");
            System.out.println("-______________________________________________________________________________________-");
            System.out.print("Choose an option: ");
            subChioce = scanner.nextLine();
            switch (subChioce){
                case "1":
                    if (checkingAccount != null && savingAccount != null){
                        System.out.print("Enter money to withdraw: ");
                        String transfer = scanner.nextLine();
                        double transferMoney;
                        transferMoney = Double.parseDouble(transfer);
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Checking Account <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println("Transferred :                                 $"+transferMoney);
                        System.out.println("From        : Checking Account with ID: "+checkingAccount.getAccountId());
                        System.out.println("To          :   Saving Account with ID: "+savingAccount.getAccountId());
                        System.out.println("Total Remain:                           $"+checkingAccount.getBalance());
                        checkingAccount.transfer(transferMoney, savingAccount);
                    }
                    else {
                        System.out.println("Error account please check again!");
                    }
                    break;
                case "2":
                    if (checkingAccount != null && savingAccount != null){
                    System.out.print("Enter money to withdraw: ");
                    String transfer = scanner.nextLine();
                    transferMoney = Double.parseDouble(transfer);
                    savingAccount.transfer(transferMoney, checkingAccount);
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Saving Account <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        System.out.println("Transferred :                          $"+transferMoney);
                        System.out.println("From        :   Saving Account with ID: "+savingAccount.getAccountId());
                        System.out.println("To          : Checking Account with ID: "+checkingAccount.getAccountId());
                        System.out.println("Total Remain:                           $"+savingAccount.getBalance());
                }
                    else {
                    System.out.println("Error account please check again!");
                }
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Please Choose Option above!!");
            }
        }while (!subChioce.equals("3"));

    }

    private static void deleteAccount(){
        if (checkingAccount == null && savingAccount == null){
            System.out.println("Doesn't have account, please create account!");
            return;
        }
        String subChioce;
        do {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Delete Account  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
            System.out.println("1. Checking Account");
            System.out.println("2. Saving Account");
            System.out.println("3. Back");
            System.out.println("-______________________________________________________________________________________-");
            System.out.print("Choose an option: ");
            subChioce = scanner.nextLine();
            switch (subChioce){
                case "1":
                    if (checkingAccount != null){
                        System.out.print("Are you sure you want to delete this account(Y?N): ");
                        String comfirm = scanner.nextLine();
                        if (comfirm.equalsIgnoreCase("y")){
                            checkingAccount.transfer(checkingAccount.getBalance(), savingAccount);

                            System.out.println("Transferred :                          $"+checkingAccount.getBalance());
                            System.out.println("From        : Checking Account with ID: "+checkingAccount.getAccountId());
                            System.out.println("To          :   Saving Account with ID: "+savingAccount.getAccountId());
                            System.out.println("Total Remain:                           $"+checkingAccount.getBalance());

                            checkingAccount = null;
                        }
                    }
                    else {
                        System.out.println("Error to delete please check again!");
                    }
                    break;
                case "2":
                    System.out.print("Are you sure you want to delete this account(Y?N): ");
                    String comfirm = scanner.nextLine();
                    if (comfirm.equalsIgnoreCase("y")){
                        savingAccount.transfer(savingAccount.getBalance(), checkingAccount);
                        savingAccount = null;
                        System.out.println("Transferred :                          $"+savingAccount.getBalance());
                        System.out.println("From        :   Saving Account with ID: "+savingAccount.getAccountId());
                        System.out.println("To          : Checking Account with ID: "+checkingAccount.getAccountId());
                        System.out.println("Total Remain:                           $"+savingAccount.getBalance());

                    }

                    else {
                        System.out.println("Error account please check again!");
                    }
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Please Choose Option above!!");
            }
        }while (!subChioce.equals("3"));

    }

    private static void displayAccountInfo() {
        if (checkingAccount != null) {
            checkingAccount.displayAccountInfo();
        }
        if (savingAccount != null) {
            savingAccount.displayAccountInfo();
        }
        if (checkingAccount == null && savingAccount == null) {
            System.out.println("No accounts available.");
        }
    }



    public static void main(String[] args) {

         String mainChoice = "";
         String subChioce = "";

         do {
             System.out.println("-================================ Online Banking System ================================-");

             System.out.println("1. Create Account");
             System.out.println("2. Deposit Money");
             System.out.println("3. Withdraw Money");
             System.out.println("4. Transfer Money");
             System.out.println("5. Display Account Information");
             System.out.println("6. Delete Account");
             System.out.println("7. Exit");
             System.out.println("-______________________________________________________________________________________-");
             System.out.print("=> Choose option(1-7) :");
             mainChoice = scanner.nextLine();
             switch (mainChoice){
                 case "1":
                     createAccount();
                     break;
                 case "2":
                     depositMoney();
                     break;
                 case "3":
                     withdrawMoney();
                     break;
                 case "4":
                     transferMoney();
                     break;
                 case "5":
                     displayAccountInfo();
                     break;
                 case "6":
                     deleteAccount();
                     break;
                 case "7":
                     break;
                 default:
                     System.out.println("Please Choose Option above!!");
             }
         }while (mainChoice !="7");

    }
}