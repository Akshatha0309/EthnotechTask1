package EmployeeValidation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

@interface Validate {
    String pattern();
    String message();
}