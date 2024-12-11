import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Lab21Main {
    public static void main(String[] args) {
        Lab21Main main = new Lab21Main();
        try {
            Class<?> c = Class.forName("Employee");
            main.classFun(c);

            
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

    public void classFun(Class<?> c) {
        try {
            // Display canonical name
            System.out.println("Canonical Name: " + c.getCanonicalName());

            // Display all member data (fields)
            Field[] fields = c.getDeclaredFields();
            System.out.println("\nMember Data:");
            for (int i = 0; i < fields.length; i++) {
                System.out.println((i + 1) + ": " + fields[i]);
            }

            // Display local constructors (getDeclaredConstructors)
            Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
            System.out.println("\nLocal Constructors:");
            for (int i = 0; i < declaredConstructors.length; i++) {
                System.out.println((i + 1) + ": " + declaredConstructors[i]);
            }

            // Display all constructors (getConstructors)
            Constructor<?>[] constructors = c.getConstructors();
            System.out.println("\nAll Constructors:");
            for (int i = 0; i < constructors.length; i++) {
                System.out.println((i + 1) + ": " + constructors[i]);
            }

            // Display local methods (getDeclaredMethods)
            Method[] declaredMethods = c.getDeclaredMethods();
            System.out.println("\nLocal Methods:");
            for (int i = 0; i < declaredMethods.length; i++) {
                System.out.println((i + 1) + ": " + declaredMethods[i]);
            }

            // Display all methods (getMethods)
            Method[] methods = c.getMethods();
            System.out.println("\nAll Methods:");
            for (int i = 0; i < methods.length; i++) {
                System.out.println((i + 1) + ": " + methods[i]);
            }

            // Part 4
            Object employeeInstance = c.getDeclaredConstructor().newInstance();

            // Print information about the instance
            System.out.println("\nIs Enum: " + c.isEnum());
            System.out.println("Is Interface: " + c.isInterface());
            System.out.println("toString: " + employeeInstance.toString());

            // Find setSalary
            Method setSalMethod = find(declaredMethods, "setSalary");
            if (setSalMethod != null) {
                // System.out.println(setSalMethod);
                setSalMethod.invoke(employeeInstance, 1000.0);
            }

            // Find getSalary
            Method getSalMethod = find(declaredMethods, "getSalary");
            if (getSalMethod != null) {
                System.out.println( getSalMethod.invoke(employeeInstance) );
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Method find(Method[] methods, String what) {
        for (Method m: methods) {
            if (m.toString().contains(what)) {
                return m;
            }
        }
        return null;
    }
        
}
