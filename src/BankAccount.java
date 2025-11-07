public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(double amount, String employeeName) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println(employeeName + " received salary $" + amount +
                    " | Remaining Balance: $" + balance);
        } else {
            System.out.println(employeeName + " could not receive salary $" + amount +
                    " | Insufficient funds! Current Balance: $" + balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Bank deposited $" + amount + " | New Balance: $" + balance);
    }
}
