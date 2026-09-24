package game.weapons.DivinePower;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

public class Wind implements DivinePower {
    public static final int FROST_CHANCE = 30;
    @Override
    public String execute(Actor attacker, Actor target, GameMap map) {
        Random rand = new Random();
        List<Exit> exits = map.locationOf(attacker).getExits();
        Exit randExit = exits.get(rand.nextInt(exits.size()));
        Location destination = randExit.getDestination();
        if (destination.canActorEnter(target)) {
            map.moveActor(target, destination);
        }
        return String.format("Wind divine power moves %s to %s", target, destination);
    }

    @Override
    public DivinePower nextPower() {
        Random rand = new Random();
        if (rand.nextInt(100) < FROST_CHANCE) {
            return new Frost();
        }
        return new Lightning();
    }
}
