import java.util.Scanner;

public class StringArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();   // consume leftover newline

        String[] name = new String[n];
        int[] marks = new int[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            name[i] = sc.nextLine();

            System.out.print("Enter marks: ");
            marks[i] = sc.nextInt();
            sc.nextLine();  // consume newline
        }

        // Calculate total
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += marks[i];
        }

        System.out.println("\nTotal Marks: " + total);

        // Display grades
        for (int i = 0; i < n; i++) {

            if (marks[i] >= 90)
                System.out.println(name[i] + " Grade A+");
            else if (marks[i] >= 80)
                System.out.println(name[i] + " Grade A");
            else if (marks[i] >= 70)
                System.out.println(name[i] + " Grade B+");
            else if (marks[i] >= 60)
                System.out.println(name[i] + " Grade B");
            else if (marks[i] >= 50)
                System.out.println(name[i] + " Grade C");
            else
                System.out.println(name[i] + " Failed");
        }
    }
}