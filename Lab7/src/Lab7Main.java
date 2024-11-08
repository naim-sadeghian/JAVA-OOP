/*
 * Name: Naim Sadeghian
 * ID: nsadeghi
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab7Main {
    private File myFile = null;
    private Scanner fileScanner = null;
    private ArrayList<YearPop> data = null;

    public void createList() {
        data = new ArrayList<YearPop>();
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            data.add( YearPop.makeData(line) ); //Add a new YearPop using data
        }
    }

    public double findYear(int year) {
        double pos = -1.0;
        int left = 0;
        int right = data.size();
        int middle;

        while (left <= right) {
            middle = (left + right) / 2; // find middle
            int year_mid = data.get(middle).getYear();

            if ( year_mid == year) {
                pos = middle;
                break;

            } else if (year_mid < year) {
                left = middle+1;
                
            } else {
                right = middle-1;
            }
        }
        return pos;
    }

    public boolean openFile(String filename) {
        myFile = new File(filename);
        try {
            fileScanner = new Scanner(myFile);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int computeFibonacci(int first, int second, int n) {
        if (n == 0) {
            return first;
        } else {
            return computeFibonacci(second, first + second, n - 1);
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner inputScanner = new Scanner(System.in);
        Lab7Main main = new Lab7Main();
        if ( main.openFile("paPop.csv") ) {
            main.createList();
        }

        String input = "Y";
        // Get input for finding year
        while (!input.equals("N")){
            System.out.print("Enter a year to search: ");
            int year = inputScanner.nextInt();
            int pos = (int) main.findYear(year);
            if (pos >= 0) {
                System.out.println("Year: " + year);
                System.out.println("Population density: " + main.data.get(pos).getPop());

            } else {
                System.out.println("Year: " + year + " was not found!");
            }
            
            System.out.print("Want to look for another year? (Y or N): ");
            inputScanner.nextLine(); //read /n
            input = inputScanner.nextLine().toUpperCase();
        }
    }
}
