
import UserPackage.UserList;
import java.util.Scanner;

public class Menu {
    private static String[] menuChoices = {
        "Quit",
        "Display all the Citation data.",
        "Display all Citations by type.",
        "Search for a Citation by number.",
        "Search for a Citation by Person last name.",
        "Add a new Citation.",
        "Delete Citation.",
        "Sort Citations by Number",
        "Sort Citations by First Name",
        "Sort Citations by Offense Type",
        "Find Citations related to User"
    };

    /**
     *  Display menu and take input. 
     *  @return value of input option | 0 if there is an error
     */
    static int displayMenu(Scanner scanner) {
        
        for (int i = 0; i < menuChoices.length; i++) {
            System.out.println((i) + ". " + menuChoices[i]);
        }
        System.out.print("Enter an option (1-10): ");
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

    /**
     *  Display menu and take input. 
     *  @return value of input option | 0 if there is an error
     */
    static int promptInt(Scanner scanner, String message) {
        
        System.out.print(message);
        int ans = -1;
        while (true) {
            try {
                ans = Integer.parseInt(scanner.nextLine());
                break;  // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.print("Error: Input should be an integer. Please try again:");
            }
        }
        return ans;
        
    }

    /**
     * Display Users and call promptInt to ask for an int input
     * @param scanner Sistem.in scanner
     * @param userList list of users
     * @return
     */
    static int promptUserID(Scanner scanner, UserList userList) {
        System.out.println(userList);
        return promptInt(scanner, "Type ID of user: ");
        

    }
    
    
}
