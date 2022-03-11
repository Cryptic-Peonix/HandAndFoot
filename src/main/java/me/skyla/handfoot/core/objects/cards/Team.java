package me.skyla.handfoot.core.objects.cards;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A team is a group of two players! There is usually 2 teams in each game.
 * Players can customize their team names.
 *
 * @author Connor Clark.
 */
public class Team {

    private final byte MAX_PLAYERS_PER_TEAM = 2;
    private final HashMap<String, Player> PLAYERS = new HashMap<>();
    private final String NAME;

    public Team(Player p1, Player p2, String name) {
        PLAYERS.put("Player 1", p1);
        PLAYERS.put("Player 2", p2);
        NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    public Player getPlayerOne() {
        return PLAYERS.get("Player 1");
    }

    public Player getPlayerTwo() {
        return PLAYERS.get("Player 2");
    }
}
