// Name: Naim Sadeghian
// ID: nsadeghi

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) throws Exception {
        // Initialize Classes
        Sensor temperature = new Sensor(0.0, 120.0, 68.0, 1.0, "kitchen", "temperature", 1);
        Device extinguisher = new Device("fire extinguisher", "kitchen", 1);
        Room kitchen = new Room(12.0, 15.0, "kitchen", 1);
        Alarm bell = new Alarm("Ding! Ding!", 1);

        // Display toString()
        System.out.println("============ (Initial Values) ====================");
        System.out.println(temperature.toString());
        System.out.println(extinguisher.toString());
        System.out.println(kitchen.toString());
        System.out.println(bell.toString());

        //Welcome
        System.out.println();
        System.out.println("============ (Welcome) ====================");
        System.out.println("Welcome to the system. Here is your room info:");
        System.out.println(kitchen.toString());

        String input = "Y";
        Scanner scanner = new Scanner(System.in);
        while (input.equals("Y")){
            System.out.println("The current temperature is: " + temperature.getCurrentValue());
            System.out.print("Do you want to change the temperature?: ");
            input = scanner.nextLine().toUpperCase();
            // Check input
            if(!input.equals("Y") && !input.equals("N")) {
                System.out.println("Please type 'Y' or 'N'...");
                input = "Y";
                continue;
            }

            double prev_temp = temperature.getCurrentValue(); //save previous temp

            //get temp
            System.out.print("Enter the new room temperature: ");
            temperature.setCurrentValue( scanner.nextDouble() );
            scanner.nextLine();

            //Trip alarm?
            if (temperature.trip()) {
                extinguisher.actuate(); 
                bell.soundTheAlarm();
                temperature.setCurrentValue(prev_temp); //return to previous value
            }


            System.err.println("");

        }
        scanner.close();

    }
}


/**
 * The classes, as they currently work in the main, have to communicate through logic written in the main. 
 * The main is in charge of checking the other classes and calling their functions. When in reality, these
 * classes are related and there is a hierarchy to them. It would make sense that Device Alarm and Sensor
 * are a part of the Room class. Right now the classes are independant and working on the same level. It 
 * would make more sense that, in the main, we only call 1 change temperature method and that internally 
 * the Room class is able to trip the sensor, activate the alarm and the extinguisher. 
 * 
 * The Room class would have to be able to store each one of these other classes as an attribute. In the
 * main, we would have to initialize a Sensor, Device and Alarm to be able to assign it to a Room attribute
 * when the Room is initialized. Then we can call a room functmethod ion to update the temperature and internally
 * it would hold a similar logic to the one currently in the main.
 */