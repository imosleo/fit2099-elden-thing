package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.AttackAction;
import game.actors.Status;

/**
 * A class that figures out an AttackAction for the actor
 * to attack the target actor.
 *
 * @author Kenzie Rivan Wiguna and Nicholas Hiew
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class AttackBehaviourAlly implements Behaviour {
    /**
     * Determines if there is a hostile actor in an adjacent location to attack.
     * If a hostile actor is found in one of the surrounding exits, an {@code AttackAction}
     * is returned to engage the target. Otherwise, returns {@code null}.
     *
     * @param actor The actor that has this behaviour.
     * @param map   The current game map.
     * @return An {@code AttackAction} targeting the hostile actor, or {@code null} if none are found.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            Actor target = destination.getActor();
            if (destination.containsAnActor() && target.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                return new AttackAction(target, destination.toString());
            }
        }
        return null;
    }
}