package UserPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserList {
    ArrayList<User> listOfUsers;

    // FOr testing
    public ArrayList<User> getListOfUsers(){
        return listOfUsers;
    }

    /**
     * Builds the listOfUsers using a CSV file called <filename>
     * @param filename 
     */
    public void readUserFile(String filename) {
        File file = new File(filename);
        Scanner scanner;
        //Try opening csv
        try {
            scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();

                String[] columns = line.split(",");
                // User UserFactory to create correct type of user
                User newUser = UserFactory.createUser(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3]);
                listOfUsers.add(newUser);
            }

        } catch (FileNotFoundException e) { // File name not found
            System.out.println("Error: No CSV found under that name!");
            
        } catch (NumberFormatException e) { // Error Converting String to INT
            System.out.println("Error: One of the CSV values couldn't be converted to a string");
        }

        
    }

    

    public UserList() {
        this.listOfUsers = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (User user : listOfUsers) {
            sb.append("=========( User: ").append(i).append(" )=========\n");
            sb.append(user);
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }
}
