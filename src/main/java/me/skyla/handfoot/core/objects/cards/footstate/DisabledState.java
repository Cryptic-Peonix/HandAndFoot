package me.skyla.handfoot.core.objects.cards.footstate;

import me.skyla.handfoot.core.objects.cards.Foot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisabledState implements FootState{

    private static final Logger logger = LoggerFactory.getLogger(DisabledState.class);

    @Override
    public void enable(Foot foot) {
        logger.info("Foot cannot be enabled once disabled!");
    }

    @Override
    public void disable(Foot foot) {
        logger.info("Foot already disabled!");
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void printStatus() {
        logger.info("Foot disabled!");
    }
}
