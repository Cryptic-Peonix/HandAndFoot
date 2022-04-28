package me.skyla.handfoot;

import me.skyla.handfoot.core.objects.cards.Card;
import me.skyla.handfoot.core.objects.cards.Game;
import me.skyla.handfoot.util.CardTranslator;
import me.skyla.handfoot.util.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class Main extends PApplet {

    private int x;
    private int y;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private processing.net.Client client = null;
    private processing.net.Server server = null;
    private String ip = "10.1.11.75";
    private int port = 25565;
    private boolean isServer = false;

    private String input;
    private int data[] = new int[4];

    private final int FPS = 60; // SET FPS

    public void settings(){
        size(1280,720);
    }

    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Card card6;
    private Card card7;
    private Game game;

    public void setup() {
        CardTranslator translator = new CardTranslator();
        translator.setup(this);
        frameRate(FPS);
        if (isServer) {
            server = new processing.net.Server(this, port);
        } else {
            client = new processing.net.Client(this, ip, port);
        }
        x = 200;
        y = 200;
        //GameExample.runGame(this);
        game = new Game("Joe Biden", "Obama", "Donald Trump", "Mike Pence", "Democrats", "Republicans", this);
       card1 = new Card(this, Card.Cards.JOKER_BLACK, 50, 100);
//        card2 = new Card(this, Card.Cards.ACE_OF_SPADES, 50, 125);
//        card3 = new Card(this, Card.Cards.JOKER_BLACK, 50, 150);
//        card4 = new Card(this, Card.Cards.ACE_OF_HEARTS, 50, 175);
//        card5 = new Card(this, Card.Cards.ACE_OF_CLUBS, 50, 200);
//        card6 = new Card(this, Card.Cards.ACE_OF_HEARTS, 50, 225);
//        card7 = new Card(this, Card.Cards.ACE_OF_HEARTS, 50, 250);
//        ArrayList<Card> cards = new ArrayList<>();
//        cards.add(card1);
//        cards.add(card2);
//        cards.add(card3);
//        cards.add(card4);
//        cards.add(card5);
//        cards.add(card6);
//        cards.add(card7);
//        Book testBook = new Book(cards, this);
//        System.out.println(testBook);
    }

    public void draw(){
        Packet p = new Packet("test", game);
        background(200);
        stroke(255, 50);
        //card1.drawCard();
        // card2.drawCard();
        // card3.drawCard();
        // card4.drawCard();
        // card5.drawCard();
        // card6.drawCard();
        // card7.drawCard();

        // Send/receive data
        if (isServer) {
            // receive data from client if server
            if (mousePressed) {
                // Draw our line
                stroke(255);
                line(pmouseX, pmouseY, mouseX, mouseY);
                // Send mouse coords to other person
                server.write(pmouseX + " " + pmouseY + " " + mouseX + " " + mouseY + "\n");
            }

            // Receive data from client
            client = server.available();
            if (client != null) {
                input = client.readString();
                input = input.substring(0, input.indexOf("\n"));  // Only up to the newline
                int i = 0;
                for (String s : input.split(" ")) {
                    data[i++] = Integer.parseInt(s);
                }
                // Draw line using received coords
                stroke(0);
                line(data[0], data[1], data[2], data[3]);
            }
        } else {
            // revive data from server if client
            if (mousePressed) {
                // Draw our line
                stroke(255);
                line(pmouseX, pmouseY, mouseX, mouseY);
                // Send mouse coords to other person
                client.write(pmouseX + " " + pmouseY + " " + mouseX + " " + mouseY + "\n");
            }

            // Receive data from server
            if (client.available() > 0) {
                input = client.readString();
                input = input.substring(0,input.indexOf("\n"));  // Only up to the newline
                int i = 0;
                for (String s : input.split(" ")) {
                    data[i++] = Integer.parseInt(s);
                }
                // Draw line using received coords
                stroke(0);
                line(data[0], data[1], data[2], data[3]);
            }
        }
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void main(String[] args) {
        PApplet.main("me.skyla.handfoot.Main");

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
