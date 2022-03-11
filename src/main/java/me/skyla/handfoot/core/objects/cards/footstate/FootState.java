package me.skyla.handfoot.core.objects.cards.footstate;

import me.skyla.handfoot.core.objects.cards.Foot;

public interface FootState {
    void enable(Foot foot);
    void disable(Foot foot);
    boolean isEnabled();
    void printStatus();
}
