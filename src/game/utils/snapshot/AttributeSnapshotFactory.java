package game.utils.snapshot;

import edu.monash.fit2099.engine.actors.Actor;

public class AttributeSnapshotFactory implements SnapshotFactory {

    /**
     * Creates AttributeSnapshot objects
     * @param actor that is affected by the snapshot
     * @return AttributeSnapshot object
     */
    @Override
    public Snapshot createSnapshot(Actor actor) {
        return new AttributeSnapshot(actor);
    }
}
