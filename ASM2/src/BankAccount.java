public class BankAccount {
    private int accountID;
    private String accountName;
    private double balance;

    public BankAccount(int accountID, String accountName, double balance) {
        this.accountID = accountID;
        this.accountName = accountName;
        if (balance < 0) {
            this.balance = 0;
            System.out.println("Invalid Balance");
        } else {
            this.balance = balance;
        }
    }

    public int getAccountID() {
        return accountID;
    }

    /*
    Không viết setter cho accountID.
    Vì số tài khoản là định danh cố định của tài khoản ngân hàng,
    nếu cho phép thay đổi có thể gây sai lệch dữ liệu.
    */

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        if (accountName != null && !accountName.trim().isEmpty())
            this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
        }
    }

    public void displayInfo() {
        String id = String.valueOf(accountID);
        System.out.println("Account ID: " + id.replaceAll(".(?=.{4})", "*"));
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: " + balance);
    }

    public void transfer(BankAccount other, double amount) {
        if (amount <= 0) {
            System.out.println("So tien chuyen phai > 0");
        } else if (amount > balance) {
            System.out.println("Khong du so du de chuyen!");
        } else {
            balance -= amount;
            other.balance += amount;
            System.out.println("Chuyen tien thanh cong!");
        }
    }
}
