package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

public class SpawnAction extends Action {
    private final Actor owner;
    private final Actor spawn;

    public SpawnAction(Actor spawn, Actor owner) {
        this.owner = owner;
        this.spawn = spawn;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        ArrayList<Location> adjacentTiles = new ArrayList<>();
        for (Exit exit : map.locationOf(owner).getExits()) {
            if (exit.getDestination().getGround().canActorEnter(spawn) && !exit.getDestination().containsAnActor()) {
                adjacentTiles.add(exit.getDestination());
            }
        }
        if (!adjacentTiles.isEmpty()) {
            int randIndex = RandomNumberGenerator.randomIndex(adjacentTiles.size());
            Location spawnTile = adjacentTiles.get(randIndex);
            spawnTile.addActor(spawn);
        }
        return spawn + "has been spawned";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "spawns " + spawn;
    }
}
