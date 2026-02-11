public class Bankpplication {
    public static void main(String[] args) {
        BankAccount Account=new BankAccount(10000);
System.out.println("Initial Balance:" +Account.getbalance());
Account.deposit(2000);
System.out.println("Amount after deposit:" +Account.getbalance());
Account.withdraw(5000);
System.out.println("Amount after withdrawl:" +Account.getbalance());
    }
}
