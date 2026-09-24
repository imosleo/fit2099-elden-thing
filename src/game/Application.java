package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.SuspiciousTrader;
import game.allies.Fetcher;
import game.allies.SkeletonSoldier;
import game.consumables.FlaskOfHealing;
import game.consumables.FlaskOfRejuvenation;
import game.consumables.ShadowtreeFragment;
import game.enemies.DivineBeastDancingLion;
import game.enemies.FurnaceGolem;
import game.enemies.Scarab;
import game.maps.BeluratSewers;
import game.maps.BeluratTowerSettlement;
import game.maps.GravesitePlain;
import game.maps.Stagefront;
import game.spawners.ManFlySpawner;
import game.spawners.SpiritSpawner;
import game.tileset.Gate;
import game.tileset.Graveyard;
import game.utils.FancyMessage;
import game.utils.snapshot.AttributeSnapshotFactory;
import game.weapons.GreatKnife;
import game.weapons.ShortSword;
import game.weapons.SpawnerStaff;
import game.weapons.weaponarts.Lifesteal;
import game.weapons.weaponarts.Memento;
import game.weapons.weaponarts.Quickstep;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 * Kenzie Rivan Wiguna
 * Ian Leong Zheng Yan
 * Nicholas Hiew
 * Nathaniel Chin
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        // Initialize game maps
        GravesitePlain gravesitePlain = new GravesitePlain();
        world.addGameMap(gravesitePlain);

        BeluratTowerSettlement beluratTowerSettlement = new BeluratTowerSettlement();
        world.addGameMap(beluratTowerSettlement);

        BeluratSewers beluratSewers = new BeluratSewers();
        world.addGameMap(beluratSewers);

        Stagefront stagefront = new Stagefront();
        world.addGameMap(stagefront);

        // Display the game title
        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        // Add the player
        Player player = new Player("Tarnished", '@', 150, 100, 5);
//        world.addPlayer(player, stagefront.at(9, 6));
        world.addPlayer(player, gravesitePlain.at(7, 5));
//        world.addPlayer(player, stagefront.at(44, 4));

        // Add enemies to the maps
        gravesitePlain.at(42, 4).addActor(new FurnaceGolem());
        gravesitePlain.at(42,5).addActor(new SkeletonSoldier(player));
        gravesitePlain.at(7, 7).addActor(new Scarab());
        gravesitePlain.at(7, 4).addActor(new SuspiciousTrader());
        gravesitePlain.at(10,5).addActor(new Fetcher(player));
        gravesitePlain.at(7,5).addItem(new SpawnerStaff());


        // Create the Divine Beast Dancing Lion boss and pass the Belurat Tower Settlement map
        DivineBeastDancingLion boss = new DivineBeastDancingLion(beluratTowerSettlement); // Pass the map to the boss
        stagefront.at(9, 1).addActor(boss);  // Add the boss to the Stagefront map

        // Add items to the maps
        GreatKnife greatKnife = new GreatKnife();
        greatKnife.enchant(new Lifesteal());
        gravesitePlain.at(5, 9).addItem(greatKnife);

        GreatKnife greatKnife1 = new GreatKnife();
        greatKnife1.enchant(new Memento(new AttributeSnapshotFactory()));
        gravesitePlain.at(7, 9).addItem(greatKnife1);

        ShortSword shortSword = new ShortSword();
        greatKnife1.enchant(new Quickstep());
        gravesitePlain.at(7, 8).addItem(shortSword);

        gravesitePlain.at(6, 4).addItem(new FlaskOfHealing());
        gravesitePlain.at(8, 4).addItem(new FlaskOfRejuvenation());
        gravesitePlain.at(10, 4).addItem(new ShadowtreeFragment());
        gravesitePlain.at(30, 3).addItem(new ShadowtreeFragment());
        gravesitePlain.at(35, 1).addItem(new ShadowtreeFragment());
        gravesitePlain.at(25, 2).addItem(new ShadowtreeFragment());
        gravesitePlain.at(40, 4).addItem(new ShadowtreeFragment());

        // Set up gates for other maps
        Gate generalGate = new Gate();
        generalGate.addDestination(gravesitePlain, gravesitePlain.at(44, 4));
        generalGate.addDestination(beluratTowerSettlement, beluratTowerSettlement.at(23, 9));
        generalGate.addDestination(beluratSewers, beluratSewers.at(0, 5));

        // Add the gate at specific locations in Gravesite Plain, Belurat Tower Settlement, and Belurat Sewers
        gravesitePlain.at(44, 4).setGround(generalGate);
        beluratTowerSettlement.at(23, 9).setGround(generalGate);
        beluratSewers.at(0, 5).setGround(generalGate);

        // Set up the special gate in Belurat Tower Settlement to Stagefront
        Gate beluratToStagefrontGate = new Gate();
        beluratToStagefrontGate.addDestination(stagefront, stagefront.at(8, 6));  // Only this gate can teleport to Stagefront

        // Add this special gate at (41, 1) in Belurat Tower Settlement (for testing make the gate spawn beside the current gate)
        beluratTowerSettlement.at(41, 1).setGround(beluratToStagefrontGate);

        // Add spawners to the maps
        beluratTowerSettlement.at(5, 7).setGround(new Graveyard(new SpiritSpawner()));
        beluratTowerSettlement.at(7, 3).setGround(new Graveyard(new SpiritSpawner()));
        beluratTowerSettlement.at(13, 5).setGround(new Graveyard(new SpiritSpawner()));
        beluratTowerSettlement.at(24, 6).setGround(new Graveyard(new SpiritSpawner()));
        beluratTowerSettlement.at(40, 6).setGround(new Graveyard(new SpiritSpawner()));

        beluratSewers.at(6, 8).setGround(new Graveyard(new ManFlySpawner()));
        beluratSewers.at(7, 3).setGround(new Graveyard(new ManFlySpawner()));
        beluratSewers.at(13, 5).setGround(new Graveyard(new ManFlySpawner()));
        beluratSewers.at(24, 6).setGround(new Graveyard(new ManFlySpawner()));
        beluratSewers.at(15, 2).setGround(new Graveyard(new ManFlySpawner()));

        // Start the game
        world.run();
    }
}