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
 * @author Kenzie Rivan Wiguna
 */
public class AttackBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            Actor target = destination.getActor();
            if (destination.containsAnActor() && target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                return new AttackAction(target, destination.toString());
            }
        }
        return null;
    }
}
