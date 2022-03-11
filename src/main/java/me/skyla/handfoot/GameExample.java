package me.skyla.handfoot;

import me.skyla.handfoot.core.objects.cards.Game;
import processing.core.PApplet;

/**
 * Runs an example game with no GUI for testing.
 */
public class GameExample {

    public static void runGame(PApplet sketch) {
        Game game = new Game("Joe Biden", "Obama", "Donald Trump", "Mike Pence", "Democrats", "Republicans", sketch);
        System.out.println(game.getP1().printHand());
        System.out.println(game.getP1().printFoot());
        System.out.println(game.getP2().printHand());
        System.out.println(game.getP2().printFoot());
        System.out.println(game.getP3().printHand());
        System.out.println(game.getP3().printFoot());
        System.out.println(game.getP4().printHand());
        System.out.println(game.getP4().printFoot());
        game.draw(game.getP1());
        System.out.println("\n" + game.getP1().printHand());
    }
}
