
import CitationPackage.*;
import UserPackage.UserList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class hw2Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final HashMap<String, String> configData = readConfigFile();
    // private static final String FILENAME;
    private static UserList userList = new UserList();
    private static CitationList citationList;

    public static void main(String[] args) throws Exception {
        citationList = new CitationList();
        citationList.readCitationFile( configData.get("input file") ); //Load Citations from CSV
        userList.readUserFile( configData.get("user file") ); // Load Users from CSV

        int input = 2;
        int uid; //used for user ID
        while (input != 0) {
            input = Menu.displayMenu(scanner);
            try {
                //Handle input to call funciton
                switch (input) {
                    // Exit
                    case 0:
                        System.out.println("Saving...");
                        citationList.writeCitationFile( configData.get("output file") );
                        break;
                    
                    // Display all info
                    case 1:
                        System.out.println(citationList);
                        break;

                    // Display all of a certain type
                    case 2:
                        System.out.print("Enter the Offense Type: ");
                        System.out.println(
                            citationList.displayCitationType( scanner.nextLine() )
                        );
                        break;
                    
                    // Search by ID
                    case 3:
                        System.out.print("Enter the citation number: ");
                        System.out.println(
                            citationList.displayCitation( Integer.parseInt(scanner.nextLine()) )
                        );
                        break;

                    // Search by last name
                    case 4:
                        System.out.print("Enter the person last name: ");
                        citationList.displayCitation( scanner.nextLine() );
                        break;

                    // Add a new citation
                    case 5:
                        citationList.newCitation( scanner );
                        break;

                    // Delete Citation
                    case 6:
                        uid = Menu.promptInt(scanner,"Type citation number: ");
                        citationList.delete(uid);
                        break;

                    // Sort by number
                    case 7:
                        citationList.sortByNumber();
                        break;

                    // Sort by first name
                    case 8:
                        citationList.sortByName();
                        break;
                    
                    // Sort by offense type
                    case 9:
                        citationList.sortByType();
                        break;

                    // Citations by User
                    case 10:
                        uid = Menu.promptUserID(scanner, userList);
                        System.out.println( citationList.findByUser(uid) );
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


    /**
     * Read configuration file to get address of different files that will be read
     * @return map of each file needed andits location
     */
    private static HashMap<String, String> readConfigFile( ) {
        File file = new File("configuration.csv");
        Scanner configScanner;
        HashMap<String, String> ans = new HashMap<>();
        //Try opening csv
        try {
            configScanner = new Scanner(file);

            while(configScanner.hasNextLine()){
                String line = configScanner.nextLine();

                String[] columns = line.split(",");
                String type = columns[0];
                String address = columns[1];
                ans.put(type, address);
            }
        } catch (FileNotFoundException e) { // File name not found
            System.out.println("Error: PLease include configuration.csv");
            
        } catch (NumberFormatException e) { // Error Converting String to INT
            System.out.println("Error: One of the CSV values couldn't be converted to a string");
        }
        return ans;
    }
}
