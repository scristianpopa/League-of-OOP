package spells;

import main.Constants;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public final class Paralysis extends Spell implements Ability {

    public Paralysis(final Rogue one, final Knight knight)
    {
        super(Constants.PARALYSIS_BASE + Constants.PARALYSIS_GROWTH * one.getLevel(),
            Constants.PARALYSIS_BASE + Constants.PARALYSIS_GROWTH * one.getLevel(),
            Constants.PARALYSIS_SMALL, Constants.PARALYSIS_SMALL, Constants.W_TERRAIN_BONUS,
            Constants.PARALYSIS_K_BONUS, one, Constants.WOODS);
        if (one.getLand() == prefLand) {
            dotTimer = Constants.PARALYSIS_BIG;
            rootTimer = Constants.PARALYSIS_BIG;
        }
    }

    public Paralysis(final Rogue one, final Rogue rogue)
    {
        super(Constants.PARALYSIS_BASE + Constants.PARALYSIS_GROWTH * one.getLevel(),
            Constants.PARALYSIS_BASE + Constants.PARALYSIS_GROWTH * one.getLevel(),
            Constants.PARALYSIS_SMALL, Constants.PARALYSIS_SMALL, Constants.W_TERRAIN_BONUS,
            Constants.PARALYSIS_R_BONUS, one, Constants.WOODS);
        if (one.getLand() == prefLand) {
            dotTimer = Constants.PARALYSIS_BIG;
            rootTimer = Constants.PARALYSIS_BIG;
        }
    }

    public Paralysis(final Rogue one, final Wizard wizard)
    {
        super(Constants.PARALYSIS_BASE + Constants.PARALYSIS_GROWTH * one.getLevel(),
            Constants.PARALYSIS_BASE + Constants.PARALYSIS_GROWTH * one.getLevel(),
            Constants.PARALYSIS_SMALL, Constants.PARALYSIS_SMALL, Constants.W_TERRAIN_BONUS,
            Constants.PARALYSIS_W_BONUS, one, Constants.WOODS);
        if (one.getLand() == prefLand) {
            dotTimer = Constants.PARALYSIS_BIG;
            rootTimer = Constants.PARALYSIS_BIG;
        }
    }

    public Paralysis(final Rogue one, final Pyromancer pyromancer)
    {
        super(Constants.PARALYSIS_BASE + Constants.PARALYSIS_GROWTH * one.getLevel(),
            Constants.PARALYSIS_BASE + Constants.PARALYSIS_GROWTH * one.getLevel(),
            Constants.PARALYSIS_SMALL, Constants.PARALYSIS_SMALL, Constants.W_TERRAIN_BONUS,
            Constants.PARALYSIS_P_BONUS, one, Constants.WOODS);
        if (one.getLand() == prefLand) {
            dotTimer = Constants.PARALYSIS_BIG;
            rootTimer = Constants.PARALYSIS_BIG;
        }
    }
}
