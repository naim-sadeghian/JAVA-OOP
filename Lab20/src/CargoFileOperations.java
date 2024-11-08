import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CargoFileOperations {
    String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public void writeList(ArrayList<Cargo> list) {
        try( ObjectOutputStream stream = new ObjectOutputStream(
            new FileOutputStream(filename)
        )){
            try {
                stream.writeObject(list);
            } catch (IOException e) {
                System.out.println("Error writing Cargo object to file: " + e.getMessage());
                return;
            }

            
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + filename);
            return;
        } catch (IOException e) {
            System.out.println("Error initializing ObjectOutputStream: " + e.getMessage());
            return;

        }
    }

    public ArrayList<Cargo> readList() {
        ArrayList<Cargo> list = new ArrayList<>();
        FileInputStream fileInput = null;
        ObjectInputStream objectInput = null;
        
        try {
            try {
                fileInput = new FileInputStream(filename);
                objectInput = new ObjectInputStream(fileInput);
            } catch (FileNotFoundException e) {
                System.out.println("Input file not found: " + filename);
                return list;  // Return an empty list if the file cannot be found
            } catch (IOException e) {
                System.out.println("Error initializing ObjectInputStream: " + e.getMessage());
                return list;
            }
            
            try {
                while (fileInput.available() > 0) {
                    // Read and cast each object to Cargo, adding to the list
                    list = (ArrayList<Cargo>) objectInput.readObject();
                }
            } catch (EOFException e) {
                // End of file reached; no more objects to read
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found during deserialization: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading Cargo object from file: " + e.getMessage());
            }
        } finally {
            // Close the ObjectInputStream and FileInputStream, if they were opened
            if (objectInput != null) {
                try {
                    fileInput.close();
                    objectInput.close();
                } catch (IOException e) {
                    System.out.println("Error closing ObjectInputStream: " + e.getMessage());
                }
            }
        }

        return list;
    }

     public void display(){
        // Declare a Path object using Paths.get() on the filename
        Path path = Paths.get(filename);
        
        // Display Path-related information
        System.out.println("Path toString(): " + path.toString());
        System.out.println("Absolute path: " + path.toAbsolutePath());
        System.out.println("Root of path: " + path.getRoot());

        // Declare a File object using the Path object
        File file = path.toFile();
        
        // Display File-related information
        System.out.println("isDirectory() returns: " + file.isDirectory());
        System.out.println("getAbsolutePath() returns: " + file.getAbsolutePath());

        // Display permissions on the Path variable
        System.out.println("isExecutable() returns: " + file.canExecute());
        System.out.println("isReadable() returns: " + file.canRead());
        System.out.println("isWritable() returns: " + file.canWrite());
        
    }
}
