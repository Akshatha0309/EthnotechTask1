import java.util.*;
class PaymentCash implements Payment {
    @Override
    public void pay(double amount){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID or mail");
        String Cash = sc.nextLine();
        System.out.println("Cash payment successful");
        System.out.println("Amount " +amount+ " paid through ID " +Cash);
    }
}