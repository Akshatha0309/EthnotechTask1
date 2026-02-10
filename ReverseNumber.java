//Write down the program to reverse the given number using loops. Input=876
class ReverseNumber {
    public static void main(String[] args) {
        int num = 876;
        int rev = 0;

        while(num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;
        }

        System.out.println("Reversed Number = " + rev);
    }
}