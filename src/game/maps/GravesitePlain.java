package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.tileset.Dirt;
import game.tileset.Floor;
import game.tileset.Puddle;
import game.tileset.Wall;

import java.util.Arrays;

/**
 * Represents the "Gravesite Plain" game map.
 *
 * The {@code GravesitePlain} is a pre-designed map composed of various ground types such as dirt, walls, floors, and puddles.
 * The map is represented by a grid layout where different symbols represent different types of terrain.
 *
 * Created by:
 * @author Kenzie Rivan Wiguna
 *
 * Modified by:
 * @author Kenzie Rivan Wiguna
 * @author Dylan Matthew Quah Kwang Yung
 */
public class GravesitePlain extends GameMap {

    /**
     * Constructor for the GravesitePlain.
     * <p>
     * Initializes the map with the specified layout and terrain types, such as {@code Dirt}, {@code Wall},
     * {@code Floor}, and {@code Puddle}.
     * </p>
     */
    public GravesitePlain() {
        super("Gravesite Plain",
                new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle()),
                Arrays.asList(
                        "..........~~~~~~~...~~~~~~~......~...........",
                        "~..........~~~~~....~~~~~~...................",
                        "~~.........~~~~.....~~~~~~...................",
                        "~~~..#####..~~.....~~~~~~~...................",
                        "~~~..#___#........~~~~~~~~~..................",
                        "~~~..#___#.......~~~~~~.~~~..................",
                        "~~~..##_##......~~~~~~.......................",
                        "~~~~...........~~~~~~~...........~~..........",
                        "~~~~~.........~~~~~~~~.......~~~~~~~.........",
                        "~~~~~~.......~~~~~~~~~~.....~~~~~~~~........."
                ));
    }
}
