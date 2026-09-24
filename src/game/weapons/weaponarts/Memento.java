package game.weapons.weaponarts;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.snapshot.Snapshot;
import game.utils.snapshot.SnapshotFactory;

import java.util.Random;
import java.util.Stack;

public class Memento implements WeaponArt {
    /**
     * The thing to be snapshotted
     */
    private final SnapshotFactory snapshotFactory;

    /**
     * Memento hitrate
     */
    private static final int CHANCE = 50;

    /**
     * Damage dealt to actor
     */
    private static final int DAMAGE = 5;

    /**
     * Minimum health of actor when taking damage
     */
    private static final int MIN_HEALTH = 5;

    /**
     * Stack to store Snapshot objects
     */
    private final Stack<Snapshot> snapshots = new Stack<>();

    /**
     * Coonstructor
     * @param snapshotFactory the thing to be snapshotted
     */
    public Memento(SnapshotFactory snapshotFactory) {
        this.snapshotFactory = snapshotFactory;
    }

    @Override
    public String execute(Actor actor, Actor target, GameMap gameMap) {
        Random rand = new Random();
        if (actor.getAttribute(BaseActorAttributes.HEALTH) >  MIN_HEALTH) {
            actor.hurt(DAMAGE);
        }
        if (rand.nextInt(100) < CHANCE) {
            snapshots.push(snapshotFactory.createSnapshot(actor));
            return "\nSnapshot has been activated";
        }
        else {
            if (!snapshots.isEmpty()) {
                snapshots.pop().restore(actor);
                return String.format("\n%s restored to its previous state", actor);
            }
        }
        return "";
    }
}
