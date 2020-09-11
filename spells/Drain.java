package spells;

import main.Constants;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public final class Drain extends Spell implements Ability {

    public Drain(final Wizard harry, final Knight knight)
    {
        super(0, 0, 0, 0,
            Constants.D_TERRAIN_BONUS, Constants.DRAIN_K_BONUS, harry, Constants.DESERT);
        damage = (Constants.DRAIN_BASE + Constants.DRAIN_GROWTH * caster.getLevel())
            * Math.min(knight.getCurrHP(), Constants.DRAIN_HP_LIMIT * knight.getMaxHP());
    }

    public Drain(final Wizard harry, final Rogue rogue)
    {
        super(0, 0, 0, 0,
            Constants.D_TERRAIN_BONUS, Constants.DRAIN_R_BONUS, harry, Constants.DESERT);
        damage = (Constants.DRAIN_BASE + Constants.DRAIN_GROWTH * caster.getLevel())
            * Math.min(rogue.getCurrHP(), Constants.DRAIN_HP_LIMIT * rogue.getMaxHP());
    }

    public Drain(final Wizard harry, final Wizard wizard)
    {
        super(0, 0, 0, 0,
            Constants.D_TERRAIN_BONUS, Constants.DRAIN_W_BONUS, harry, Constants.DESERT);
        damage = (Constants.DRAIN_BASE + Constants.DRAIN_GROWTH * caster.getLevel())
            * Math.min(wizard.getCurrHP(), Constants.DRAIN_HP_LIMIT * wizard.getMaxHP());
    }

    public Drain(final Wizard harry, final Pyromancer pyromancer)
    {
        super(0, 0, 0, 0,
            Constants.D_TERRAIN_BONUS, Constants.DRAIN_P_BONUS, harry, Constants.DESERT);
        damage = (Constants.DRAIN_BASE + Constants.DRAIN_GROWTH * caster.getLevel())
            * Math.min(pyromancer.getCurrHP(),
                  Constants.DRAIN_HP_LIMIT * pyromancer.getMaxHP());
    }
}
