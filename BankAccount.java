// Design a banking system using object oriented programming for deposit and withdrawl of money
class BankAccount {
    private double balance;
    BankAccount(double balance){
    this.balance=balance;
    }
    public double getbalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
        balance+=amount;
        System.out.println("Deposited amount:"+amount);
        }else{
            System.out.println("Invalid balance");
        }
    }
    public void withdraw(double amount){
        if(amount>balance){
            balance-=amount;
            System.out.println("Insufficient balance");
        }else if(amount>0){
            balance-=amount;
            System.out.println("Withdrawal amount:" +amount);
        }else{
            System.out.println("Invalid withdrawal amount");
        }
    }
}
