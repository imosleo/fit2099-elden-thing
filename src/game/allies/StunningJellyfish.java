package game.allies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
import game.behaviours.AttackBehaviourAlly;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.weapons.JellyfishStinger;

/**
 * Represents a Stunning Jellyfish ally character with limited HP, capable of stunning enemies using its
 * intrinsic weapon, the Jellyfish Stinger. The Stunning Jellyfish has behaviours that define its actions
 * such as attacking, following the player, and wandering.
 *
 * @author Nathaniel Chin and Nicholas Hiew
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class StunningJellyfish extends Ally {
    private static final int HP = 1;

    /**
     * Constructor to create a Stunning Jellyfish ally.
     * Initializes the Stunning Jellyfish with a Jellyfish Stinger weapon and predefined behaviours for
     * attacking, following the player, and wandering.
     *
     * @param player The player whom the Stunning Jellyfish will initially follow.
     */
    public StunningJellyfish(Actor player) {
        super("Stunning Jellyfish", 'J', HP);
        this.setIntrinsicWeapon(new JellyfishStinger());
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.behaviours.put(1, new AttackBehaviourAlly());
        this.behaviours.put(3, new FollowBehaviour(player));
        this.behaviours.put(4, new WanderBehaviour());
    }

    /**
     * Determines the actions available to the Stunning Jellyfish when another actor is nearby.
     * If the nearby actor is hostile to the player, the Stunning Jellyfish will follow the actor.
     *
     * @param otherActor The actor interacting with the Stunning Jellyfish.
     * @param direction  The direction of the other actor relative to the Stunning Jellyfish.
     * @param map        The current game map.
     * @return           A list of allowable actions based on the nearby actor's capabilities.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            this.behaviours.put(2, new FollowBehaviour(otherActor));
        }
        return super.allowableActions(otherActor, direction, map);
    }
}
