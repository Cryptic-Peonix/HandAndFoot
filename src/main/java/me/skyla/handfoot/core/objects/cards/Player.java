package me.skyla.handfoot.core.objects.cards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;

import java.util.Collection;

/**
 * Class of a player. Contains a hand and a foot.
 *
 * @author Connor Clark.
 */
public class Player {

    private final String NAME;
    private final Hand HAND;
    private final Foot FOOT;
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private PApplet sketch;

    public Player(String name, Collection<Card> hand, Collection<Card> foot, PApplet sketch) {
        this.sketch = sketch;
        this.NAME = name;
        this.HAND = new Hand(hand, sketch);
        this.FOOT = new Foot(foot, name + "'s foot");
    }

    public String getNAME() {
        return NAME;
    }

    public Hand getHAND() {
        return HAND;
    }

    public void addCardToHand(Card c) {
        HAND.addCard(c);
    }

    public void addCardsToHand(Collection<Card> cards) {
        HAND.addCards(cards);
    }

    public Foot getFOOT() {
        return FOOT;
    }

    public void disableFoot() {
        FOOT.disable();
    }

    public int getHandPointValue() {
        return HAND.getPointVal();
    }

    /**
     * Takes the foot of a teammate and adds it to this players hand.
     * @param p The player to take from.
     */
    public void takePlayerFoot(Player p) {
        if (HAND.isEmpty() && !FOOT.isEnabled()) {
            HAND.addCards(p.getFOOT().getCards());
            p.disableFoot();
        } else {
            logger.error("Conditions not met to steal teammate foot.");
        }

    }

    @Override
    public String toString() {
        return "Player{" +
                "NAME='" + NAME + '\'' +
                ", HAND=" + HAND +
                ", FOOT=" + FOOT +
                '}';
    }

    public String printHand() {
        return "Hand of: " + NAME + ". " + HAND.toString();
    }

    public String printFoot() {
        return "Foot of: " + NAME + ". " + FOOT.toString();
    }
}
