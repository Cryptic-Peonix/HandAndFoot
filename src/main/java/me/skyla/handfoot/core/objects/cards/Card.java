package me.skyla.handfoot.core.objects.cards;

import org.jetbrains.annotations.Nullable;
import processing.core.PApplet;

import java.awt.*;

/**
 * Class for a card.
 *
 * @author Connor Clark.
 */
public class Card {

    private final PApplet sketch;
    private final Cards type;

    public Card(PApplet s, Cards type) {
        this.sketch = s;
        this.type = type;
    }

    public Cards getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "type=" + type +
                ", pointVal=" + type.getPointVal() +
                ", color=" + type.getSuit().getColor().toString() +
                '}';
    }

    /**
     * Enum of all cards in a deck. Contains their point values and suits for easy access.
     *
     * @author Connor Clark
     */
    public enum Cards {

        // Ace
        ACE_OF_SPADES(20, CardSuit.SPADES, CardRank.ACE),
        ACE_OF_CLUBS(20, CardSuit.CLUBS, CardRank.ACE),
        ACE_OF_HEARTS(20, CardSuit.HEARTS, CardRank.ACE),
        ACE_OF_DIAMONDS(20, CardSuit.DIAMONDS, CardRank.ACE),

        // 2
        TWO_OF_SPADES(20, CardSuit.SPADES, CardRank.TWO),
        TWO_OF_CLUBS(20, CardSuit.CLUBS, CardRank.TWO),
        TWO_OF_HEARTS(20, CardSuit.HEARTS, CardRank.TWO),
        TWO_OF_DIAMONDS(20, CardSuit.DIAMONDS, CardRank.TWO),

        // 3
        THREE_OF_SPADES(-300, CardSuit.SPADES, CardRank.THREE),
        THREE_OF_CLUBS(-300, CardSuit.CLUBS, CardRank.THREE),
        THREE_OF_HEARTS(-500, CardSuit.HEARTS, CardRank.THREE),
        THREE_OF_DIAMONDS(-500, CardSuit.HEARTS, CardRank.THREE),

        // 4
        FOUR_OF_SPADES(5, CardSuit.SPADES, CardRank.FOUR),
        FOUR_OF_CLUBS(5, CardSuit.CLUBS, CardRank.FOUR),
        FOUR_OF_HEARTS(5, CardSuit.HEARTS, CardRank.FOUR),
        FOUR_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.FOUR),

        // 5
        FIVE_OF_SPADES(5, CardSuit.SPADES, CardRank.FIVE),
        FIVE_OF_CLUBS(5, CardSuit.CLUBS, CardRank.FIVE),
        FIVE_OF_HEARTS(5, CardSuit.HEARTS, CardRank.FIVE),
        FIVE_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.FIVE),

        // 6
        SIX_OF_SPADES(5, CardSuit.SPADES, CardRank.SIX),
        SIX_OF_CLUBS(5, CardSuit.CLUBS, CardRank.SIX),
        SIX_OF_HEARTS(5, CardSuit.HEARTS, CardRank.SIX),
        SIX_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.SIX),

        // 7
        SEVEN_OF_SPADES(5, CardSuit.SPADES, CardRank.SEVEN),
        SEVEN_OF_CLUBS(5, CardSuit.CLUBS, CardRank.SEVEN),
        SEVEN_OF_HEARTS(5, CardSuit.HEARTS, CardRank.SEVEN),
        SEVEN_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.SEVEN),

        // 8
        EIGHT_OF_SPADES(5, CardSuit.SPADES, CardRank.EIGHT),
        EIGHT_OF_CLUBS(5, CardSuit.CLUBS, CardRank.EIGHT),
        EIGHT_OF_HEARTS(5, CardSuit.HEARTS, CardRank.EIGHT),
        EIGHT_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.EIGHT),

        // 9
        NINE_OF_SPADES(10, CardSuit.SPADES, CardRank.NINE),
        NINE_OF_CLUBS(10, CardSuit.CLUBS, CardRank.NINE),
        NINE_OF_HEARTS(10, CardSuit.HEARTS, CardRank.NINE),
        NINE_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.NINE),

        // 10
        TEN_OF_SPADES(10, CardSuit.SPADES, CardRank.TEN),
        TEN_OF_CLUBS(10, CardSuit.CLUBS, CardRank.TEN),
        TEN_OF_HEARTS(10, CardSuit.HEARTS, CardRank.TEN),
        TEN_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.TEN),

        // JACK
        JACK_OF_SPADES(10, CardSuit.SPADES, CardRank.JACK),
        JACK_OF_CLUBS(10, CardSuit.CLUBS, CardRank.JACK),
        JACK_OF_HEARTS(10, CardSuit.HEARTS, CardRank.JACK),
        JACK_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.JACK),

        // QUEEN
        QUEEN_OF_SPADES(10, CardSuit.SPADES, CardRank.QUEEN),
        QUEEN_OF_CLUBS(10, CardSuit.CLUBS, CardRank.QUEEN),
        QUEEN_OF_HEARTS(10, CardSuit.HEARTS, CardRank.QUEEN),
        QUEEN_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.QUEEN),

        // KING
        KING_OF_SPADES(10, CardSuit.SPADES, CardRank.KING),
        KING_OF_CLUBS(10, CardSuit.CLUBS, CardRank.KING),
        KING_OF_HEARTS(10, CardSuit.HEARTS, CardRank.KING),
        KING_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.KING),

        // JOKER
        JOKER_RED(50, CardSuit.JOKER_RED, CardRank.JOKER),
        JOKER_BLACK(50, CardSuit.JOKER_BLACK, CardRank.JOKER),

        // Dummy, if this gets created, something is wrong.
        DUMMY(0, CardSuit.CLUBS, CardRank.DUMMY);

        private final int pointVal;
        private final CardSuit suit;
        private final CardRank rank;

        /**
         * Constructor.
         * @param pts The card point val.
         * @param suit The card's suit.
         * @param rank The card's rank.
         */
        Cards(int pts, CardSuit suit, CardRank rank) {
            this.pointVal = pts;
            this.suit = suit;
            this.rank = rank;
        }

        /**
         * Get the card's point val.
         * @return The card's point value.
         */
        public int getPointVal() {
            return pointVal;
        }

        /**
         * Get the card's suit.
         * @return The card's suit.
         */
        public CardSuit getSuit() {
            return suit;
        }

        /**
         * Get the card's rank.
         * @return The card's rank.
         */
        public CardRank getRank() {
            if (!isWild()) {
                return rank;
            } else {
                return CardRank.WILD;
            }
        }

        public boolean isWild() {
            return rank.equals(CardRank.TWO) || rank.equals(CardRank.JOKER);
        }
    }

    /**
     * Enum for card suits.
     *
     * @author Connor Clark.
     */
    public enum CardSuit {

        CLUBS(Color.BLACK),
        HEARTS(Color.RED),
        SPADES(Color.BLACK),
        DIAMONDS(Color.RED),
        JOKER_RED(Color.RED),
        JOKER_BLACK(Color.BLACK);

        private final Color color;

        CardSuit(Color c) {
            this.color =  c;
        }

        public Color getColor() {
            return color;
        }
    }

    public enum CardRank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        JOKER,
        /**
         * Used in Book maintenance.
         */
        WILD,
        DUMMY;
    }
}
