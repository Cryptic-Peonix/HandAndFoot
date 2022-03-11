package me.skyla.handfoot.core.objects.cards.footstate;

import me.skyla.handfoot.core.objects.cards.Foot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnabledState implements FootState {

    private static final Logger logger = LoggerFactory.getLogger(EnabledState.class);

    @Override
    public void enable(Foot foot) {
        logger.info("Foot is already enabled!");
    }

    @Override
    public void disable(Foot foot) {
        foot.setState(new DisabledState());
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void printStatus() {
        logger.info("Foot en");
    }
}
