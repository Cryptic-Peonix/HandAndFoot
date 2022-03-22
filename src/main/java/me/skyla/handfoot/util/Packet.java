package me.skyla.handfoot.util;

import me.skyla.handfoot.core.objects.cards.Game;

/**
 * Packet class
 */
public class Packet {

    private final String name;
    private final Game game;

    public Packet(String n, Game g) {
        this.name = n;
        this.game=g;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }
}
