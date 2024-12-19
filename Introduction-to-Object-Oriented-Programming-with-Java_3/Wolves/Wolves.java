import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Wolves {

    public static void main(String[] args) {
        Wolf[] pack = {
            new Wolf(17.1, 2),
            new Wolf(3, 10),
            new Wolf(9.2, 7),
            new Wolf(9.1, 8),
            new Wolf(17.01, 3),
            new Wolf(16.2, 1),
            new Wolf(16, 4),
            new Wolf(16, 5),
            new Wolf(10, 6),
            new Wolf(5, 9)
        };

        Arrays.sort(pack);

        File fileOut = new File("SortedWolves.csv");
        PrintWriter filePrint = null;

        try {
            filePrint = new PrintWriter(fileOut);
            for (Wolf wolf : pack) {
                filePrint.println(wolf.getRank() + "," + wolf.getSize());
            }
        } 

        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


        finally {
            if (filePrint != null) {
                filePrint.close();
            }
        }
    }
}