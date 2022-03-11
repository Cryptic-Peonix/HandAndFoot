package me.skyla.handfoot.core.objects.cards;

import me.skyla.handfoot.Main;
import me.skyla.handfoot.core.objects.cards.footstate.EnabledState;
import me.skyla.handfoot.core.objects.cards.footstate.FootState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A foot is a secondary pile of 10 cards that a player gets at the beginning of the game.
 * Once they use all the cards in their hand, they pick up their foot!
 *
 * @author Connor Clark.
 */
public class Foot {

    private final String name;
    private final byte MAX_CARDS = 10;
    private final ArrayList<Card> cards = new ArrayList<>();
    private FootState state = new EnabledState();
    private static final Logger logger = LoggerFactory.getLogger(Foot.class);
    private int footPointVal;

    /**
     * Constructor. Makes a foot with a Collection of Cards and a name.
     * @param cards The cards to add to the foot (MUST NOT EXCEED 10)
     * @param name The name of the foot (player-name foot)
     */
    public Foot(Collection<Card> cards, String name) {
        addCards(cards);
        this.name = name;
    }

    /**
     * Adds a Collection of cards to the foot.
     * @param cards The collection to add.
     */
    private void addCards(Collection<Card> cards) {
        if (cards.size() <= MAX_CARDS) {
            for (Card c : cards) {
                addCard(c);
            }
        } else {
            logger.error("You must use exactly 10 cards when making a foot!");
        }
    }

    /**
     * Adds a card to the foot.
     * @param c The card to add.
     */
    private void addCard(Card c) {
        int pts = c.getType().getPointVal();
        if (isEnabled()) {
            if (!checkOverflow()) {
                cards.add(c);
                if (pts > 0) {
                    footPointVal += pts;
                } else {
                    footPointVal -= pts;
                }
            } else {
                logger.error("Card: " + c + " Could not be added to the foot, would overflow!");
            }
        } else {
            logger.error("Foot disabled! Cannot add cards.");
        }
    }

    /**
     * Checks if the foot will overflow if another card is added.
     * @return True if it will overflow, false if not.
     */
    private boolean checkOverflow() {
        return cards.size() + 1 > MAX_CARDS;
    }

    /**
     * Sets the state of the foot. DO NOT USE OUTSIDE OF FOOT AND
     * FOOT STATE CLASSES!!!
     * @param state The state to change to.
     */
    public void setState(FootState state) {
        this.state = state;
    }

    /**
     * Gets the name of the foot.
     * @return The name of the foot.
     */
    public String getName() {
        return name;
    }

    /**
     * Cannot enable from outside classes. Once disabled, disabled for good.
     */
    private void enable() {
        state.enable(this);
    }

    /**
     * Checks if the foot is enabled.
     * @return True if enabled, false if not.
     */
    public boolean isEnabled() {
        return state.isEnabled();
    }

    /**
     * Disables the foot.
     */
    public void disable() {
        state.disable(this);
        cards.clear();
    }

    /**
     * Get the cards of this foot.
     * @return The ArrayList of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Get the foot's point value. Use if game has ended and foot is still open.
     * @return The foot point value.
     */
    public int getFootPointVal() {
        if (isEnabled()) {
            return footPointVal;
        } else {
            Main.getLogger().info("Cannot get the point value of this foot, it is disabled.");
            return 0;
        }
    }

    /**
     * Prints the state status of the foot.
     */
    public void enabledStatus() {
        state.printStatus();
    }

    @Override
    public String toString() {
        return "Foot{" +
                ", cards=" + cards +
                ", state=" + state +
                ", footPointVal=" + footPointVal +
                '}';
    }
}
