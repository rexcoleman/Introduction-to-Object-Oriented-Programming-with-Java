import java.util.Scanner;
import java.util. InputMismatchException;


public class FahrenheitToCelsiusExceptions_ExceptionControlLoop {

    public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                boolean success = false;
            int fahrenheit = 0;

                while (!success) {
                    try {
                        System.out.print("Enter a Fahrenheit value: ");
                        fahrenheit = input.nextInt();
                        success = true;
                    }
                    catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.println("Sorry, that wasn't an integer.");
                        System.out.println("Please try again.");
                    }
                    finally {
                        input.nextLine();
                    }
                }
            System.out.println("Enter a day of the week.");
            String day = input.nextLine();
            double celsius = (5.0/9) * (fahrenheit - 32);
            System.out.printf("Fahrenheit: %d\n", fahrenheit);
            System.out.printf("Celsius: %.1f\n", celsius);
            
    }
}
