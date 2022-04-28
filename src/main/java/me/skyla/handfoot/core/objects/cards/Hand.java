package me.skyla.handfoot.core.objects.cards;

import me.skyla.handfoot.util.CardTranslator;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A Players hand of cards.
 *
 * @author Connor Clark.
 */
public class Hand {

    private final ArrayList<Card> cards = new ArrayList<>();
    private int pointVal = 0;
    private String dataString = "";
    private PApplet sketch;

    public Hand(Collection<Card> cards, PApplet sketch) {
        this.sketch = sketch;
        addCards(cards);
    }

    public void addCards(Collection<Card> cards) {
        for (Card c : cards) {
            addCard(c);
        }
    }

    public void addCard(Card c) {
        cards.add(c);
        int pts = c.getType().getPointVal();
        if (pts > 0) {
            pointVal += pts;
        } else {
            pointVal -= pts;
        }
        createHandDataString();
    }

    public void removeCards(Collection<Card> cards) {
        for (Card c : cards) {
            removeCard(c);
        }
    }

    public void removeCard(Card c) {
        cards.remove(c);
        int pts = c.getType().getPointVal();
        if (pts > 0) {
            pointVal -= pts;
        } else {
            pointVal += pts;
        }
        createHandDataString();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getPointVal() {
        return pointVal;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    private void createHandDataString() {
        StringBuilder stringBuilder = new StringBuilder();
        CardTranslator translator = new CardTranslator(sketch);
        for (Card c : cards) {
            Card.Cards type = c.getType();
            //System.out.println(type);
            String s = translator.getStringFromCard(type);
            //System.out.println(s);
            stringBuilder.append(s);
        }
        dataString = stringBuilder.toString();
    }

    public String getDataString() {
        return dataString;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", pointVal=" + pointVal +
                '}';
    }
}
