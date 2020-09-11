package spells;

import main.Constants;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public final class Fireblast extends Spell implements Ability {
    public Fireblast(final Pyromancer pyro, final Knight knight)
    {
        super(Constants.FIREBLAST_BASE + Constants.FIREBLAST_GROWTH * pyro.getLevel(), 0, 0,
            0, Constants.P_TERRAIN_BONUS, Constants.P_K_BONUS, pyro, Constants.VOLCANIC);
    }

    public Fireblast(final Pyromancer pyro, final Rogue rogue)
    {
        super(Constants.FIREBLAST_BASE + Constants.FIREBLAST_GROWTH * pyro.getLevel(), 0, 0,
            0, Constants.P_TERRAIN_BONUS, Constants.P_R_BONUS, pyro, Constants.VOLCANIC);
    }

    public Fireblast(final Pyromancer pyro, final Wizard wizard)
    {
        super(Constants.FIREBLAST_BASE + Constants.FIREBLAST_GROWTH * pyro.getLevel(), 0, 0,
            0, Constants.P_TERRAIN_BONUS, Constants.P_W_BONUS, pyro, Constants.VOLCANIC);
    }

    public Fireblast(final Pyromancer pyro, final Pyromancer pyromancer)
    {
        super(Constants.FIREBLAST_BASE + Constants.FIREBLAST_GROWTH * pyro.getLevel(), 0, 0,
            0, Constants.P_TERRAIN_BONUS, Constants.P_P_BONUS, pyro, Constants.VOLCANIC);
    }
}
