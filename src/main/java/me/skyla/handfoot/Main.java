package me.skyla.handfoot;

import me.skyla.handfoot.core.objects.cards.Book;
import me.skyla.handfoot.core.objects.cards.Card;
import me.skyla.handfoot.core.objects.cards.Deck;
import me.skyla.handfoot.core.objects.cards.Foot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    private int x;
    private int y;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public void settings(){
        size(600,600);
    }

    private Card card1;

    public void setup(){
        x = 200;
        y = 200;
        //GameExample.runGame(this);
        card1 = new Card(this, Card.Cards.ACE_OF_HEARTS);
        Card card2 = new Card(this, Card.Cards.ACE_OF_HEARTS);
        Card card3 = new Card(this, Card.Cards.JOKER_BLACK);
        Card card4 = new Card(this, Card.Cards.ACE_OF_HEARTS);
        Card card5 = new Card(this, Card.Cards.JOKER_BLACK);
        Card card6 = new Card(this, Card.Cards.ACE_OF_HEARTS);
        Card card7 = new Card(this, Card.Cards.ACE_OF_HEARTS);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);
        Book testBook = new Book(cards, this);
        System.out.println(testBook);
    }

    public void draw(){
        background(200);
        stroke(255, 50);
        card1.drawCard(50, 50, 75, 100);
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void main(String[] args) {
        PApplet.main("me.skyla.handfoot.Main");
        logger.info("Hello!");
    }
}
