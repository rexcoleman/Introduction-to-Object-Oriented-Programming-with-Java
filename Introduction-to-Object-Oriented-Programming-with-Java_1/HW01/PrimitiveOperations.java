public class PrimitiveOperations {
    public static void main(String[] args) {
        // Step 1: Declare and initialize an integer and floating point value
        int myInteger = 42;
        double myDouble = 3.14;
        System.out.println(myInteger);
        System.out.println(myDouble);

        // Step 2: Multiply the variables together
        double product = myInteger * myDouble;  // Using double to avoid data loss
        System.out.println(product);

        // Step 3: Cast integer to floating point
        double intToDouble = (double) myInteger;
        System.out.println(intToDouble);

        // Step 4: Cast floating point to integer
        int doubleToInt = (int) myDouble;  // Note: This will truncate decimal places
        System.out.println(doubleToInt);

        // Step 5: Declare and initialize a char with uppercase letter
        char myChar = 'A';
        System.out.println(myChar);

        // Step 6: Convert to lowercase using numerical operation
        // Adding 32 to an uppercase ASCII value gives its lowercase equivalent
        char lowerChar = (char)(myChar + 32);
        System.out.println(lowerChar);
    }
}


