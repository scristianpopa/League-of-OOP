package spells;

import main.Constants;
import champions.Champion;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

import java.util.List;

public final class Execute extends Spell implements Ability {
    private Champion enemy;
    private float instaLimit;

    public Execute(final Knight arthur, final Knight knight)
    {
        super(Constants.EXECUTE_BASE + Constants.EXECUTE_GROWTH * arthur.getLevel(), 0, 0,
            0, Constants.L_TERRAIN_BONUS, Constants.EXECUTE_K_BONUS, arthur, Constants.LAND);
        enemy = knight;
        instaLimit = Math.min(Constants.EXECUTE_LIMIT_BASE
                + Constants.EXECUTE_LIMIT_GROWTH * caster.getLevel(),
            Constants.EXECUTE_LIMIT_MAX);
    }

    public Execute(final Knight arthur, final Rogue rogue)
    {
        super(Constants.EXECUTE_BASE + Constants.EXECUTE_GROWTH * arthur.getLevel(), 0, 0,
            0, Constants.L_TERRAIN_BONUS, Constants.EXECUTE_R_BONUS, arthur, Constants.LAND);
        enemy = rogue;
        instaLimit = Math.min(Constants.EXECUTE_LIMIT_BASE
                + Constants.EXECUTE_LIMIT_GROWTH * caster.getLevel(),
            Constants.EXECUTE_LIMIT_MAX);
    }

    public Execute(final Knight arthur, final Wizard wizard)
    {
        super(Constants.EXECUTE_BASE + Constants.EXECUTE_GROWTH * arthur.getLevel(), 0, 0,
            0, Constants.L_TERRAIN_BONUS, Constants.EXECUTE_W_BONUS, arthur, Constants.LAND);
        enemy = wizard;
        instaLimit = Math.min(Constants.EXECUTE_LIMIT_BASE
                + Constants.EXECUTE_LIMIT_GROWTH * caster.getLevel(),
            Constants.EXECUTE_LIMIT_MAX);
    }

    public Execute(final Knight arthur, final Pyromancer pyromancer)
    {
        super(Constants.EXECUTE_BASE + Constants.EXECUTE_GROWTH * arthur.getLevel(), 0, 0,
            0, Constants.L_TERRAIN_BONUS, Constants.EXECUTE_P_BONUS, arthur, Constants.LAND);
        enemy = pyromancer;
        instaLimit = Math.min(Constants.EXECUTE_LIMIT_BASE
                + Constants.EXECUTE_LIMIT_GROWTH * caster.getLevel(),
            Constants.EXECUTE_LIMIT_MAX);
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
        if (enemy.getType() != 'K') {
            if (Math.round(instaLimit * enemy.getMaxHP()) < enemy.getCurrHP()) {
                if (caster.getLand() == prefLand) {
                    int dmg = Math.round(damage * landBonus);
                    return Math.round(dmg * fmm);
                }
                return Math.round(damage * fmm);
            }
            return enemy.getCurrHP();
        }
        if (Math.round(instaLimit * enemy.getMaxHP()) < enemy.getCurrHP()) {
            if (caster.getLand() == prefLand) {
                int dmg = Math.round(damage * landBonus);
                return Math.round(dmg * raceBonus);
            }
            return Math.round(damage * raceBonus);
        }
        return enemy.getCurrHP();
    }

    @Override
    public float getUnracistDamage()
    {
        if (caster.getLand() == prefLand) {
            return Math.round(damage * landBonus);
        }
        return Math.round(damage);
    }
}
