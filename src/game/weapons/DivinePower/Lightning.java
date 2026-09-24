package game.weapons.DivinePower;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.tileset.GroundType;

import java.util.Random;

public class Lightning implements DivinePower {
    private static final int FROST_CHANCE = 40;
    private static final int WIND_CHANCE = 40;

    private static final int DAMAGE = 50;
    public String execute(Actor attacker, Actor target, GameMap map) {
        Location attackerLocation = map.locationOf(attacker);
        for (Exit exit : attackerLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor actor = destination.getActor();
                Location here = map.locationOf(actor);
                Ground ground = here.getGround();
                actor.hurt(DAMAGE);
                if (ground.hasCapability(GroundType.WATER)) {
                    actor.hurt(DAMAGE);
                }
            }
        }
        return "\nLightning divine power strikes the surrounding area!";
    }

    public DivinePower nextPower() {
        Random rand = new Random();
        if (rand.nextInt(100) < FROST_CHANCE) {
            return new Frost();
        }
        if (rand.nextInt(100) < WIND_CHANCE) {
            return new Wind();
        }
        return new Lightning();
    }
}
