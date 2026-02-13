import java.util.*;
class PaymentCard implements Payment {
    @Override
    public void pay(double amount){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID or mail");
        String CardID = sc.nextLine();
        System.out.println("Online payment successful");
        System.out.println("Amount " +amount+ "paid through ID" +CardID);
    }
}