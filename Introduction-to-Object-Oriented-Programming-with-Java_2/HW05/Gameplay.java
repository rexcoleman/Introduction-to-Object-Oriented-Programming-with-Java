public class Gameplay {
    public static void main(String[] args) {
        // 1. Create all the required astronauts
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);
        
        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut suspicious = new RedAstronaut("Suspicious Person", 100, "expert");

        // 2. Test first sequence
        System.out.println("\n--- Starting first test sequence ---");
        
        // Liam sabotages Bob
        System.out.println("Liam sabotages Bob:");
        liam.sabotage(bob);
        System.out.println(bob);

        // Liam attempts to freeze Suspicious Person
        System.out.println("\nLiam attempts to freeze Suspicious Person:");
        liam.freeze(suspicious);
        System.out.println(suspicious);

        // Liam freezes Albert
        System.out.println("\nLiam freezes Albert:");
        liam.freeze(albert);
        System.out.println(albert);
        System.out.println(liam);

        // Frozen Albert calls emergency meeting
        System.out.println("\nFrozen Albert calls emergency meeting:");
        albert.emergencyMeeting();

        // Suspicious Person calls emergency meeting
        System.out.println("\nSuspicious Person calls emergency meeting:");
        suspicious.emergencyMeeting();

        // Bob calls emergency meeting
        System.out.println("\nBob calls emergency meeting:");
        bob.emergencyMeeting();
        System.out.println(suspicious);

        // Test Heath completing tasks
        System.out.println("\n--- Testing Heath's task completion ---");

        // First completion - should reduce to 1 task
        System.out.println("Heath completes tasks first time:");
        heath.completeTask();
        System.out.println(heath);

        // Second completion - should trigger completion message and susLevel reduction
        System.out.println("\nHeath completes remaining task:");
        heath.completeTask();
        System.out.println(heath);

        // Third completion - should do nothing since tasks are done
        System.out.println("\nHeath attempts tasks when already complete:");
        heath.completeTask();
        System.out.println(heath);

        // Test Liam freezing Angel
        System.out.println("\n--- Testing Liam's freeze attempt on Angel ---");
        System.out.println("Liam attempts to freeze Angel:");
        liam.freeze(angel);
        System.out.println("Angel status: " + angel);
        System.out.println("Liam status: " + liam); // Should show susLevel doubled to 38

        // Test Liam sabotaging Bob twice
        System.out.println("\n--- Testing Liam's sabotage attempts on Bob ---");
        System.out.println("Liam sabotages Bob first time:");
        liam.sabotage(bob);
        System.out.println("Bob after first sabotage: " + bob);

        System.out.println("\nLiam sabotages Bob second time:");
        liam.sabotage(bob);
        System.out.println("Bob after second sabotage: " + bob);

        // Liam attempts to freeze Bob
        System.out.println("\nLiam attempts to freeze Bob:");
        liam.freeze(bob);
        System.out.println("Bob status: " + bob);
   
    }

}