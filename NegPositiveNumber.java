//write a program to find the given number is negative or positive. Input=123

class NegPositiveNumber {
    public static void main(String[] args) {
        int num = 123;

        if(num > 0) {
            System.out.println("Positive Number");
        }
        else if(num < 0) {
            System.out.println("Negative Number");
        }
        else {
            System.out.println("Zero");
        }
    }
}