import java.util.Scanner;

public class Lab13Driver {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws BadWeekday {
        
        // 1
        System.out.println("Problem 1");
        problem1();
        System.out.println();

        // 2
        System.out.println("Problem 2");
        try {
            problem2();
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // 3
        System.out.println("Problem 3");
        problem3();
        System.out.println();

        // 4
        System.out.println("Problem 4");
        try {
            problem4();
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // 5
        System.out.println("Problem 5");
        try {
            problem5();
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // 6
        System.out.println("Problem 6");
        problem6(); //ultimately isn't caught as it reaches the top of the call stack
        System.out.println();
    }

    public static void problem1() {
        System.out.print("Enter a day of the week: ");
        String entry = scanner.nextLine();
        if (!BadWeekday.WEEKDAYS.contains(entry)) {
            // throw new BadWeekday("You entered: "+entry);
            System.out.println("Bad day entered");

        } else {
            System.out.println("Nice job!");
        }
    }

    public static void problem2() throws BadWeekday {
        System.out.print("Enter a day of the week: ");
        String entry = scanner.nextLine();
        if (!BadWeekday.WEEKDAYS.contains(entry)) {
            throw new BadWeekday("Bad day entered");
        } else {
            System.out.println("Nice job!");
        }
    }

    public static void problem3() {
        try {
            problem2();
        } catch (BadWeekday e) {
            System.out.println(e.getMessage());
        }
    }

    public static void problem4() throws BadWeekday {
        problem2();
    }

    public static void problem5() throws BadWeekday {
        try {
            problem2();
        } catch (BadWeekday e) {
            System.out.println("Caught"+e.getMessage());
            throw e;
        }
    }

    public static void problem6() throws BadWeekday {
        problem2();
    }
}
