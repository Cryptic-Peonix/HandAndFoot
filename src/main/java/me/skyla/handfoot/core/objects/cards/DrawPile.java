package me.skyla.handfoot.core.objects.cards;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The games draw pile.
 */
public class DrawPile {

    private final ArrayList<Card> cards = new ArrayList<>();
    private int numCards;
    private final PApplet s;

    public DrawPile(int numPlayers, PApplet s) {
        this.s = s;
        for (int i = 0; i < numPlayers; i++) {
            Deck d = new Deck(this.s);
            cards.addAll(d.getCardList());
        }
    }

    /**
     * Shuffles the draw pile
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
