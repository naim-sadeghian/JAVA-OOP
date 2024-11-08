
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;


public class CitationList {
    String title ;
    String authority ;
    ArrayList<Citation> listOfCitations;


    /**
     * Builds the listOfCitations using a CSV file called <filename>
     * @param filename 
     */
    public void readCitationFile(String filename) {
        File file = new File(filename);
        Scanner scanner;
        //Try opening csv
        try {
            scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();

                String[] columns = line.split(",");

                // Create Person instance from fields
                Person auxPerson = new Person(
                    columns[4], 
                    columns[5], 
                    columns[6], 
                    columns[7]
                );


                // Create citation instance from fields
                Citation auxCitation = new Citation(
                    columns[1], 
                    columns[2], 
                    Integer.parseInt(columns[0]), 
                    columns[3], 
                    auxPerson
                );

                // Add citation to list
                listOfCitations.add(auxCitation);
            }
        } catch (FileNotFoundException e) { // File name not found
            System.out.println("Error: No CSV found under that name!");
            
        } catch (NumberFormatException e) { // Error Converting String to INT
            System.out.println("Error: One of the CSV values couldn't be converted to a string");
        }

        
    }

    /**
     * Uses a citation ID to display the corresponding citation
     * @param number
     */
    public void displayCitation(int number) {
        // Assuming the list wont always be ordered proceed with secuential search
        // for (Citation citation : listOfCitations) {
        //     if (citation.getNumber() == number) {
        //         System.out.println(citation.toString(true)); // Include person in print
        //         return;
        //     }
        // }
        // We can make sure that the citations are 1 indexed and that there wont be any gaps 
        // in ascending IDs when saving. 
        if (number <= 0 || number > listOfCitations.size()) {
            System.out.println("No citation found under number: " + number);
        } else {
            System.out.println(listOfCitations.get(number-1).toString(true)); // Include person in print

        }
        
    }

    /**
     * Displays all of the citations associated to a lastname
     * @param lastName last name of person
     */
    public void displayCitation(String lastName) {
        boolean found = false;
        for (Citation citation : listOfCitations) {
            if ( lastName.equals( citation.getPerson().getLastName() ) ) {
                System.out.println(citation.toString(true)); // Include person in print
                if (!found) found = true;
            }
        }
        if (!found) System.out.println("No citation found under lastname: " + lastName);
    }

    /**
     * Display all of the citations by given type of offense
     * @param typeOfOffense 
     */
    public void displayCitationType(String typeOfOffense) {
        boolean found = false;
        for (Citation citation : listOfCitations) {
            if ( typeOfOffense.equals( citation.getTypeOfOffense() ) ) {
                System.out.println(citation);
                if (!found) found = true;
            }
        }
        if (!found) System.out.println("No citations found for offenseL " + typeOfOffense);
    }

    /**
     * Writes to listOfCitations to a CSV file called <filename>
     * @param filename 
     */
    public void writeCitationFile(String filename) {
        try {
            // Open file writer
            BufferedWriter writer = new BufferedWriter( new FileWriter(filename) ) ;

            for (Citation citation : listOfCitations) {
                writer.write(citation.toCSV()); // Call CSV transforming functions
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            // Handle exceptions related to file operations
            System.out.println("Error writing to file: " + e.getMessage());
            // e.printStackTrace();
        }
        
    }

    public void newCitation(Scanner scanner) {
        
        // Citation Fields
        System.out.print("- Type of Offense: ");
        String type = scanner.nextLine();

        System.out.print("- Description: ");
        String desc = scanner.nextLine();

        System.out.print("- Date: ");
        String date = scanner.nextLine();

        // Person Fields
        System.out.print("- Person's First Name: ");
        String fName = scanner.nextLine();

        System.out.print("- Person's Last Name: ");
        String lName = scanner.nextLine();

        System.out.print("- Person's Address: ");
        String address = scanner.nextLine();

        System.out.print("- Person's Phone Number: ");
        String number = scanner.nextLine();

        Person newPerson = new Person(fName, lName, address, number);

        Citation newCitation = new Citation(type, desc, listOfCitations.size()+1, date, newPerson);

        //add citation
        listOfCitations.add(newCitation);
    
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthority() {
        return authority;
    }

    public ArrayList<Citation> getListOfCitations(){
        return listOfCitations;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public CitationList(String title, String authority) {
        this.title = title;
        this.authority = authority;
        this.listOfCitations = new ArrayList<Citation>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(title+" "+authority+"\n");
        for (Citation citation : listOfCitations) {
            sb.append(citation);
            sb.append("\n");
        }
        return sb.toString();
    }

    
    
}
