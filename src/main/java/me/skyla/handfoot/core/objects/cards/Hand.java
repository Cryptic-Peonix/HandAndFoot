package me.skyla.handfoot.core.objects.cards;

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

    public Hand(Collection<Card> cards) {
        addCards(cards);
    }

    public void addCards(Collection<Card> cards) {
        for (Card c : cards) {
            addCard(c);
        }
    }

    public void addCard(Card c) {
        cards.add(c);
        pointVal += c.getType().getPointVal();
    }

    public void removeCards(Collection<Card> cards) {
        for (Card c : cards) {
            removeCard(c);
        }
    }

    public void removeCard(Card c) {
        cards.remove(c);
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

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", pointVal=" + pointVal +
                '}';
    }
}
