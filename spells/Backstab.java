package spells;

import main.Constants;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

import java.util.List;

public final class Backstab extends Spell implements Ability {

    public Backstab(final Rogue one, final Knight knight)
    {
        super(Constants.BACKSTAB_BASE + Constants.BACKSTAB_GROWTH * one.getLevel(), 0, 0,
            0, Constants.W_TERRAIN_BONUS, Constants.BACKSTAB_K_BONUS, one, Constants.WOODS);
    }

    public Backstab(final Rogue one, final Rogue rogue)
    {
        super(Constants.BACKSTAB_BASE + Constants.BACKSTAB_GROWTH * one.getLevel(), 0, 0,
            0, Constants.W_TERRAIN_BONUS, Constants.BACKSTAB_R_BONUS, one, Constants.WOODS);
    }

    public Backstab(final Rogue one, final Wizard wizard)
    {
        super(Constants.BACKSTAB_BASE + Constants.BACKSTAB_GROWTH * one.getLevel(), 0, 0,
            0, Constants.W_TERRAIN_BONUS, Constants.BACKSTAB_W_BONUS, one, Constants.WOODS);
    }

    public Backstab(final Rogue one, final Pyromancer pyromancer)
    {
        super(Constants.BACKSTAB_BASE + Constants.BACKSTAB_GROWTH * one.getLevel(), 0, 0,
            0, Constants.W_TERRAIN_BONUS, Constants.BACKSTAB_P_BONUS, one, Constants.WOODS);
    }

    @Override
    public int getDamage()
    {
        float fmm = raceBonus;
        List<Float> ang = caster.getAngelBuff();
        List<Float> strat = caster.getStratBuff();
        for (Float f : ang) {
            fmm += f;
        }
        for (Float f : strat) {
            fmm += f;
        }
        if (caster.getLand() == prefLand) {
            if (((Rogue)caster).getFights() % Constants.BACKSTAB_RESET == 0) {
                int dmg = Math.round(Constants.BACKSTAB_CRIT * damage * landBonus);
                return Math.round(dmg * fmm);
            }
            int dmg = Math.round(damage * landBonus);
            return Math.round(dmg * fmm);
        }
        return Math.round(damage * fmm);
    }

    @Override
    public float getUnracistDamage()
    {
        if (caster.getLand() == prefLand) {
            if (((Rogue)caster).getFights() % Constants.BACKSTAB_RESET == 0) {
                return Math.round(Constants.BACKSTAB_CRIT * damage * landBonus);
            }
            return Math.round(damage * landBonus);
        }
        return Math.round(damage);
    }
}
