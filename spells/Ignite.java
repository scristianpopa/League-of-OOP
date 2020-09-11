package spells;

import main.Constants;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public final class Ignite extends Spell implements Ability {
    public Ignite(final Pyromancer pyro, final Knight knight)
    {
        super(Constants.IGNITE_BASE + Constants.IGNITE_GROWTH * pyro.getLevel(),
            Constants.IGNITE_DOT_BASE + Constants.IGNITE_DOT_GROWTH * pyro.getLevel(),
            Constants.IGNITE_TIMER, 0, Constants.P_TERRAIN_BONUS, Constants.P_K_BONUS,
            pyro, Constants.VOLCANIC);
    }

    public Ignite(final Pyromancer pyro, final Rogue rogue)
    {
        super(Constants.IGNITE_BASE + Constants.IGNITE_GROWTH * pyro.getLevel(),
            Constants.IGNITE_DOT_BASE + Constants.IGNITE_DOT_GROWTH * pyro.getLevel(),
            Constants.IGNITE_TIMER, 0, Constants.P_TERRAIN_BONUS, Constants.P_R_BONUS,
            pyro, Constants.VOLCANIC);
    }

    public Ignite(final Pyromancer pyro, final Wizard wizard)
    {
        super(Constants.IGNITE_BASE + Constants.IGNITE_GROWTH * pyro.getLevel(),
            Constants.IGNITE_DOT_BASE + Constants.IGNITE_DOT_GROWTH * pyro.getLevel(),
            Constants.IGNITE_TIMER, 0, Constants.P_TERRAIN_BONUS, Constants.P_W_BONUS,
            pyro, Constants.VOLCANIC);
    }

    public Ignite(final Pyromancer pyro, final Pyromancer pyromancer)
    {
        super(Constants.IGNITE_BASE + Constants.IGNITE_GROWTH * pyro.getLevel(),
            Constants.IGNITE_DOT_BASE + Constants.IGNITE_DOT_GROWTH * pyro.getLevel(),
            Constants.IGNITE_TIMER, 0, Constants.P_TERRAIN_BONUS, Constants.P_P_BONUS,
            pyro, Constants.VOLCANIC);
    }
}
