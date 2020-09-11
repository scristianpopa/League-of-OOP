package spells;

import main.Constants;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public final class Deflect extends Spell implements Ability {

    public Deflect(final Wizard harry, final Knight knight)
    {
        super(0, 0, 0, 0,
            Constants.D_TERRAIN_BONUS, Constants.DEFLECT_K_BONUS, harry, Constants.DESERT);
        Effects effects = knight.getEffects(harry);
        damage = Math.min((Constants.DEFLECT_BASE + Constants.DEFLECT_GROWTH * caster.getLevel()),
                     Constants.DEFLECT_MAX)
            * effects.getUnracistDamage();
    }

    public Deflect(final Wizard harry, final Rogue rogue)
    {
        super(0, 0, 0, 0,
            Constants.D_TERRAIN_BONUS, Constants.DEFLECT_R_BONUS, harry, Constants.DESERT);
        Effects effects = rogue.getEffects(harry);
        damage = Math.min((Constants.DEFLECT_BASE + Constants.DEFLECT_GROWTH * caster.getLevel()),
                     Constants.DEFLECT_MAX)
            * effects.getUnracistDamage();
    }

    public Deflect(final Wizard harry, final Wizard wizard)
    {
        super(0, 0, 0, 0,
            Constants.D_TERRAIN_BONUS, Constants.DEFLECT_W_BONUS, harry, Constants.DESERT);
    }

    public Deflect(final Wizard harry, final Pyromancer pyromancer)
    {
        super(0, 0, 0, 0,
            Constants.D_TERRAIN_BONUS, Constants.DEFLECT_P_BONUS, harry, Constants.DESERT);
        Effects effects = pyromancer.getEffects(harry);
        damage = Math.min((Constants.DEFLECT_BASE + Constants.DEFLECT_GROWTH * caster.getLevel()),
                     Constants.DEFLECT_MAX)
            * effects.getUnracistDamage();
    }
}
