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
    public  CardTranslator(PApplet sketch) {
        this.sketch = sketch;
        setup(this.sketch);
    }

    private PApplet sketch;
    private final HashMap<String, Card.Cards> cardHashMap = new HashMap<>();
    private final HashMap<Card.Cards, String> keyMap = new HashMap<>();
    // Setup hashmap
    public void setup(PApplet s) {
        this.sketch = s;
        String[] keys = {"AS", "AC", "AH", "AD", "2S", "2C", "2H", "2D", "3S", "3C", "3H", "3D", "4S", "4C", "4H", "4D",
                "5S", "5C", "5H", "5D", "6S", "6C", "6H", "6D", "7S", "7C", "7H", "7D", "8S", "8C", "8H", "8D", "9S", "9C", "9H", "9D",
                "XS", "XC", "XH", "XD", "JS", "JC", "JH", "JD", "QS", "QC", "QH", "QD","KS", "KC", "KH", "KD", "RJ", "BJ", "DD"};
        int counter = 0;
        for (Card.Cards c : Card.Cards.values()) {
            cardHashMap.put(keys[counter], c);
            keyMap.put(c, keys[counter]);
            counter++;
        }
        //System.out.println("Card Map:" + cardHashMap);
        //System.out.println("Key Map: " +keyMap);
    }

    public HashMap<String, Card.Cards> getCardHashMap() {
        return cardHashMap;
    }

    public Card.Cards getCardFromHash(String key) {
        return cardHashMap.get(key);
    }

    public String getStringFromCard(Card.Cards c) {
        //System.out.println("Type in method: " + c);
        //System.out.println("Result in method: " + keyMap.get(c));
        //System.out.println(keyMap);
        return keyMap.get(c);
    }
}
