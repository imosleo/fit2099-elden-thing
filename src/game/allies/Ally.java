package game.allies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.DeathAction;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents an ally character in the game with a set of prioritized behaviours.
 * Allies can execute actions based on their behaviours or perform a default action if none are available.
 * If an ally is not conscious, it will perform a death action.
 *
 * @author Nicholas Hiew and Nathaniel Chin
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public abstract class Ally extends Actor {
    /**
     * List of behaviours for the ally, prioritized by keys in ascending order.
     */
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor to create an Ally.
     *
     * @param name        The name of the Ally.
     * @param displayChar The character representing the Ally on the game map.
     * @param hitPoints   The starting hit points for the Ally.
     */
    public Ally(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    /**
     * Determines the action to be taken by the ally during its turn.
     * The ally will perform a death action if unconscious. Otherwise, it evaluates
     * each behaviour in priority order, executing the first non-null action found.
     * If no behaviour provides an action, the ally will do nothing.
     *
     * @param actions     List of possible actions for this turn.
     * @param lastAction  The last action performed by the ally.
     * @param map         The current game map.
     * @param display     The display where actions are shown.
     * @return            The selected action for this turn.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!isConscious()) {
            return new DeathAction();
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }
        return new DoNothingAction(); // Default action if no behaviour is triggered
    }
}
