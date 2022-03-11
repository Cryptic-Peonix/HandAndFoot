package me.skyla.handfoot.core.objects.cards;

import me.skyla.handfoot.util.AssetRepo;
import org.jetbrains.annotations.Nullable;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.awt.image.BufferedImage;

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

    public void drawCard(int xC, int yC, int width, int height) {
        sketch.rect(xC, yC, width, height, 50);
        sketch.image(type.getImgAsResizedPImage(width, height), xC, yC, width, height);
    }

    @Override
    public String toString() {
        return type.toString();
    }

    /**
     * Checks if the card is a wild card.
     * @return True if the card is wild, false if not.
     */
    public boolean isWild() {
        return this.getType().isWild();
    }

    /**
     * Enum of all cards in a deck. Contains their point values and suits for easy access.
     *
     * @author Connor Clark
     */
    public enum Cards {

        // Ace
        ACE_OF_SPADES(20, CardSuit.SPADES, CardRank.ACE, AssetRepo.getAceOfSpades()),
        ACE_OF_CLUBS(20, CardSuit.CLUBS, CardRank.ACE, AssetRepo.getAceOfClubs()),
        ACE_OF_HEARTS(20, CardSuit.HEARTS, CardRank.ACE, AssetRepo.getAceOfHearts()),
        ACE_OF_DIAMONDS(20, CardSuit.DIAMONDS, CardRank.ACE, AssetRepo.getAceOfDiamonds()),

        // 2
        TWO_OF_SPADES(20, CardSuit.SPADES, CardRank.TWO, AssetRepo.getTwoOfSpades()),
        TWO_OF_CLUBS(20, CardSuit.CLUBS, CardRank.TWO, AssetRepo.getTwoOfClubs()),
        TWO_OF_HEARTS(20, CardSuit.HEARTS, CardRank.TWO, AssetRepo.getTwoOfHearts()),
        TWO_OF_DIAMONDS(20, CardSuit.DIAMONDS, CardRank.TWO, AssetRepo.getTwoOfDiamonds()),

        // 3
        THREE_OF_SPADES(-300, CardSuit.SPADES, CardRank.THREE, AssetRepo.getThreeOfSpades()),
        THREE_OF_CLUBS(-300, CardSuit.CLUBS, CardRank.THREE, AssetRepo.getThreeOfClubs()),
        THREE_OF_HEARTS(-500, CardSuit.HEARTS, CardRank.THREE, AssetRepo.getThreeOfHearts()),
        THREE_OF_DIAMONDS(-500, CardSuit.HEARTS, CardRank.THREE, AssetRepo.getThreeOfDiamonds()),

        // 4
        FOUR_OF_SPADES(5, CardSuit.SPADES, CardRank.FOUR, AssetRepo.getFourOfSpades()),
        FOUR_OF_CLUBS(5, CardSuit.CLUBS, CardRank.FOUR, AssetRepo.getFourOfClubs()),
        FOUR_OF_HEARTS(5, CardSuit.HEARTS, CardRank.FOUR, AssetRepo.getFourOfHearts()),
        FOUR_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.FOUR, AssetRepo.getFourOfDiamonds()),

        // 5
        FIVE_OF_SPADES(5, CardSuit.SPADES, CardRank.FIVE, AssetRepo.getFiveOfSpades()),
        FIVE_OF_CLUBS(5, CardSuit.CLUBS, CardRank.FIVE, AssetRepo.getFiveOfClubs()),
        FIVE_OF_HEARTS(5, CardSuit.HEARTS, CardRank.FIVE, AssetRepo.getFiveOfHearts()),
        FIVE_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.FIVE, AssetRepo.getFiveOfDiamonds()),

        // 6
        SIX_OF_SPADES(5, CardSuit.SPADES, CardRank.SIX, AssetRepo.getSixOfSpades()),
        SIX_OF_CLUBS(5, CardSuit.CLUBS, CardRank.SIX, AssetRepo.getSixOfClubs()),
        SIX_OF_HEARTS(5, CardSuit.HEARTS, CardRank.SIX, AssetRepo.getSixOfHearts()),
        SIX_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.SIX, AssetRepo.getSixOfDiamonds()),

        // 7
        SEVEN_OF_SPADES(5, CardSuit.SPADES, CardRank.SEVEN, AssetRepo.getSevenOfSpades()),
        SEVEN_OF_CLUBS(5, CardSuit.CLUBS, CardRank.SEVEN, AssetRepo.getSevenOfClubs()),
        SEVEN_OF_HEARTS(5, CardSuit.HEARTS, CardRank.SEVEN, AssetRepo.getSevenOfHearts()),
        SEVEN_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.SEVEN, AssetRepo.getSevenOfDiamonds()),

        // 8
        EIGHT_OF_SPADES(5, CardSuit.SPADES, CardRank.EIGHT, AssetRepo.getEightOfSpades()),
        EIGHT_OF_CLUBS(5, CardSuit.CLUBS, CardRank.EIGHT, AssetRepo.getEightOfClubs()),
        EIGHT_OF_HEARTS(5, CardSuit.HEARTS, CardRank.EIGHT, AssetRepo.getEightOfHearts()),
        EIGHT_OF_DIAMONDS(5, CardSuit.DIAMONDS, CardRank.EIGHT, AssetRepo.getEightOfDiamonds()),

        // 9
        NINE_OF_SPADES(10, CardSuit.SPADES, CardRank.NINE, AssetRepo.getNineOfSpades()),
        NINE_OF_CLUBS(10, CardSuit.CLUBS, CardRank.NINE, AssetRepo.getNineOfClubs()),
        NINE_OF_HEARTS(10, CardSuit.HEARTS, CardRank.NINE, AssetRepo.getNineOfHearts()),
        NINE_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.NINE, AssetRepo.getNineOfDiamonds()),

        // 10
        TEN_OF_SPADES(10, CardSuit.SPADES, CardRank.TEN, AssetRepo.getTenOfSpades()),
        TEN_OF_CLUBS(10, CardSuit.CLUBS, CardRank.TEN, AssetRepo.getTenOfClubs()),
        TEN_OF_HEARTS(10, CardSuit.HEARTS, CardRank.TEN, AssetRepo.getTenOfHearts()),
        TEN_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.TEN, AssetRepo.getTenOfDiamonds()),

        // JACK
        JACK_OF_SPADES(10, CardSuit.SPADES, CardRank.JACK, AssetRepo.getJackOfSpades()),
        JACK_OF_CLUBS(10, CardSuit.CLUBS, CardRank.JACK, AssetRepo.getJackOfClubs()),
        JACK_OF_HEARTS(10, CardSuit.HEARTS, CardRank.JACK, AssetRepo.getJackOfHearts()),
        JACK_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.JACK, AssetRepo.getJackOfDiamonds()),

        // QUEEN
        QUEEN_OF_SPADES(10, CardSuit.SPADES, CardRank.QUEEN, AssetRepo.getQueenOfSpades()),
        QUEEN_OF_CLUBS(10, CardSuit.CLUBS, CardRank.QUEEN, AssetRepo.getQueenOfClubs()),
        QUEEN_OF_HEARTS(10, CardSuit.HEARTS, CardRank.QUEEN, AssetRepo.getQueenOfHearts()),
        QUEEN_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.QUEEN, AssetRepo.getQueenOfDiamonds()),

        // KING
        KING_OF_SPADES(10, CardSuit.SPADES, CardRank.KING, AssetRepo.getKingOfSpades()),
        KING_OF_CLUBS(10, CardSuit.CLUBS, CardRank.KING, AssetRepo.getKingOfClubs()),
        KING_OF_HEARTS(10, CardSuit.HEARTS, CardRank.KING, AssetRepo.getKingOfHearts()),
        KING_OF_DIAMONDS(10, CardSuit.DIAMONDS, CardRank.KING, AssetRepo.getKingOfDiamonds()),

        // JOKER
        JOKER_RED(50, CardSuit.JOKER_RED, CardRank.JOKER, AssetRepo.getRedJoker()),
        JOKER_BLACK(50, CardSuit.JOKER_BLACK, CardRank.JOKER, AssetRepo.getBlackJoker()),

        // Dummy, if this gets created, something is wrong.
        DUMMY(0, CardSuit.CLUBS, CardRank.DUMMY, null);

        private final int pointVal;
        private final CardSuit suit;
        private final CardRank rank;
        private BufferedImage img;

        /**
         * Constructor.
         * @param pts The card point val.
         * @param suit The card's suit.
         * @param rank The card's rank.
         */
        Cards(int pts, CardSuit suit, CardRank rank, BufferedImage img) {
            this.pointVal = pts;
            this.suit = suit;
            this.rank = rank;
            this.img = img;
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

        /**
         * Get the cards image.
         * @return The image associated with the card.
         */
        public BufferedImage getImg() {
            return img;
        }

        /**
         * Resizes the image with width pX and height pY.
         * @param pX New image width in pixels.
         * @param pY New image height in pixels.
         * @return A new image with width pX and height pY
         */
        private Image resizeImg(int pX, int pY) {
            return  img.getScaledInstance(pX, pY, Image.SCALE_SMOOTH);
        }

        /**
         * Gets the image resized.
         * @param width The new image width in px.
         * @param height The new image height in px.
         * @return A BufferedImage of the card with width 'width' and height 'height'.
         */
        public Image getImgResized(int width, int height) {
            Image i = resizeImg(width, height);
            return i;
        }

        /**
         * Gets the image as a PImage for use in processing.
         * @return A PImage of the card image.
         */
        public PImage getImgAsPImage() {
            return new PImage(img);
        }

        /**
         * Gets a resized version of the card image as a PImage.
         * @param width The width of the new PImage in px.
         * @param height The height of the new PImage in px.
         * @return A PImage of the card with width 'width' and height 'height'.
         */
        public PImage getImgAsResizedPImage(int width, int height) {
            Image i = resizeImg(width, height);
            return new PImage(i);
        }

        /**
         * Checks if the card is wild. 2s and Jokers are wild cards.
         * @return True if it is, false if not.
         */
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
        DUMMY
    }
}
