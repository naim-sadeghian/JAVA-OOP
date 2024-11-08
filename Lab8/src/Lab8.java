
public class Lab8 {
    public static void main(String[] args) throws Exception {
        // Initialize Classes
        
        Device extinguisher = new Device("fire extinguisher", "kitchen", 1);
        Room room1 = new Room(12.0, 15.0, "kitchen", 1);
        room1.addDevice(extinguisher);

        //Add sensors
        for (int i = 0; i < 5; i++) {
            Sensor sTemp = new Sensor(0.0, 120.0, 68.0, 1.0, "kitchen", "temperature", i+1);
            room1.addSensor(sTemp);
        }

        //Add alarmss
        for (int i = 0; i < 3; i++) {
            Alarm bell = new Alarm("Ding! Ding!", i+1);
            room1.addAlarm(bell);
        }
  
        room1.display();

        room1.addDevice(new Device("foamer", "kitchen", 1));

        System.out.println("====================== ( With Device) ==========================");
        room1.display();


        // String input = "Y";
        // Scanner scanner = new Scanner(System.in);
        // while (input.equals("Y")){
        //     System.out.println("The current temperature is: " + temperature.getCurrentValue());
        //     System.out.print("Do you want to change the temperature?: ");
        //     input = scanner.nextLine().toUpperCase();
        //     // Check input
        //     if(!input.equals("Y") && !input.equals("N")) {
        //         System.out.println("Please type 'Y' or 'N'...");
        //         input = "Y";
        //         continue;
        //     }

        //     double prev_temp = temperature.getCurrentValue(); //save previous temp

        //     //get temp
        //     System.out.print("Enter the new room temperature: ");
        //     temperature.setCurrentValue( scanner.nextDouble() );
        //     scanner.nextLine();

        //     //Trip alarm?
        //     if (temperature.trip()) {
        //         extinguisher.actuate(); 
        //         bell.soundTheAlarm();
        //         temperature.setCurrentValue(prev_temp); //return to previous value
        //     }


        //     System.err.println("");

        // }
        // scanner.close();

    }
}
