package me.skyla.handfoot;

import me.skyla.handfoot.core.objects.cards.Book;
import me.skyla.handfoot.core.objects.cards.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    private int x;
    private int y;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public void settings(){
        size(1280,720);
    }

    private Card card1;
    private Card card2;

    public void setup(){
        x = 200;
        y = 200;
        //GameExample.runGame(this);
        card1 = new Card(this, Card.Cards.JOKER_BLACK);
        card2 = new Card(this, Card.Cards.ACE_OF_CLUBS);
        Card card3 = new Card(this, Card.Cards.JOKER_BLACK);
        Card card4 = new Card(this, Card.Cards.ACE_OF_HEARTS);
        Card card5 = new Card(this, Card.Cards.ACE_OF_CLUBS);
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
        card2.drawCard(50, 75, 75, 100);
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void main(String[] args) {
        PApplet.main("me.skyla.handfoot.Main");
        logger.info("Hello!");
    }

    //TODO: MOVE THIS OUTTA HERE, TEMP LOCATION FOR THE CODE...
//    private static void moveMouseWithCard() {
//        //first attempt at selecting and moving a card to a target region
//
//        int xpos= 200;
//        int ypos =200;
//        boolean atrest = true;
//        boolean grabbed = false;
//
////target position
//        int tXpos = 500;
//        int tYpos = 500;
//        int limit = 30;   //used this to choose the upper left corner of both the card and target region
//        boolean hitTarget = false;
//
//        PImage mycard;
//
//        void setup() {
//            size(900, 900);
//            mycard = loadImage("aceDiamond.png");   //insert your own cards here
//        }
//
//        void draw() {
//            //which background to draw?
//            if (hitTarget)
//                background(0, 0, 255);
//            else
//                background(255);
//
//            //draw target
//            rect(tXpos, tYpos, 10 * limit, 10*limit);
//            fill(0, 144, 0);
//            rect(tXpos, tYpos, limit, limit);
//            fill(255);
//
//            //if mouse is not in play
//            if (!grabbed) {
//                image(mycard, xpos, ypos);
//            }
//
//            //if mouse clicked and held
//            if (grabbed) {
//                image(mycard, mouseX, mouseY);
//            }
//        }
//
////did we press the mouse near the upper left corner of the card?
//        void mousePressed() {
//            if ((mouseX - xpos) < limit && (mouseX - xpos) >0 && (mouseY - ypos) < limit && (mouseY - ypos) > 0)
//                grabbed = true;
//        }
//
////did we release the mouse?  [NOTE: even if we did not have the card in hand this function is visited]
//        void mouseReleased() {
//
//            //was the card being moved?
//            if (grabbed) {
//                xpos = pmouseX;
//                ypos = pmouseY;
//
//                //if we released the card near enough to the green box inside the target region, align card and mark the flag
//                if ((xpos - tXpos) < limit && (xpos - tXpos) > 0 && (ypos - tYpos) < limit && (ypos - tYpos)>0) {
//                    hitTarget = true;
//                    xpos = tXpos;
//                    ypos = tYpos;
//                }
//                else
//                    hitTarget = false;
//
//                //not holding a mouse button means have not grabbed the card
//                grabbed = false;
//            }
//        }
//
//
//        Hope this helps!
//    }
}
