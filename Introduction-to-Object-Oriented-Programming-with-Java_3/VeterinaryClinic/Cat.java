public class Cat extends Pet {
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            this.miceCaught = 0;
        } else {
            this.miceCaught = miceCaught;
        }
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0); // Default miceCaught is 0
    }

    public int getMiceCaught() {
        return miceCaught;
    }


    @Override
    public int treat() {
        // Store values before healing
        double initialHealth = getHealth();
        int initialPainLevel = getPainLevel();
        
        // Calculate treatment time based on miceCaught
        double treatmentTime;
        if (miceCaught < 4) {
            treatmentTime = (initialPainLevel * 2) / initialHealth;
        } else if (miceCaught <= 7) {
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
        
        // Create meow string based on painLevel
        String meow = "meow";
        if (getPainLevel() > 5) {
            meow = meow.toUpperCase();
        }
        
        // Print meow miceCaught number of times
        for (int i = 0; i < miceCaught; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(meow);
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof Cat)) {
            return false;
        }
        Cat other = (Cat) o;
        return this.miceCaught == other.miceCaught;
    }
}