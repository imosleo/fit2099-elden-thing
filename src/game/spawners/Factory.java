package game.spawners;

import game.enemies.ManFly;
import game.enemies.Scarab;
import game.enemies.Spirit;

/**
 * Factory class responsible for creating instances of enemy types.
 * This class provides static methods to spawn various enemy objects
 * like Spirit, ManFly, and Scarab. Each method returns a new instance
 * of the corresponding enemy type.
 *
 * The Factory pattern is used here to centralize and simplify the
 * instantiation of enemy objects, promoting maintainability and flexibility
 * in future changes.
 *
 * Created by:
 * @author Nicholas Hiew
 *
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 * @author Nicholas Hiew
 */
public class Factory {

    /**
     * Creates and returns a new Spirit enemy.
     *
     * @return a new Spirit object
     */
    public static Spirit createSpirit() {
        return new Spirit();
    }

    /**
     * Creates and returns a new ManFly enemy.
     *
     * @return a new ManFly object
     */
    public static ManFly createManFly() {
        return new ManFly();
    }

    /**
     * Creates and returns a new Scarab enemy.
     *
     * @return a new Scarab object
     */
    public static Scarab createScarab() {
        return new Scarab();
    }
}

