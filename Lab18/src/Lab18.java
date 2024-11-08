import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Lab18 {
    public static ArrayList<Customer> readCustomers(String filename) throws IOException {

        // Array list of Customer objects
        ArrayList<Customer> list = new ArrayList<>();
        


        // While fileScanner has a next line
        // Read the next line and split it
        // Convert the rating to an int; throw NumberFormatException if bad
        // Convert the balance to a double; throw NumberFormatException if bad
        // Create a new customer object, add it to list

        // Create a new File object
        File file = new File(filename);
        Scanner fileScanner;
        //Try opening csv
        try {
            // Create a new Scanner on the file object
            fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
    
                String[] columns = line.split(",");
                Customer newC = new Customer(columns[0], columns[1], Integer.parseInt(columns[2]), Double.parseDouble(columns[3]));
                list.add(newC);
            }
        } catch (FileNotFoundException e) { // File name not found
            System.out.println("Error: No CSV found under that name!");
            
        } catch (NumberFormatException e) { // Error Converting String to INT
            System.out.println("Error: One of the CSV values couldn't be converted to a string");
        }

        return list;
    }

    public static void main(String[] args) {
        ArrayList<Customer> clist = null;
        // Problem 3
        // Call readCustomers with the data file as a parameter
        System.out.println(RatingType.LOW);
        System.out.println(RatingType.MEDIUM);
        System.out.println(RatingType.HIGH);


        try {
            clist = readCustomers("customers.csv");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        

        // Print the array list
        System.out.println("Original list");
        for(Customer c : clist) {
            System.out.println(c);
        }

        // Problem #4
        // Create PriorityQueue queue1
        PriorityQueue<Customer> queue1 = new PriorityQueue<>();
        for(Customer c : clist) {
            try { 
                queue1.add(c); 
            } catch(ClassCastException e){
                System.out.println(e.getMessage());
                return;
            }
            
        }

        // Problem #5
        // Create PriorityQueue queue2
        PriorityQueue<Customer> queue2 = new PriorityQueue<>(new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                // Custom comparison logic here
                return Double.compare( c1.getBalance(), c2.getBalance() );
            }
        });
        for(Customer c : clist) {
            try { 
                queue2.add(c); 
            } catch(ClassCastException e){
                System.out.println(e.getMessage());
                return;
            }
            
        }

        // Problem #6
        // Remove things one at a time from queue1 and print them
        System.out.println("Queue1 processing");
        while (!queue1.isEmpty()) {
            Customer c = queue1.poll(); // Retrieve and remove the highest-priority element
            System.out.println(c); // Print the element
        }

        // Problem #7
        // Remove things one at a time from queue2 and print them
        System.out.println("Queue2 processing");
        while (!queue2.isEmpty()) {
            Customer c = queue2.poll(); // Retrieve and remove the highest-priority element
            System.out.println(c); // Print the element
        }

        // Problem #8
        // Try this on your own

        // Problem #9
        problem9();
        
    }


    public static void problem9() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> patterns = new ArrayList<>();

        // Read lines from testdata.txt
        File file = new File("testdata.txt");
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) { // File name not found
            System.out.println("Error: No CSV found under that name!");
            
        }
            
        // Display the lines
        System.out.println("Lines from testdata.txt:");
        lines.forEach(System.out::println); //Print lines
        
        // Define the patterns
        patterns.add(".*\\d.*");                // Contains any digit
        patterns.add(".*[a-zA-Z].*");           // Contains any letter (either case)
        patterns.add("^-?\\d+$");               // Contains an integer (positive or negative)
        patterns.add("^a.*");                   // Begins with the letter "a"
        patterns.add(".*s$");                   // Ends with the letter "s"
        patterns.add(".*\\(.*");                // Contains a left parenthesis
        patterns.add(".*a.*e.*|.*e.*a.*");      // Contains both "a" and "e" in either order
        patterns.add(".*aeiou.*");              // Lowercase vowels next to each other in order
        patterns.add(".*a.*e.*i.*o.*u.*");      // Lowercase vowels in order, not necessarily together
        
        // Loop over each pattern and check each line
        for (String patternString : patterns) {
            System.out.println("\nPattern: " + patternString);
            Pattern pattern = Pattern.compile(patternString);

            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("Matched: " + line);
                }
            }
        }
    }
}
