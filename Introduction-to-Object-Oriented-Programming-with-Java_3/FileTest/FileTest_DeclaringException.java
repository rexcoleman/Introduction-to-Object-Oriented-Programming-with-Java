import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileTest_DeclaringException {

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = args[0];
        String word = args[1];

        File file = new File(args[0]);
        Scanner scan = null;

        scan = new Scanner(file);
        int lineCount = 0;
        System.out.printf("Lines in %s containing %s:\n", args[0], args[1]);

        while (scan.hasNextLine()) {
            String line =scan.nextLine();
            if (line.contains(word)) {
                System.out.println(lineCount + ": " + line);
            }
            lineCount ++;
        }
        scan.close();
    }
}
