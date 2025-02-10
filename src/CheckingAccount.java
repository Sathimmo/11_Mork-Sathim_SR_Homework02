import java.util.Random;
public class CheckingAccount implements Account {
    private String accountId;
    private String userName;
    private String dob;
    private String gender;
    private String phoneNumber;
    private double balance;

    public CheckingAccount( String userName, String dob, String gender, String phoneNumber) {
        this.accountId = generateRandomId();
        this.userName = userName;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }


    //Id Random
    private String generateRandomId() {
        Random random = new Random();
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }


    public String getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //    @Override
//    public String toString() {
//        return "CheckingAccount{" +
//                "accountId='" + accountId + '\'' +
//                ", userName='" + userName + '\'' +
//                ", dob='" + dob + '\'' +
//                ", gender='" + gender + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
//    }

    @Override
    public void deposit(double amount) {
        if (amount > 0){
            balance = balance + amount;
            System.out.println("                   Checking Account           ");
            System.out.println("Received    :                          "+amount);
            System.out.println("Total Amount:                          "+balance);
        }
        else
            System.out.println("Doesn't have amount in account");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0){
            balance = balance - amount;
            System.out.println("                   Checking Account           ");
            System.out.println("Transfer    :                          "+amount);
            System.out.println("Total Amount:                          "+balance);
        }
        else
            System.out.println("Doesn't have amount in account");
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }

    public void displayAccountInfo() {

        System.out.println("AccountID: " + accountId);
        System.out.println("User Name: " + userName);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Balance: $" + balance);
    }
}


