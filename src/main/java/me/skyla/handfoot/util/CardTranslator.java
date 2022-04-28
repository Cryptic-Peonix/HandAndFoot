package me.skyla.handfoot.util;

import me.skyla.handfoot.core.objects.cards.Card;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to translate cards into a simple 2 char string.
 *
 * @author Skye Clark
 */
public class CardTranslator {

    /**
     * Key:
     * A = Ace
     * 2 = 2
     * 3 = 3
     * 4 = 4
     * 5 = 5
     * 6 = 6
     * 7 = 7
     * 8 = 8
     * 9 = 9
     * X = 10
     * J = Jack/Joker
     * Q = Queen
     * K = King
     *
     * S = Spades
     * H = Hearts
     * C = Clubs
     * D = Diamonds
     *
     * Example:
     * RJ = Red Joker
     * XS = 10 of spades
     */

    private PApplet sketch;
    // Setup hashmap
    public void setup(PApplet s) {
        this.sketch = s;
        HashMap<String, Card> cardHashMap = new HashMap<>();
        String[] keys = {"AS", "AC"};
        int counter = 0;
        for (Card.Cards c : Card.Cards.values()) {
            cardHashMap.put(keys[counter], new Card(sketch, c));
            counter++;
        }
    }
}
