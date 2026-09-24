package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Ability;

/**
 * Class representing a fire
 *
 * @author Kenzie Rivan Wiguna
 */
public class Fire extends Item {
    /**
     * Amount of turns the fire lasted
     */
    private int age = 0;
    /**
     * The max time that the fire lasts
     */
    private static final int MAX_AGE = 5;
    /**
     * Amount of damage dealt
     */
    private static final int DAMAGE = 5;

    /**
     * Constructor
     */
    public Fire() {
        super("Fire", 'w', false);
    }

    @Override
    public void tick(Location currentLocation) {
        if (age == MAX_AGE) {
            currentLocation.removeItem(this);
        }
        age++;

        Actor actor = currentLocation.getActor();
        if (currentLocation.containsAnActor()) {
            if (!(actor.hasCapability(Ability.FIRE_RES))) {
                actor.hurt(DAMAGE);
                new Display().println(String.format("Fire burns %s", actor));
            }
        }
    }
}

