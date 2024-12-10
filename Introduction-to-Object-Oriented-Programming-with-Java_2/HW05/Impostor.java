public interface Impostor {
    /**
     * Attempts to freeze another player in the game.
     * Implementation should check various conditions like frozen status
     * and handle success/failure cases.
     * 
     * @param p the player to attempt to freeze
     */
    abstract void freeze(Player p);

    /**
     * Sabotages another player by increasing their susLevel.
     * Implementation should handle various conditions and
     * calculate the appropriate susLevel increase.
     * 
     * @param p the player to sabotage
     */
    abstract void sabotage(Player p);
}