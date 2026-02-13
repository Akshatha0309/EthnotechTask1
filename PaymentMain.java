import java.util.*;
public class PaymentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Payment Method");
        System.out.println("1.Online");
        System.out.println("2. Card");
        System.out.println("3. Cash");
        System.out.println("Enter choice");
        int choice=sc.nextInt();
        System.out.println("Enter amount");
        double amount=sc.nextDouble();
        if(amount<=0){
            System.out.println("Invalid amount");
            return;
        }
        Payment payment=null;
        switch(choice){
            case 1:
                payment=new OnlinePayment();
                break;
            case 2:
                payment=new PaymentCard();
                break;
            case 3:
                payment=new PaymentCash();
                break;
            default:
                System.out.println("Invalid choise");
                break;
        }
        if(payment!=null){
            payment.pay(amount);
        }
        
    }
}
