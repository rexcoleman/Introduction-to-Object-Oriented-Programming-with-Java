public class Dog extends Pet {
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        } else {
            this.droolRate = droolRate;
        }
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0); // Default droolRate is 5.0
    }

    public double getDroolRate() {
        return droolRate;
    }

    @Override
    public int treat() {
        // Store values before healing
        double initialHealth = getHealth();
        int initialPainLevel = getPainLevel();
        
        // Calculate treatment time based on droolRate
        double treatmentTime;
        if (droolRate < 3.5) {
            treatmentTime = (initialPainLevel * 2) / initialHealth;
        } else if (droolRate <= 7.5) {
            treatmentTime = initialPainLevel / initialHealth;
        } else {
            treatmentTime = initialPainLevel / (initialHealth * 2);
        }
        
        // Heal after calculating treatment time
        heal();
        
        // Round up as required
        return (int) Math.ceil(treatmentTime);
    }

    @Override
    public void speak() {
        // Call parent speak method first
        super.speak();
        
        // Create bark string based on painLevel
        String bark = "bark";
        if (getPainLevel() > 5) {
            bark = bark.toUpperCase();
        }
        
        // Print bark painLevel number of times
        for (int i = 0; i < getPainLevel(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(bark);
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof Dog)) {
            return false;
        }
        Dog other = (Dog) o;
        return this.droolRate == other.droolRate;
    }
}