public class Pond {
    public static void main(String[] args) {
        // Create the required Frog objects
        Frog peepo = new Frog("Peepo");                    // Default: 5 months, speed 5
        Frog pepe = new Frog("Pepe", 10, 15);             // 10 months, speed 15
        Frog peepaw = new Frog("Peepaw", 4.6, 5);         // 4.6 years converted to months, speed 5
        Frog kermit = new Frog("Kermit", 2, 20);          // Custom frog
        
        // Create the required Fly objects
        Fly fly1 = new Fly(1, 3);                         // 1 mass, speed 3
        Fly fly2 = new Fly(6);                            // 6 mass, default speed 10
        Fly fly3 = new Fly(12, 8);                        // Custom fly
        
        // Perform the required operations in order
        Frog.setSpecies("1331 Frogs");
        
        System.out.println(peepo);                         // Removed .toString() as it's implicit
        
        peepo.eat(fly2);
        System.out.println(fly2);
        
        peepo.grow(8);
        
        peepo.eat(fly2);
        System.out.println(fly2);
        
        System.out.println(peepo);
        System.out.println(kermit);
        
        peepaw.grow(4);
        System.out.println(peepaw);
        
        System.out.println(pepe);
    }
}