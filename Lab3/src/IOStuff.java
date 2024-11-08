// Lab3
// Your name: Naim Sadeghian
// Your Andrew id: nsadeghi

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// class IOSTuff
// Tests some issues of input and output

public class IOStuff {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String firstName, lastName, ageString, salaryString;
        String id;
        int age;
        double salary;

        // System.out.print("Enter first name: ");
        // firstName = scanner.nextLine();
        
        // System.out.print("Enter last name: ");
        // lastName = scanner.nextLine();

        // System.out.print("Enter id: ");
        // id = scanner.nextLine();

        // System.out.print("Enter age: ");
        // ageString = scanner.nextLine();

        // System.out.print("Enter salary: ");
        // salaryString = scanner.nextLine();

        // try {
        //     age = Integer.parseInt( ageString ); // Still throws error when converting non Integer string
        //     salary = Double.parseDouble( salaryString );
        // } catch (NumberFormatException e ) {
        //     System.out.println(e);
        //     age = 0;
        //     salary = 0.0;
        // }
        

        // Print 
        // System.out.println("First Name = " + firstName);
        // System.out.println("Last Name = " + lastName);
        // System.out.println("Age = " + age);
        // System.out.println("ID = " + id);
        // System.out.println("Salary = " + salary);

        // System.out.printf("%10s %10s %4s %2s %8s%n", "First Name ajsd iauhspiud hpashdu", "Last Name", "ID", "Age", "Salary");
        // System.out.printf("%10s %10s %4s %2d %6.2f ", firstName, lastName, id, age, salary);

        // #5 

        File file = new File("employee.csv");
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

        System.out.printf("%10s %10s %4s %2s %9s %8s%n", "First Name", "Last Name", "ID", "Age", "Salary", "Category");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] splitLine = line.split(",");

            // John,Smith,142A,27,42500.00
            firstName = splitLine[0];
            lastName = splitLine[1];
            id = splitLine[2];
            age = Integer.parseInt( splitLine[3] );
            salary = Double.parseDouble( splitLine[4] );

            String category = null;
            if (salary < 0 || salary > 150000) {
                category = "Error";
            } else if (salary < 35000) {
                category = "Low";
            } else if (salary < 70000) {
                category = "Medium";
            } else {
                category = "High";
            }

            System.out.printf("%10s %10s %4s %3d %9.2f %8s%n", firstName, lastName, id, age, salary, category);

        }

    }
}
