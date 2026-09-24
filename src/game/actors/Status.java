package game.actors;

/**
 * Use this enum class to represent a status.
 * Example #1: if the player is sleeping, you can attack a Status.SLEEP to the player class
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Nathaniel Chin
 */
public enum Status {
    /**
     * Actor that can attack Enemy
     */
    HOSTILE_TO_ENEMY,
    /**
     * Actor that can attack Player
     */
    HOSTILE_TO_PLAYER,
    /**
     * Can be traded with
     */
    TRADER,
    /**
     * Actor that cannot do any action
     */
    STUNNED
}
