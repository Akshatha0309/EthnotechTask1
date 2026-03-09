package EmployeeValidation;

class Employee {

    @Validate(pattern = "^[A-Za-z ]+$", message = "Invalid Name")
    String name;

    @Validate(pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid Email")
    String email;

    @Validate(pattern = "^[0-9]{10}$", message = "Invalid Phone Number")
    String phone;

    Employee(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}