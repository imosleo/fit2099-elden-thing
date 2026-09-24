package game.utils.snapshot;

import edu.monash.fit2099.engine.actors.Actor;

public interface SnapshotFactory {
    /**
     * Responsible in creating snapshot objects
     * @param actor that is affected by the snapshot
     * @return snapshot object
     */
    Snapshot createSnapshot(Actor actor);
}
