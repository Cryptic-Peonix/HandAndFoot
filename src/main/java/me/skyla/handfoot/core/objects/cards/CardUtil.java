package me.skyla.handfoot.core.objects.cards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;

import java.util.Collection;

/**
 * Util class for cards.
 *
 * @author Connor Clark.
 */
public class CardUtil {

    private static final Logger logger = LoggerFactory.getLogger(CardUtil.class);

    private CardUtil() {
        throw new UnsupportedOperationException("This is a utility"
                + " class and cannot be instantiated!");
    }

    /**
     * Creates a red card with the same suit as a black card.
     * @param sketch processing sketch.
     * @param c Card to re-create.
     * @return The new Card.
     */
    public static Card createRedCardMatchingBlack(PApplet sketch, Card c) {
        Card newCard;

        if (c.getType().getRank().equals(Card.CardRank.ACE)) {
            newCard = new Card(sketch, Card.Cards.ACE_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.TWO)) {
            newCard = new Card(sketch, Card.Cards.TWO_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.THREE)) {
            newCard = new Card(sketch, Card.Cards.THREE_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.FOUR)) {
            newCard = new Card(sketch, Card.Cards.FOUR_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.FIVE)) {
            newCard = new Card(sketch, Card.Cards.FIVE_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.SIX)) {
            newCard = new Card(sketch, Card.Cards.SIX_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.SEVEN)) {
            newCard = new Card(sketch, Card.Cards.TWO_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.EIGHT)) {
            newCard = new Card(sketch, Card.Cards.EIGHT_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.NINE)) {
            newCard = new Card(sketch, Card.Cards.TWO_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.TEN)) {
            newCard = new Card(sketch, Card.Cards.TEN_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.JACK)) {
            newCard = new Card(sketch, Card.Cards.JACK_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.QUEEN)) {
            newCard = new Card(sketch, Card.Cards.QUEEN_OF_HEARTS);
        } else if (c.getType().getRank().equals(Card.CardRank.KING)) {
            newCard = new Card(sketch, Card.Cards.KING_OF_HEARTS);
        } else {
            newCard = new Card(sketch, Card.Cards.DUMMY);
        }

        return newCard;
    }

    /**
     * Get the rank from a collection of cards. Only feed it collections of the same rank!
     * @param cards Cards to check.
     * @return The rank of the cards.
     * @exception RuntimeException Will throw a runtime exception if all cards in the collection are not
     * the same rank or are not wild.
     */
    public static Card.CardRank getRankFromCollection(Collection<Card> cards) {
        //TODO: FIX THIS, THROWS AN ERROR IF WILD IS FIRST CARD EVEN IF THE ADDITION IS LEGAL. NEEDS A LOGIC FIX.
        boolean allWild = true;
        Card checker = cards.iterator().next();
        Card.CardRank rank = checker.getType().getRank();
        for (Card c : cards) {
            if ((!checker.getType().getRank().equals(c.getType().getRank()) && !checker.getType().isWild()) && (!c.getType().isWild())) {
                logger.error("All of the ranks of this collection are not the same! Return not accurate.");
                throw new RuntimeException("All cards in checked collection must be the same rank!");
            }
            if (!c.getType().isWild())
                checker = c;
        }
        return rank;
    }
}
