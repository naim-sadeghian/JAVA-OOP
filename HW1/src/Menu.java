
import java.util.Scanner;

public class Menu {
    private static String[] menuChoices = {
        "Quit",
        "Display all the Citation data.",
        "Display all Citations by type.",
        "Search for a Citation by number.",
        "Search for a Citation by Person last name.",
        "Add a new Citation.",
    };

    /**
     *  Display menu and take input. 
     *  @return value of input option | 0 if there is an error
     */
    static int displayMenu(Scanner scanner) {
        
        for (int i = 0; i < menuChoices.length; i++) {
            System.out.println((i+1) + ". " + menuChoices[i]);
        }
        System.out.print("Enter an option (1-6): ");
        // Take Input
        try {
            int option = Integer.parseInt(scanner.nextLine());
            if (option < 0 || option > menuChoices.length) {
                return 0;
            } else {
                return option;
            }
        } catch (NumberFormatException e) {
            //handle non-int input
            return 0;
        }

        
    }
    
    
}
