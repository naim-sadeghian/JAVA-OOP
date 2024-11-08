// Lab4
// Your name: Naim Sadeghian
// Your Andrew id: nsadeghi


import java.util.Scanner;

public class IfSwitch {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int feet, inches, totalHeight;
        int height;
        String gender;

        System.out.println("Height Comparison");
        System.out.println("You'll be asked for your height as feet and inches");
        System.out.print("Enter the feet part of your height: ");
        feet = scanner.nextInt();
        System.out.print("Enter the inches part of your height: ");
        inches = scanner.nextInt();
        System.out.println("You entered " + feet + " ft " + inches + " inches");

        // 3
        height = (feet * 12) + inches;
        System.out.println("Total height in inches: " + height + " inches");

        // 4
        System.out.print("Enter your gender (M or F): ");

        scanner.nextLine(); // read remaining \n in buffer
        gender = scanner.nextLine().toUpperCase();
        
        if ( !( gender.equals("M") || gender.equals("F") ) ) {
            gender = "F";   
        }
        System.out.println("Your gender is " + gender);

        // 5
        int average = 64; // default female average
        if (gender.equals("M")) {
            average = 69; // male average
        }
        
        if (height < average) {
            System.out.println("you're shorter than average");
        } else {
            System.out.println("you're taller than average");
        }

        // 6 
        if ( height < 21 || height > 107 ){
            System.out.println("Error! Height out of bounds");
            height = average;
        }

        // 7 
        switch (gender) {
            case "M":
                if (height < 69) {
                    System.out.println("you're shorter than average");
                } else {
                    System.out.println("you're taller than average");
                }
                break;
            case "F":
                if (height < 64) {
                    System.out.println("you're shorter than average");
                } else {
                    System.out.println("you're taller than average");
                }
                break;
            default:
                System.out.println("Error!");
        }

        // 8 
        System.out.print("Enter a test score out of 100: ");
        int grade = scanner.nextInt();
        char letter;

        // Check for out of bounds
        if (grade > 100 || grade < 0){
            System.out.println("Error! Grade is out of bounds");
        }
        // Convter to letter grade
        if (grade >= 90){
            letter = 'A';
        } else if (grade >= 80) {
            letter = 'B';
        } else if (grade >= 70) {
            letter = 'C';
        } else if (grade >= 60) {
            letter = 'D';
        } else {
            letter = 'E';
        }

        int gpa = 0;
        switch (letter) {
            case 'A':
                gpa = 4;
                break;
            case 'B':
                gpa = 3;
                break;
            case 'C':
                gpa = 2;
                break;
            case 'D':
                gpa = 1;
                break;
            case 'E':
                gpa = 0;
                break;

        }
        System.out.println("Your GPA is: " + gpa);



    }
}
