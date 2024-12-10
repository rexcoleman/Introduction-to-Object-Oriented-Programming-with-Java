public class Frog {
    // Private instance variables for proper encapsulation
    private String name;          // Name can be any combination of characters
    private int age;             // Age in months (integer)
    private double tongueSpeed;   // Speed of tongue (decimal value)
    private boolean isFroglet;    // True if age > 1 and age < 7 months
    
    // Static species variable - shared by all Frog instances
    // Default value must be "Rare Pepe"
    private static String species = "Rare Pepe";
    
    // Primary constructor - others will chain to this one to avoid code duplication
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.updateFroglet();  // Must set froglet status whenever age changes
    }
    
    // Constructor that takes age in years - chains to primary constructor
    // Uses casting to round down to nearest month without method calls
    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int)(ageInYears * 12), tongueSpeed);
    }
    
    // Constructor with just name - chains to primary constructor
    // Default: 5 months old and tongueSpeed of 5
    public Frog(String name) {
        this(name, 5, 5);
    }
    
    // Helper method to update froglet status
    // A frog is a froglet if more than 1 month but fewer than 7 months old
    private void updateFroglet() {
        isFroglet = age > 1 && age < 7;
    }
    
    // Grow by specified number of months
    public void grow(int months) {
        for (int i = 0; i < months; i++) {
            age++;  // Increase age by 1 month
            
            // Update tongue speed based on age requirements:
            // - Increase by 1 until frog becomes 12 months old
            // - Decrease by 1 after 30 months, but never below 5
            if (age < 12) {
                tongueSpeed++;
            } else if (age >= 30) {
                tongueSpeed = Math.max(5, tongueSpeed - 1);
            }
            
            updateFroglet();  // Must update status after age changes
        }
    }
    
    // Overloaded grow method - grows by one month
    public void grow() {
        grow(1);
    }
    
    // Attempt to eat a fly
    public void eat(Fly fly) {
        // Don't attempt to eat dead flies
        if (fly.isDead()) {
            return;
        }
        
        // Catch fly if tongue is fast enough
        if (tongueSpeed > fly.getSpeed()) {
            // Check if fly is nutritious enough to cause growth
            if (fly.getMass() >= age * 0.5) {
                grow();
            }
            fly.setMass(0);  // Set fly mass to 0 when caught
        } else {
            // Fly escapes and grows by 1 mass
            fly.grow(1);
        }
    }
    
    // Static getter/setter for species - affects all instances
    public static String getSpecies() {
        return species;
    }
    
    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }
    
    // String representation of the frog
    public String toString() {
        if (isFroglet) {
            return String.format("My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.",
                name, age, tongueSpeed);
        } else {
            return String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.",
                name, age, tongueSpeed);
        }
    }
}