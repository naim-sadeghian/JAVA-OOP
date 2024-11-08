import java.util.Scanner;

// Your name: Naim Sadeghian
// Your Andrew id: nsadeghi

// class RelativeHumidity
// Prompts the user for the temperature and dewpoint in Fahrenheit.
// Converts them to Celsius.
// Computes the saturation for each.
// Computes and displays the relative humidity.
public class RelativeHumidity {

	public static void main(String[] args) {

        // Don't change this code
		RelativeHumidity relativeHumidity = new RelativeHumidity();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the temperature in Fahrenheit: ");
		double temperature = scanner.nextDouble();
		System.out.print("Enter the dewpoint in Fahrenheit: ");
		double dewpoint = scanner.nextDouble();
		System.out.println("You entered:");
		System.out.println("temperature: " + temperature);
		System.out.println("dewpoint: " + dewpoint);
		
        // Convert to Celsius
        double c_temp = (5/9.0) * (temperature - 32);
		double c_dew = (5/9.0) * (dewpoint - 32);

        // Compute the saturations sT (temperature) and sD (dewpoint)
        double s_temp = Math.exp( 17.625 * c_temp / (243.04 + c_temp ) );
		double s_dew = Math.exp( 17.625 * c_dew / (243.04 + c_dew ) );

        // Compute the relative humidity
        double rh = 100 * s_dew / s_temp;

		System.out.println("Relative Humidity is: " + rh);


	}
	
}
