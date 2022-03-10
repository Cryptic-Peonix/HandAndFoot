package me.skyla.handfoot.core.objects.cards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A book is a group of at least 7 of the same rank of cards, and possibly wild cards.
 * If it contains no wilds, it is deemed "natural", but if it has wilds, its is deemed "unnatural".
 * Once a card is added, it cannot be removed.
 *
 * @author Connor Clark.
 */
public class Book {

    // List of cards in book
    private final ArrayList<Card> cards = new ArrayList<>();

    // Rank of the book
    private final Card.CardRank rank;

    // Num of wilds (can't exceed 2)
    private byte wildCount = 0;
    private final byte MAX_WILDS = 2;

    // Card to appear on top of deck
    private Card topCard;

    /**
     * Boolean to represent if the book is natural or not. If it is natural (only rank cards) it is true. If it isn't, it will be false.
     */
    private boolean natural;

    /**
     * Boolean to check if the book is closed. The book should be closed if it contains at least 7 cards.
     */
    private boolean closed;

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(Book.class);

    private int pointVal;
    private int cardPointVal = 0;

    private final PApplet sketch;

    /**
     * Constructor. Makes a book of cards.
     * @param cards The cards used to create the book.
     */
    public Book(Collection<Card> cards, PApplet sketch) {
        this.rank = CardUtil.getRankFromCollection(cards);
        addCards(cards);
        this.natural = checkNatural();
        updateTopCard();
        updatePointVal();
        this.sketch = sketch;
    }

    private void updateCardPointVal() {
        for (Card c : cards) {
            cardPointVal +=  c.getType().getPointVal();
        }
    }

    /**
     * Checks the point value of the book.
     * 500 if natural, 300 if unnatural, & 0 if not closed.
     */
    private void updatePointVal() {
        if (!(rank.equals(Card.CardRank.WILD))) {
            if (closed) {
                if (natural) {
                    pointVal = 500;
                } else {
                    pointVal = 300;
                }
            } else {
                pointVal = 0;
            }
        } else {
            pointVal = 2000;
        }
    }

    /**
     * Updates the top card of the deck.
     */
    public void updateTopCard() {
        topCard = cards.get(0);
    }

    /**
     * Checks if the book is natural or unnatural.
     * @return True if it is natural, false if not.
     */
    public boolean checkNatural() {
        boolean state = true;
        for (Card c : this.cards) {
            if (c.getType().isWild()) {
               state = false;
                break;
            }
        }
        return state;
    }

    /**
     * Checks if the book is closed or not
     */
    public void checkClosed() {
        if (cards.size() >= 7)
            closeBook();
    }

    /**
     * Closes a book. Ensures the book has a red card if natural and a black if unatural.
     * Assigns the book a point value.
     */
    public void closeBook() {
        ensureNaturalHasRed();
        updatePointVal();
        logger.info("Book of Rank: " + rank.toString() + " has closed!");
        closed = true;
    }

    /**
     * Closed natural books must be represented by a red card. Ensures that, if the book is closed and natural, the
     * top card is red.
     */
    private void ensureNaturalHasRed() {
        if (closed && natural && !rank.equals(Card.CardRank.WILD)) {
            if (!topCard.getType().getSuit().getColor().equals(Color.RED))  {
                boolean foundRed = false;
                for (Card c : cards) {
                    if (c.getType().getSuit().getColor().equals(Color.RED)) {
                        foundRed = true;
                        topCard = c;
                        break;
                    }
                }
                if (!foundRed) {
                    for (Card c : cards) {
                        if (c.getType().getRank().equals(rank)) {
                            cards.remove(c);
                            Card temp = CardUtil.createRedCardMatchingBlack(sketch, c);
                            cards.add(temp);
                            updateTopCard();
                        }
                    }
                }
            }
        }
    }

    /**
     * Adds a card to the book of cards.
     * @param card The card to add.
     */
    public void addCard(Card card) {
        if ((card.getType().getRank() == this.rank) || (card.getType().isWild() && (wildCount + 1) <= MAX_WILDS)
                || card.getType().isWild() && rank.equals(Card.CardRank.WILD)) {
            cards.add(card);
            natural = checkNatural();
            checkClosed();
            updateTopCard();
            updateCardPointVal();
            if (card.getType().isWild()) {
                wildCount++;
            }
        } else if (card.getType().getRank() != this.rank && !card.isWild()) {
            logger.error("Card cannot be added to book! Ranks do not match!");
        } else if ((wildCount + 1) > MAX_WILDS) {
            logger.error("Card cannot be added to book! Book already contains 2 wild cards!");
        } else {
            logger.error("Something went wrong, card can't be added to book, reason unknown. Card: " + card);
        }
    }

    /**
     * Adds a collection of cards to the book of cards.
     * @param c The collection of cards to add.
     */
    public void addCards(Collection<Card> c) {
        for (Card card : c) {
            addCard(card);
        }
    }

    public byte getWildCount() {
        return wildCount;
    }

    public byte getMaxWilds() {
        return MAX_WILDS;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getTopCard() {
        return topCard;
    }

    public boolean isNatural() {
        return natural;
    }

    public boolean isClosed() {
        return closed;
    }

    public int getPointVal() {
        return pointVal;
    }

    public int getCardPointVal() {
        return cardPointVal;
    }

    /**
     * Get the total book value.
     * @return The point value of the book plus the point value of the cards.
     */
    public int getTotalPointVal() {
        return pointVal + cardPointVal;
    }

    public Card.CardRank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Book{" +
                "cards=" + cards +
                ", rank=" + rank +
                ", wildCount=" + wildCount +
                ", topCard=" + topCard +
                ", natural=" + natural +
                ", pointVal=" + pointVal +
                ", cardPointVal=" + cardPointVal +
                ", closed=" + closed +
                '}';
    }
}
