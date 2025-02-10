import java.util.Random;
public class SavingAccount implements Account{
    private String accountId;
    private String userName;
    private String dob;
    private String gender;
    private String phoneNumber;
    private double balance;
    private static final double interest_rate = 0.05;

    public SavingAccount(String userName, String dob, String gender, String phoneNumber) {
        this.accountId = generateRandomId();
        this.userName = userName;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
//        this.balance = balance;
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

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void deposit(double amount) {
        if (amount >= 200) {
            balance += amount + amount * interest_rate;
        } else{
            balance += amount;
        }
        System.out.println("                   Saving Account             ");
        System.out.println("Received    :                          "+ amount);
        System.out.println("Total Amount:                          "+ balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= 0.8 * balance){
            balance = balance - amount;
            System.out.println("                   Saving Account             ");
            System.out.println("Transfer    :                          "+amount);
            System.out.println("Total Amount:                          "+balance);

        } else
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

        System.out.println("Account ID: " + accountId);
        System.out.println("User Name: " + userName);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Balance: $" + balance);
    }
}
