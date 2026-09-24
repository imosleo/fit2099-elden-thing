package game.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Ability;
import game.actors.Status;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.weapons.ManFlySting;

/**
 * ManFly represents an enemy character in the game that can wander, follow, and attack hostile actors.
 * It has a sting attack that can poison its target, and it will follow actors that are hostile towards it.
 * <p>
 * The ManFly has behaviors assigned with priorities:
 * 1. AttackBehavior (priority 1) - attack any hostile actor in range.
 * 2. FollowBehavior (priority 2) - follow hostile actors when close enough.
 * 3. WanderBehavior (priority 3) - wander around the map when no hostile actor is nearby.
 *
 * @author Nicholas Hiew
 * Modified by: Dylan Matthew Quah Kwang Yung
 */
public class ManFly extends Enemy {
    /**
     * HP of the ManFly
     */
    private static final int HP = 50;

    /**
     * Constructor for the ManFly class.
     * Initializes the enemy with 50 hit points and assigns its behaviors.
     * The ManFly uses a sting attack that has a chance to poison its target.
     */
    public ManFly() {
        super("Man Fly", '%', HP);  // Initialize ManFly with the name "Man Fly", display character '%', and 50 hit points
        this.behaviours.put(3, new WanderBehaviour());  // Add wandering behavior with priority 3
        this.behaviours.put(1, new AttackBehaviour());  // Add attack behavior with priority 1
        this.addCapability(Ability.POISON_RES);
        this.addCapability(Ability.CANNOT_ENTER_FLOOR);

        // Create a Poison object to be used by the ManFly's sting attack
        this.setIntrinsicWeapon(new ManFlySting());  // Set ManFly's intrinsic weapon to the ManFlySting
    }

    /**
     * Determines the actions the ManFly can perform on other actors based on their status.
     * If the other actor is hostile, the ManFly will follow and attack them.
     *
     * @param otherActor The actor interacting with the ManFly.
     * @param direction  The direction of the other actor relative to the ManFly.
     * @param map        The current game map where the interaction is happening.
     * @return An ActionList containing the possible actions the ManFly can perform.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        // If the other actor is hostile towards enemies, the ManFly will follow and attack
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Add FollowBehaviour with priority 2, following the hostile actor
            this.behaviours.put(2, new FollowBehaviour(otherActor));
        }
        return actions;
    }
}
