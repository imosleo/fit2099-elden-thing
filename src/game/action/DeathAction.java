package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.FancyMessage;
import game.actors.Status;

/**
 * An action executed when the Tarnished (player) dies.
 * <p>
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Ian Leong Zheng Yan
 */
public class DeathAction extends Action {

    private Actor attacker = null;

    /**
     * Constructor for DeathAction when the Tarnished is killed by an attacker.
     *
     * @param killer the actor responsible for killing Tarnished
     */
    public DeathAction(Actor killer) {
        this.attacker = killer; // Assign attacker if passed
    }

    /**
     * Empty constructor for DeathAction when there is no specific attacker (e.g., environmental death).
     */
    public DeathAction() {
    }

    /**
     * Executes the death action, displays "YOU DIED" message,
     * and removes the player from the map.
     *
     * @param target The actor performing the action (usually the Tarnished).
     * @param map    The map the actor is on.
     * @return the result of the action
     */
    @Override
    public String execute(Actor target, GameMap map) {

        // If the target is the Tarnished (Player)
        if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Print "YOU DIED" message
            FancyMessage.printMessage("You Died");

            // Remove Tarnished from map (this will trigger game end in the next game loop)
            return target.unconscious(map);
        } else {
            // Handle death of other actors (e.g., enemies)
            map.removeActor(target);
        }

        return this + " ceased to exist.";
    }

    /**
     * Returns a descriptive string.
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        if (actor != null) {
            return actor + " is killed by " + actor;
        } else {
            return actor + " is killed";
        }
    }
}
