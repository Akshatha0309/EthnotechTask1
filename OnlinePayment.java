import java.util.*;
class OnlinePayment extends Payment {
    @Override
    public void pay(double amount){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter ID or Mail");
    String OnlineID=sc.nextLine();
    System.out.println("Online payment successful");
    System.out.println("Amount " +amount+ " paid through ID " +OnlineID);
    }
}

