package me.skyla.handfoot.core.objects.cards;

import processing.core.PApplet;

import java.util.ArrayList;

/**
 * The game of hand and foot!
 *
 * @author Connor Clark
 */
public class Game {

    // Players
    private final Player p1; // Team 1 player 1
    private final Player p2; // Team 1 player 2
    private final Player p3; // Team 2 player 1
    private final Player p4; // Team 2 player 2

    // Teams
    private final Team t1;
    private final Team t2;

    private final Board teamOneBoard;
    private final Board teamTwoBoard;
    private final int PLAYERS = 4;

    private final DrawPile drawPile;
    private final ArrayList<Card> discardPile = new ArrayList<>();

    private boolean gameWon = false;

    private final PApplet sketch;

    public Game(String p1Name, String p2Name, String p3Name, String p4Name, String t1Name, String t2Name, PApplet sketch) {
        this.sketch = sketch;
        drawPile = new DrawPile(PLAYERS, this.sketch);
        //TODO: Eventually, make a way for the player to get extra points by drawing exactly 20.
        //TODO: Make it so the hand and foot drawn is given to the next player, and they pick which to be hand and foot.
        p1 = new Player(p1Name, makePlayerHandOrFoot(), makePlayerHandOrFoot());
        p2 = new Player(p2Name, makePlayerHandOrFoot(), makePlayerHandOrFoot());
        p3 = new Player(p3Name, makePlayerHandOrFoot(), makePlayerHandOrFoot());
        p4 = new Player(p4Name, makePlayerHandOrFoot(), makePlayerHandOrFoot());
        t1 = new Team(p1, p2, t1Name);
        t2 = new Team(p3, p4, t2Name);
        teamOneBoard = new Board(t1, this.sketch);
        teamTwoBoard = new Board(t2, this.sketch);
    }

    private ArrayList<Card> makePlayerHandOrFoot() {
        ArrayList<Card> newHand = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Card c = drawPile.getCards().get(0);
            newHand.add(c);
            drawPile.getCards().remove(c);
        }
        return newHand;
    }

    /**
     * Adds the discard pile to the draw pile. Call when the draw pile is empty.
     */
    public void addDiscardPileToDraw() {
        drawPile.getCards().addAll(discardPile);
        discardPile.clear();
        drawPile.shuffle();
    }

    /**
     * A players turn.
     * @param p The player.
     */
    public void playerTurn(Player p) {
        draw(p);

    }

    public void draw(Player p) {
        p.addCardsToHand(drawPile.draw());
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Player getP3() {
        return p3;
    }

    public Player getP4() {
        return p4;
    }

    public Team getT1() {
        return t1;
    }

    public Team getT2() {
        return t2;
    }

    public int getPlayerCount() {
        return PLAYERS;
    }

    public Board getTeamOneBoard() {
        return teamOneBoard;
    }

    public Board getTeamTwoBoard() {
        return teamTwoBoard;
    }

    public String getGameDataString() {
        return "";
    }

    public void readGameDataString() {

    }
}
