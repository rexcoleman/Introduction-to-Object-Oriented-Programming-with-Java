import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    // Instance variables
    private int numTasks;
    private int taskSpeed;
    
    // Constructors
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
    
    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);  // Default values specified in requirements
    }

    @Override
    public void emergencyMeeting() {
        // Frozen BlueAstronauts can't call meetings
        if (this.isFrozen()) {
            return;
        }

        // Get array of players and sort by susLevel
        Player[] players = getPlayers();
        Arrays.sort(players);
        
        // Start from end since sorted ascending - highest susLevel is at end
        for (int i = players.length - 1; i >= 0; i--) {
            Player p = players[i];
            if (!p.isFrozen()) {
                // Check for tie with next highest non-frozen player
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
    public void completeTask() {
        // Frozen BlueAstronauts can't complete tasks
        if (this.isFrozen()) {
            return;
        }

        // Determine how many tasks to complete based on taskSpeed
        if (taskSpeed > 20) {
            numTasks -= 2;
        } else {
            numTasks -= 1;
        }

        // Don't let numTasks go below 0
        if (numTasks <= 0) {
            // Set to exactly 0 if we went below
            numTasks = 0;
            
            // If this is first time hitting 0, reduce susLevel
            if (this.getSusLevel() > 0) {
                System.out.println("I have completed all my tasks");
                this.setSusLevel(this.getSusLevel() / 2);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blue = (BlueAstronaut) o;
            return super.equals(o) && 
                this.numTasks == blue.numTasks && 
                this.taskSpeed == blue.taskSpeed;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result = result.substring(0, result.length() - 1); // Remove the last period
        result += " I have " + numTasks + " left over.";
        
        // Convert to uppercase if susLevel > 15
        if (this.getSusLevel() > 15) {
            return result.toUpperCase();
        }
        return result;
    }

    /**
     * Gets the number of tasks left for this BlueAstronaut.
     * @return the number of tasks remaining
     */
    public int getNumTasks() {
        return numTasks;
    }

    /**
     * Sets the number of tasks for this BlueAstronaut.
     * @param numTasks the new number of tasks
     */
    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    /**
     * Gets the task completion speed of this BlueAstronaut.
     * @return the task speed
     */
    public int getTaskSpeed() {
        return taskSpeed;
    }

    /**
     * Sets the task completion speed for this BlueAstronaut.
     * @param taskSpeed the new task speed
     */
    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }


}