package game.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Ability;
import game.actors.Status;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.items.GolemRemembrance;
import game.weapons.GolemStomp;

/**
 * Class representing the Furnace Golem
 * For now, it can only wander around the map.
 *
 * @author Adrian Kristanto
 * Modified by:
 * @author Nathaniel Chin
 */
public class FurnaceGolem extends Enemy {
    /**
     * HP of the FurnaceGolem
     */
    private static final int HP = 1000;
    /**
     * Constructor
     */
    public FurnaceGolem() {
        super("Furnace Golem", 'A', HP);
        this.behaviours.put(3, new WanderBehaviour());
        this.behaviours.put(1, new AttackBehaviour());
        this.setIntrinsicWeapon(new GolemStomp());
        this.addCapability(Ability.FIRE_RES);
        this.addCapability(Ability.CANNOT_ENTER_FLOOR);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            this.behaviours.put(2, new FollowBehaviour(otherActor));
        }
        return actions;
    }

    /**
     * Drop a Remembrance of the Furnace Golem upon death
     *
     * @param actor the perpetrator
     * @param map   where the actor fell unconscious
     * @return a string describing what happened when the actor is unconscious
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.locationOf(this).addItem(new GolemRemembrance());
        return super.unconscious(actor, map);
    }
}