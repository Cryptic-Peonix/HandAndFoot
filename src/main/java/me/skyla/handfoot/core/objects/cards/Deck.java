package me.skyla.handfoot.core.objects.cards;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {

    private final ArrayList<Card> cardList = new ArrayList<>();

    public Deck(PApplet s) {
        for (Card.Cards cards : Card.Cards.values()) {
            Card c = new Card(s, cards);
            cardList.add(c);
        }
    }

    public void printDeck() {
        for (Card c : cardList) {
            System.out.println(c.toString());
        }
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }
}
