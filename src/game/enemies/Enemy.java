package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.AttackAction;
import game.actors.Status;

import java.util.Map;
import java.util.TreeMap;

/**
 * A class that represents an Enemy
 *
 * Created by:
 * @author Kenzie Rivan Wiguna
 * Modified by:
 * Nathaniel Chin
 */
public abstract class Enemy extends Actor {

    /**
     * List of behaviours
     */
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor
     *
     * @param name        the name of the enemy
     * @param displayChar the character to represent the enemy on the map
     * @param hitPoints   the health points of the enemy
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.hasCapability(Status.STUNNED)) {
            for (Behaviour behaviour : behaviours.values()) {
                Action action = behaviour.getAction(this, map);
                if (action != null) {
                    return action;
                }
            }
        }
        return new DoNothingAction(); // Default action if no behaviour is triggered
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}