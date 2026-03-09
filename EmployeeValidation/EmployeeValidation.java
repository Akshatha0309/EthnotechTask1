package EmployeeValidation;

public class EmployeeValidation {

    public static void main(String[] args) throws Exception {

        Employee emp = new Employee(
                "Akshatha",
                "akshatha@gmail.com",
                "9876543210"
        );

        Validator.validate(emp);
    }
}

//javac *.java
//java Main