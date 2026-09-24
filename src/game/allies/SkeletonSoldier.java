package game.allies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
import game.behaviours.AttackBehaviourAlly;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.weapons.BoneArm;

/**
 * Represents a Skeleton Soldier ally character with limited HP, capable of attacking enemies and following
 * either the player or hostile actors.
 * The Skeleton Soldier has an intrinsic weapon (BoneArm) and specific behaviours to determine its actions.
 *
 * @author Nicholas Hiew and Nathaniel Chin
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class SkeletonSoldier extends Ally {
    private static final int HP = 1;

    /**
     * Constructor to create a Skeleton Soldier ally.
     * Initializes the Skeleton Soldier with a BoneArm weapon and predefined behaviours for
     * attacking, following the player, and wandering.
     *
     * @param player The player actor whom the Skeleton Soldier will initially follow.
     */
    public SkeletonSoldier(Actor player) {
        super("Skeleton Soldier", '&', HP);
        this.setIntrinsicWeapon(new BoneArm());
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.behaviours.put(1, new AttackBehaviourAlly());
        this.behaviours.put(3, new FollowBehaviour(player));
        this.behaviours.put(4, new WanderBehaviour());
    }

    /**
     * Determines the actions available to the Skeleton Soldier when another actor is nearby.
     * If the nearby actor is hostile to the player, the Skeleton Soldier will follow the actor.
     *
     * @param otherActor The actor interacting with the Skeleton Soldier.
     * @param direction  The direction of the other actor relative to the Skeleton Soldier.
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
