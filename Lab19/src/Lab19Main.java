import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab19Main {
    public static void main(String[] args) throws Exception {
        // n = 10000
        int n = 10000;
        System.out.println("=========== ( n = 10000 )======================");
        System.out.printf("%-18s: %15d\n", "printWriterTest", printWriterTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "bufferWriterTest", bufferWriterTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "fileWriterTest", fileWriterTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "scannerTest", scannerTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "bufferedReaderTest", bufferedReaderTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "fileReaderTest", fileReaderTest("test.txt", n) );

        // n = 1000000
        n = 1000000;
        System.out.println("=========== ( n = 1000000 )======================");
        System.out.printf("%-18s: %15d\n", "printWriterTest", printWriterTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "bufferWriterTest", bufferWriterTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "fileWriterTest", fileWriterTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "scannerTest", scannerTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "bufferedReaderTest", bufferedReaderTest("test.txt", n) );
        System.out.printf("%-18s: %15d\n", "fileReaderTest", fileReaderTest("test.txt", n) );
    }

    public static long printWriterTest(String filename, int n){
        long startTime = System.nanoTime();
        try( PrintWriter writer = new PrintWriter(
            new BufferedWriter(
                new FileWriter(filename)
            )
        )) {
            for(int i=0; i < n; i++){
                writer.print("A");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }   
        
        return System.nanoTime() - startTime;
    }

    public static long bufferWriterTest(String filename, int n){
        long startTime = System.nanoTime();
        try( BufferedWriter writer = new BufferedWriter(
                new FileWriter(filename)
        )) {
            for(int i=0; i < n; i++){
                writer.write("A");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }   
        
        return System.nanoTime() - startTime;
    }

    public static long fileWriterTest(String filename, int n){
        long startTime = System.nanoTime();
        try( FileWriter writer = new FileWriter(filename) ) {
            for(int i=0; i < n; i++){
                writer.write("A");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }   
        
        return System.nanoTime() - startTime;
    }

    public static long scannerTest(String filename, int n){
        long startTime = System.nanoTime();
        try( Scanner scanner = new Scanner(
            new BufferedReader(
                new FileReader(filename)
            )
        )) {
            scanner.useDelimiter("");
            for(int i=0; i < n; i++){
                scanner.next().charAt(0);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }   
        
        return System.nanoTime() - startTime;
    }

    public static long bufferedReaderTest(String filename, int n){
        long startTime = System.nanoTime();
        try( BufferedReader scanner = new BufferedReader(
                new FileReader(filename)
            )
        ) {
            for(int i=0; i < n; i++){
                scanner.read();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }   
        
        return System.nanoTime() - startTime;
    }

    public static long fileReaderTest(String filename, int n){
        long startTime = System.nanoTime();
        try( FileReader scanner = new FileReader(filename) ) {
            for(int i=0; i < n; i++){
                scanner.read();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }   
        
        return System.nanoTime() - startTime;
    }
}
