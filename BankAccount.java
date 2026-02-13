class BankAccount {

    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("Thank you for using our service.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Thank you for using our service.");
        } else {
            System.out.println("Insufficient Balance");
            System.out.println("Thank you for using our service.");
        }
    }
}