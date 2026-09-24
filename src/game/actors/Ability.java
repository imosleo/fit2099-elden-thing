package game.actors;

/**
 * Use this enum to represent abilities.
 * Example #1: if the player is capable jumping over walls, you can attach Ability.WALL_JUMP to the player class
 */
public enum Ability {
    FIRE_RES,
    POISON_RES,
    /**
     * Denotes that the Actor cannot enter the Floor ground type
     */
    CANNOT_ENTER_FLOOR,
}