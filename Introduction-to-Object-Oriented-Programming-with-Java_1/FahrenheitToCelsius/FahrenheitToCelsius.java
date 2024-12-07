import java.util.Scanner;

public class FahrenheitToCelsius {
	public static void main(String[] args) {
		final int MAX_TEMP = 140;
		final int MIN_PARK_TEMP = 70;
		final int MAX_PARK_TEMP = 90;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Fahrenheit value: ");
		int fahrenheit = input.nextInt();

		while (fahrenheit >= MAX_TEMP) {
			System.out.println("Error: The Fahrenheit value must be less than " 
							   + MAX_TEMP);
			System.out.println("Please enter another Fahrenheit value: ");
			fahrenheit = input.nextInt();
		}


		input.nextLine(); // cleans up new line at the end of the user input
		System.out.print("Enter a day of the week along with the month, day, and year: ");
		String day = input.nextLine();
		double celsius = (5.0/9) * (fahrenheit - 32);

		System.out.println(day + " Fahrenheit: " + fahrenheit);
		System.out.printf("%s %.1f \n", day + " Celsius:", celsius);
		// System.out.println(day + " Celsius: " + celsius);
        if ((fahrenheit >= 86) 	&& (fahrenheit <= 95)) 
			System.out.print("Go to the swimming pool");
		else if ((fahrenheit >= 70) && (fahrenheit < 86)) 
			System.out.print("Go to the park");
		else if ((fahrenheit >= 50) && (fahrenheit < 70)) 
			System.out.print("Lounge on the patio");
		else if ((fahrenheit >= 32) && (fahrenheit < 50)) 
			System.out.print("Make a snowman?");
		System.out.print("Bye");
    }
}
