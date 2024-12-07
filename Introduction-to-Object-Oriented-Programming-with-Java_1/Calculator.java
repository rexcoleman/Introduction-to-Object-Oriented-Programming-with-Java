import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Define constant error message - using final to ensure it can't be modified
        final String ERROR_MESSAGE = "Invalid input entered. Terminating...";
        
        Scanner scan = new Scanner(System.in);
        
        // Print menu of operations
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        
        // Get operation and convert to lowercase for case-insensitive comparison
        String operation = scan.nextLine().toLowerCase();
        
        // Use switch statement to handle different operations
        switch (operation) {
            case "add":
                System.out.println("Enter two integers:");
                // Check if input is valid integers using hasNextInt()
                if (scan.hasNextInt()) {
                    int num1 = scan.nextInt();
                    if (scan.hasNextInt()) {
                        int num2 = scan.nextInt();
                        System.out.println("Answer: " + (num1 + num2));
                    } else {
                        System.out.println(ERROR_MESSAGE);
                    }
                } else {
                    System.out.println(ERROR_MESSAGE);
                }
                break;
                
            case "subtract":
                System.out.println("Enter two integers:");
                if (scan.hasNextInt()) {
                    int num1 = scan.nextInt();
                    if (scan.hasNextInt()) {
                        int num2 = scan.nextInt();
                        System.out.println("Answer: " + (num1 - num2));
                    } else {
                        System.out.println(ERROR_MESSAGE);
                    }
                } else {
                    System.out.println(ERROR_MESSAGE);
                }
                break;
                
            case "multiply":
                System.out.println("Enter two doubles:");
                if (scan.hasNextDouble()) {
                    double num1 = scan.nextDouble();
                    if (scan.hasNextDouble()) {
                        double num2 = scan.nextDouble();
                        System.out.printf("Answer: %.2f\n", num1 * num2);
                    } else {
                        System.out.println(ERROR_MESSAGE);
                    }
                } else {
                    System.out.println(ERROR_MESSAGE);
                }
                break;
                
            case "divide":
                System.out.println("Enter two doubles:");
                if (scan.hasNextDouble()) {
                    double num1 = scan.nextDouble();
                    if (scan.hasNextDouble()) {
                        double num2 = scan.nextDouble();
                        // Check for division by zero
                        if (num2 == 0) {
                            System.out.println(ERROR_MESSAGE);
                        } else {
                            System.out.printf("Answer: %.2f\n", num1 / num2);
                        }
                    } else {
                        System.out.println(ERROR_MESSAGE);
                    }
                } else {
                    System.out.println(ERROR_MESSAGE);
                }
                break;
                
            case "alphabetize":
                System.out.println("Enter two words:");
                String word1 = scan.next().toLowerCase();
                String word2 = scan.next().toLowerCase();
                // Use compareTo to determine lexicographic ordering
                int comparison = word1.compareTo(word2);
                if (comparison == 0) {
                    System.out.println("Answer: Chicken or Egg.");
                } else if (comparison < 0) {
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", 
                                    word1, word2);
                } else {
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", 
                                    word2, word1);
                }
                break;
                
            default:
                System.out.println(ERROR_MESSAGE);
        }
    }
}