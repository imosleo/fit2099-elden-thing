package game.utils.snapshot;

import edu.monash.fit2099.engine.actors.Actor;

public interface Snapshot {
    /**
     * This method is used to define what is to be snapshotted.
     * For example, a snapshot can affect the actor's attributes
     * while other, it may affect the actor's location.
     *
     * @param actor  the actor who is affected by the snapshot.
     */
    void restore(Actor actor);
}
