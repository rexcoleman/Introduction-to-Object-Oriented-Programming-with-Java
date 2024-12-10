public interface Crewmate {
    /**
     * Called when a Crewmate attempts to complete their tasks.
     * Implementation should handle the task completion logic,
     * including updating numTasks and potentially susLevel.
     * A frozen Crewmate cannot complete tasks.
     */
    abstract void completeTask();
}