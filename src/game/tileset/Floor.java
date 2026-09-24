package game.tileset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actors.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 */
public class Floor extends Ground {
    public Floor() {
        super('_', "Floor");
    }

    /**
     * If the actor has the CANNOT_ENTER_FLOOR ability then they shouldn't be able to enter the floor
     *
     * @param actor the Actor to check
     * @return True if the actor does not have the CANNOT_ENTER_FLOOR ability, False otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return !actor.hasCapability(Ability.CANNOT_ENTER_FLOOR);
    }
}
