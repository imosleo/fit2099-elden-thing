package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.tileset.*;

import java.util.Arrays;

public class BeluratSewers extends GameMap {
    public BeluratSewers() {
        super("Belurat Sewers", new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle(), new PoisonSwamp()),
                Arrays.asList(
                        "##++++++#####++++++++~~~~~++++",
                        "##+++++++###+++++++++~~~~~++++",
                        "##++++++++++++++++++~~~~~~~++~",
                        "###+++++++++++++++.~~~~~~~~.~~",
                        "~~~~~.+++++~~~++++~~~~~~~~~..~",
                        "~~~~~~~~~~~~~~~++++~~~~+++~...",
                        "~~~~+~~~~~~~~~~+++++~~~~~~~###",
                        "+~~~~++####~~~~~++++##.~++~###",
                        "++~~+++#####~~~~~++###++~~~###",
                        "+~~++++######~~~~++###++~~~###"
                ));
    }
}
