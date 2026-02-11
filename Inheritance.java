class Std {
    int marks=50;
}
class student extends Std{
    void display(){
        System.out.println("Marks:" +marks);
    }
}
public class Inheritance{
    public static void main(String[] args) {
        student s1=new student();
        s1.display();
    }
}