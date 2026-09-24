package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.Fire;
import game.tileset.GroundType;

import java.util.Random;

/**
 * Class representing a golem stomp
 *
 * @author Kenzie Rivan Wiguna
 * Modified by:
 * @author Nathaniel Chin
 */
public class GolemStomp extends IntrinsicWeapon {
    /**
     * The amount of damage the weapon deals
     */
    private static final int DAMAGE = 100;
    /**
     * The amount of damage dealt by an explosion
     */
    private static final int EXPLOSION_DAMAGE = 50;
    /**
     * The weapon's hitrate
     */
    private static final int HITRATE = 5;
    /**
     * The chance of an explosion
     */
    private static final int EXPLOSION_RATE = 10;

    /**
     * Constructor.
     */
    public GolemStomp() {
        super(DAMAGE, "stomps", HITRATE);
    }

    @Override
    public String attack(Actor attacker, Actor target, GameMap map) {
        Random rand = new Random();
        String result = super.attack(attacker, target, map);

        if (rand.nextInt(100) < EXPLOSION_RATE) {
            Location here = map.locationOf(attacker);
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();
                Ground ground = destination.getGround();
                if (!(ground.hasCapability(GroundType.NON_BURNABLE))) {
                    destination.addItem(new Fire());
                }
                if (destination.containsAnActor())
                    target.hurt(EXPLOSION_DAMAGE);
            }
            result += "\nFurnace Golem's stomp attack results in an explosion, burning the surrounding areas.";
        }
        return result;
    }

    @Override
    public String toString() {
        return "GolemStomp";
    }
}