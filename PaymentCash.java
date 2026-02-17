import java.util.*;
class PaymentCash extends Payment {
    @Override
    public void pay(double amount){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cash payment successful");
        System.out.println("Amount " +amount+ " paid throw cash");
    }
}