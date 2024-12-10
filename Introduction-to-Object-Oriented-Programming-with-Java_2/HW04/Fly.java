public class Fly {
    // Private instance variables ensure encapsulation - these can only be accessed
    // through the class's public methods
    private double mass;    // Mass in grams, stored as decimal value
    private double speed;   // Flying speed, stored as decimal value
    
    // Primary constructor that others will chain to. This constructor handles
    // the fundamental initialization of a Fly with both mass and speed
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }
    
    // Secondary constructor that chains to primary constructor using this()
    // When only mass is provided, speed defaults to 10
    public Fly(double mass) {
        this(mass, 10);
    }
    
    // Tertiary constructor with no parameters, chains to secondary constructor
    // Default values: mass of 5 and speed of 10
    public Fly() {
        this(5, 10);
    }
    
    // Getter methods allow controlled access to private variables
    public double getMass() {
        return mass;
    }
    
    public void setMass(double mass) {
        this.mass = mass;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    // The grow method increases mass and adjusts speed according to specific rules:
    // - For mass under 20: speed increases by 1 for each mass unit added
    // - For mass 20 or more: speed decreases by 0.5 for each mass unit added
    public void grow(int addedMass) {
        // Process each unit of added mass individually to ensure accurate
        // speed adjustments at the threshold of 20 mass
        for (int i = 0; i < addedMass; i++) {
            mass++;
            if (mass <= 20) {
                speed++;
            } else {
                speed -= 0.5;
            }
        }
    }
    
    // Simple method to check if the fly is dead (mass = 0)
    public boolean isDead() {
        return mass == 0;
    }
    
    // toString method provides a string representation of the Fly
    // Uses String.format to ensure decimal values are displayed with 2 decimal places
    public String toString() {
        if (isDead()) {
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", speed);
        } else {
            return String.format("I'm speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }
}