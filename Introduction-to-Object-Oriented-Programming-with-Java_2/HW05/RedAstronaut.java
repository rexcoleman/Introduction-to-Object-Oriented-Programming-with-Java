import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    // Instance variable
    private String skill;  // can be "inexperienced", "experienced", or "expert"
    
    // Constructors
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }
    
    public RedAstronaut(String name) {
        this(name, 15, "experienced");
    }

    @Override
    public void emergencyMeeting() {
        // Frozen impostors can't call meetings
        if (this.isFrozen()) {
            return;
        }
    
        // Get array of players and sort by susLevel (ascending)
        Player[] players = getPlayers();
        Arrays.sort(players);
        
        // Last player has highest susLevel (since sorted ascending)
        // Start from end and find first unfrozen player that isn't this impostor
        for (int i = players.length - 1; i >= 0; i--) {
            Player p = players[i];
            if (!p.isFrozen() && p != this) {
                // Check if there's a tie
                if (i > 0 && players[i - 1].getSusLevel() == p.getSusLevel()) {
                    return; // Tie found, no one gets voted off
                }
                // No tie, freeze the most sus player
                p.setFrozen(true);
                break;
            }
        }
    
        // Check if game is over
        gameOver();
    }

    @Override
    public void freeze(Player p) {
        // Check if this impostor is frozen
        if (this.isFrozen()) {
            return;
        }

        // Can't freeze another Impostor
        if (p instanceof Impostor) {
            return;
        }

        // Can't freeze an already frozen player
        if (p.isFrozen()) {
            return;
        }

        // Check if freeze is successful based on susLevels
        if (this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        } else {
            // Unsuccessful freeze - double this impostor's susLevel
            this.setSusLevel(this.getSusLevel() * 2);
        }

        // Check if game is over
        gameOver();
    }

    @Override
    public void sabotage(Player p) {
        // Can't sabotage if frozen
        if (this.isFrozen()) {
            return;
        }

        // Can't sabotage another Impostor
        if (p instanceof Impostor) {
            return;
        }

        // Can't sabotage frozen player
        if (p.isFrozen()) {
            return;
        }

        // Calculate susLevel increase based on this impostor's susLevel
        if (this.getSusLevel() < 20) {
            // Increase by 50%
            int newSusLevel = p.getSusLevel() + (p.getSusLevel() / 2);
            p.setSusLevel(newSusLevel);
        } else {
            // Increase by 25%
            int newSusLevel = p.getSusLevel() + (p.getSusLevel() / 4);
            p.setSusLevel(newSusLevel);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut red = (RedAstronaut) o;
            return super.equals(o) && this.skill.equals(red.skill);
        }
        return false;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result = result.substring(0, result.length() - 1); // Remove the last period
        result += " I am an " + skill + " player!"; // Add skill info
        
        // Convert to uppercase if susLevel > 15
        if (this.getSusLevel() > 15) {
            return result.toUpperCase();
        }
        return result;
    }

    /**
     * Gets the skill level of this RedAstronaut.
     * @return the skill level (inexperienced, experienced, or expert)
     */
    public String getSkill() {
        return skill;
    }

    /**
     * Sets the skill level of this RedAstronaut.
     * @param skill the new skill level
     */
    public void setSkill(String skill) {
        this.skill = skill.toLowerCase();  // Maintain lowercase consistency as in constructor
    }

}