import java.util.*;
public class Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name=sc.nextLine();
        System.out.println("Length of String:" +name.length());
        System.out.println("Uppercase:" +name.toUpperCase());
        System.out.println("Lowercase:" +name.toLowerCase());
        System.out.println("Character at 0 :" +name.charAt(0));
        System.out.println("Is name equal to Admin :" +name.compareTo("Admin"));
        String s=name;
        s=s.concat(" Hello ");
        System.out.println(s);
        sc.close();
    }
}
