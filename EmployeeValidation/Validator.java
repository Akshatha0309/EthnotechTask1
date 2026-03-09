package EmployeeValidation;

import java.lang.reflect.Field;

class Validator {

    public static void validate(Object obj) throws Exception {

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Validate.class)) {

                Validate annotation = field.getAnnotation(Validate.class);

                field.setAccessible(true);
                String value = (String) field.get(obj);

                if (!value.matches(annotation.pattern())) {
                    System.out.println(field.getName() + " : " + annotation.message());
                } else {
                    System.out.println(field.getName() + " : Valid");
                }
            }
        }
    }
}