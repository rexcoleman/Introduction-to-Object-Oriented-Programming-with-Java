public class StringOperations {
    public static void main(String[] args) {
        // Create a String with name and print it
        String myName = "Rex";
        System.out.println(myName);
        
        // Replace first and last letters
        // We'll break this into steps to make it clearer
        // First, get all but the first letter of the name
        String withoutFirst = myName.substring(1);
        // Then create new string with 'A' at start and original middle
        String firstReplaced = "A" + withoutFirst;
        // Now replace the last letter with 'Z'
        // We need all but the last letter, then add 'Z'
        String finalName = firstReplaced.substring(0, firstReplaced.length() - 1) + "Z";
        System.out.println(finalName);
        
        // Create and print URL
        String webAddress = "www.gatech.edu";
        System.out.println(webAddress);
        
        // Extract the middle section and add 1331
        // Find the positions after 'www.' and before the last '.'
        int startPos = webAddress.indexOf('.') + 1;
        int endPos = webAddress.lastIndexOf('.');
        // Extract the middle and concatenate with 1331
        String result = webAddress.substring(startPos, endPos) + "1331";
        System.out.println(result);
    }
}