package me.skyla.handfoot.core.objects.cards;

import me.skyla.handfoot.Main;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Each team should have one board that contains their cards. A board will also contain all the teams books.
 *
 * @author Connor Clark.
 */
public class Board {

    private final Team TEAM;
    private final ArrayList<Book> BOOK_LIST = new ArrayList<>();
    private final PApplet sketch;

    /**
     * Hashmap to keep track of what types of books have been created.
     * If the value is false, the book has not been created on this board.
     *
     * Eligible book types are: ace, three, four, five, six, seven, eight, nine, ten, jack, queen, king, wild.
     */
    private final HashMap<Card.CardRank, Boolean> booksCreated = new HashMap<>();
    private int score;

    /**
     * Constructor for a board. Takes in a team.
     * @param team The team to add.
     * @param sketch The game sketch.
     */
    public Board(Team team, PApplet sketch) {
        this.TEAM = team;
        setupHashMap();
        this.sketch = sketch;
    }

    /**
     * Add a book to the board.
     * @param b The book to add.
     */
    private void addBook(Book b) {
        if (!booksCreated.get(b.getRank())) {
            BOOK_LIST.add(b);
            booksCreated.put(b.getRank(), true);
            updateScore();
        } else {
            Main.getLogger().error("Book cannot be created, book of rank: " + b.getRank()   + " already exists!");
        }
    }

    /**
     * Add a card to an existing book on the board.
     * @param card The card to add to a book.
     * @param rank The rank of the book the cards should be added to.
     */
    private void addCardToBook(Card card, Card.CardRank rank) {
        if (booksCreated.get(rank)) {
            BOOK_LIST.get(getIndexOfBookWithRank(rank)).addCard(card);
            updateScore();
        } else {
            Main.getLogger().error("Cannot add cards to book, book of rank: " + rank + " does not exist!");
        }
    }

    /**
     * Add a collection of cards to an existing book on the board.
     * @param cards The collection of cards to add.
     * @param rank The rank of the book to add to.
     */
    private void addCardsToBook(Collection<Card> cards, Card.CardRank rank) {
        for (Card c: cards) {
            addCardToBook(c, rank);
        }
    }

    /**
     * Use this method when adding a collection of cards to the board. If a book of the rank of the card
     * collection has been created, the cards will be added to that book. If not, a new book will be created
     * using that rank.
     * @param cards The cards to add to the board.
     */
    public void addCardsToBoard(Collection<Card> cards) {
        Card.CardRank rank = CardUtil.getRankFromCollection(cards);
        // If a book of the card rank has NOT been created, make the book.
        if (!booksCreated.get(rank)) {
            addBook(new Book(cards, sketch));
        } else { // If a book of the card rank has been created, add the cards to it.
            addCardsToBook(cards, rank);
        }
    }

    /**
     * Use this method to add a card to the board. The card will be added to a book of its rank if that book is created.
     * @param c The card to add.
     */
    public void addCardToBoard(Card c)  {
        Card.CardRank rank = c.getType().getRank();
        if (booksCreated.get(rank)) {
            addCardToBook(c, rank);
        } else {
            Main.getLogger().error("Card cannot be added to board! Book of rank: " + rank + " does not exist!");
        }
    }

    /**
     * Use this method to add a wild card to a book on the board.
     * @param c The card to add.
     * @param rank The rank of the book to add the card to.
     */
    public void addWildToBoard(Card c, Card.CardRank rank) {
        if (c.isWild()) {
            if (booksCreated.get(rank)) {
                addCardToBook(c, rank);
            } else {
                Main.getLogger().error("Cannot add wild to board because book of rank: " + rank + " does not exist!");
            }
        } else {
            Main.getLogger().error("Card must be wild to use addWildToBoard()!");
        }
    }

    /**
     * Updates the score of the board.
     */
    private void updateScore() {
        for (Book b : BOOK_LIST) {
            score += b.getTotalPointVal();
        }
    }

    /**
     * Gets the index of a book of a certain rank if it exists.
     * @param rank The rank to look for.
     * @return The index of the book if it exists, -1 if it does not exist.
     */
    private int getIndexOfBookWithRank(Card.CardRank rank) {
        if (booksCreated.get(rank)) {
            for (int i = 0; i < BOOK_LIST.size(); i++) {
                if (BOOK_LIST.get(i).getRank().equals(rank)) {
                    return i;
                }
            }
        }
        // code should not get here
        return -1;
    }

    /**
     * Private method to set up the board hash map.
     */
    private void setupHashMap() {
        booksCreated.put(Card.CardRank.ACE, false);
        booksCreated.put(Card.CardRank.THREE, false);
        booksCreated.put(Card.CardRank.FOUR, false);
        booksCreated.put(Card.CardRank.FIVE, false);
        booksCreated.put(Card.CardRank.SIX, false);
        booksCreated.put(Card.CardRank.SEVEN, false);
        booksCreated.put(Card.CardRank.EIGHT, false);
        booksCreated.put(Card.CardRank.NINE, false);
        booksCreated.put(Card.CardRank.TEN, false);
        booksCreated.put(Card.CardRank.JACK, false);
        booksCreated.put(Card.CardRank.QUEEN, false);
        booksCreated.put(Card.CardRank.KING, false);
        booksCreated.put(Card.CardRank.WILD, false);

    }

    /**
     * Get the score of the board.
     * @return An int of the score.
     */
    public int getScore() {
        updateScore();
        return score;
    }

    /**
     * Get the team on this board.
     * @return The team.
     */
    public Team getTEAM() {
        return TEAM;
    }
}
