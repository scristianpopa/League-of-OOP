package spells;

import main.Constants;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public final class Slam extends Spell implements Ability {

    public Slam(final Knight arthur, final Knight knight)
    {
        super(Constants.SLAM_BASE + Constants.SLAM_GROWTH * arthur.getLevel(), 0, 0,
            1, Constants.L_TERRAIN_BONUS, Constants.SLAM_K_BONUS, arthur, Constants.LAND);
    }

    public Slam(final Knight arthur, final Rogue rogue)
    {
        super(Constants.SLAM_BASE + Constants.SLAM_GROWTH * arthur.getLevel(), 0, 0,
            1, Constants.L_TERRAIN_BONUS, Constants.SLAM_R_BONUS, arthur, Constants.LAND);
    }

    public Slam(final Knight arthur, final Wizard wizard)
    {
        super(Constants.SLAM_BASE + Constants.SLAM_GROWTH * arthur.getLevel(), 0, 0,
            1, Constants.L_TERRAIN_BONUS, Constants.SLAM_W_BONUS, arthur, Constants.LAND);
    }

    public Slam(final Knight arthur, final Pyromancer pyromancer)
    {
        super(Constants.SLAM_BASE + Constants.SLAM_GROWTH * arthur.getLevel(), 0, 0,
            1, Constants.L_TERRAIN_BONUS, Constants.SLAM_P_BONUS, arthur, Constants.LAND);
    }
}
