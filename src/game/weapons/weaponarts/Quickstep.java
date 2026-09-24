package game.weapons.weaponarts;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

public class Quickstep implements WeaponArt {
    /**
     * The name of weaponart
     */
    private final String name = "Quickstep";

    /**
     * Move the player to a random direction after they have performed their attack
     *
     * @param attacker the owner of the weapon
     * @param target   the actor being targeted by the attack
     * @param map      the map they are on
     * @return a string that represents something that can be displayed to the Player
     */
    @Override
    public String execute(Actor attacker, Actor target, GameMap map) {
        Random rand = new Random();
        List<Exit> exits = map.locationOf(attacker).getExits();
        Exit randExit = exits.get(rand.nextInt(exits.size()));
        Location destination = randExit.getDestination();
        if (destination.canActorEnter(attacker)) {
            map.moveActor(attacker, destination);
        }
        return String.format("\n%s escapes to %s on %s", attacker, destination, map);
    }
}
