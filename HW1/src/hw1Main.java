
import java.util.Scanner;

public class hw1Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILENAME = "citations.csv";

    public static void main(String[] args) throws Exception {
        CitationList citationList = new CitationList("Chief", "Barrett");
        citationList.readCitationFile(FILENAME); //Load Citations from CSV

        int input = 2;
        while (input != 1) {
            input = Menu.displayMenu(scanner);
            try {
                //Handle input to call funciton
                switch (input) {
                    // Exit
                    case 1:
                        System.out.println("Saving...");
                        citationList.writeCitationFile(FILENAME);
                        break;
                    
                    // Display all info
                    case 2:
                        System.out.println(citationList);
                        break;

                    // Display all of a certain type
                    case 3:
                        System.out.print("Enter the Offense Type: ");
                        citationList.displayCitationType( scanner.nextLine() );
                        break;
                    
                    // Search by ID
                    case 4:
                        System.out.print("Enter the citation number: ");
                        citationList.displayCitation( Integer.parseInt(scanner.nextLine()) );
                        break;

                    // Search by last name
                    case 5:
                        System.out.print("Enter the person last name: ");
                        citationList.displayCitation( scanner.nextLine() );
                        break;

                    // Add a new citation
                    case 6:
                        citationList.newCitation( scanner );
                        break;
                    default:
                        System.out.println("Please enter one of the numbers next to an option.\n");
                }
            } catch (NumberFormatException e) {
                //handle non-int input
                System.out.println("Error: Make sure to enter correct data type\n");

            }
            
        }
    }
}
