import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile;
    private int day;

    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    private String addTime(String timeIn, int treatmentTime) {
        // Parse hours and minutes from timeIn (military time)
        int hours = Integer.parseInt(timeIn.substring(0, 2));
        int minutes = Integer.parseInt(timeIn.substring(2));
        
        // Add treatment time
        minutes += treatmentTime;
        hours += minutes / 60;
        minutes = minutes % 60;
        
        // Format timeOut in military time
        return String.format("%02d%02d", hours, minutes);
    }

    public boolean addToFile(String patientInfo) {
        try {
            // Read existing file content
            Scanner fileScanner = new Scanner(patientFile);
            StringBuilder allContent = new StringBuilder();
            String[] newInfo = patientInfo.split(",");
            boolean isExistingPatient = false;
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith(newInfo[0] + ",")) {
                    // Existing patient - append new appointment info to the same line
                    isExistingPatient = true;
                    allContent.append(line.trim()) // Get existing info without newline
                             .append(String.format(",%s,%s,%s,%s,%s\n",
                                newInfo[3], // Day
                                newInfo[4], // TimeIn
                                newInfo[5], // TimeOut
                                newInfo[6], // InitialHealth
                                newInfo[7])); // InitialPainLevel
                } else {
                    allContent.append(line).append("\n");
                }
            }
            fileScanner.close();
    
            if (!isExistingPatient) {
                // New patient - add complete info
                allContent.append(patientInfo).append("\n");
            }
    
            // Write updated content back to file
            PrintWriter writer = new PrintWriter(patientFile);
            writer.print(allContent.toString());
            writer.close();
            
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public String nextDay(File f) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(f);
        StringBuilder dayInfo = new StringBuilder();
        Scanner inputScanner = new Scanner(System.in);

        while (fileScanner.hasNextLine()) {
            String[] appointment = fileScanner.nextLine().split(",");
            String name = appointment[0];
            String type = appointment[1];
            String timeIn = appointment[3];
            
            // Print consultation message
            System.out.printf("Consultation for %s the %s at %s.\n", name, type, timeIn);
            
            // Get health input
            double health;
            while (true) {
                System.out.printf("What is the health of %s?\n", name);
                try {
                    health = Double.parseDouble(inputScanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            
            // Get pain level input
            int painLevel;
            while (true) {
                System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
                try {
                    painLevel = Integer.parseInt(inputScanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number");
                }
            }

            // Create and process pet
            Pet pet;
            if (type.equals("Dog")) {
                pet = new Dog(name, health, painLevel, Double.parseDouble(appointment[2]));
            } else if (type.equals("Cat")) {
                pet = new Cat(name, health, painLevel, Integer.parseInt(appointment[2]));
            } else {
                throw new InvalidPetException();
            }

            // Process treatment
            pet.speak();
            int treatmentTime = pet.treat();
            String timeOut = addTime(timeIn, treatmentTime);

            // Add appointment info
            dayInfo.append(String.format("%s,%s,%s,Day %d,%s,%s,%.1f,%d\n",
                name, type, appointment[2], day, timeIn, timeOut, health, painLevel));
        }

        fileScanner.close();
        day++; // Increment day
        return dayInfo.toString();
    }

    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }
}