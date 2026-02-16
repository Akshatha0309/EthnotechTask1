//Write a program for electricity bill calculation first 100 units = 5 rupees per unit, 2nd 100 units = 7 rupees per unit, above 200 units 10 rupees per unit
import java.util.Scanner;

public class electricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter thenumber of units consumed:");
        int units=sc.nextInt();
        double bill=0;
        //if(units<=100){
        //    bill=units*5;

        //}
        //else if(units>=200){
        //    bill=(100*5)+(units-100)*7;
        //}
        //else{
        //   bill=(100*5)+(100*7)+(units-200)*7;

        //}
        bill=(units<=100)?units*5:(units>=200)?(100*5)+(units-100)*7:(100*5)+(100*7)+(units-200)*7;
        System.out.println("Total electricity bill=$" +bill);
        sc.close();
    }
}
