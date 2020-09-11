package spells;

import champions.Champion;

import java.util.List;

public class Spell {
    protected float damage;
    protected int dotDamage;
    protected int dotTimer;
    protected int rootTimer;
    protected float raceBonus;
    protected float landBonus;
    protected char prefLand;
    protected Champion caster;

    Spell(final float damage, final int dotDamage, final int dotTimer,
        final int rootTimer, final float landBonus, final float raceBonus,
        final Champion caster, final char prefLand)
    {
        this.damage = damage;
        this.dotDamage = dotDamage;
        this.dotTimer = dotTimer;
        this.rootTimer = rootTimer;
        this.landBonus = landBonus;
        this.raceBonus = raceBonus;
        this.caster = caster;
        this.prefLand = prefLand;
    }

    /*
        returns damage dealt by the spell
     */
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
            int dmg = Math.round(damage * landBonus);
            return Math.round(dmg * fmm);
        }
        return Math.round(damage * fmm);
    }

    /*
        returns damage dealt by the spell without the race bonus
     */
    public float getUnracistDamage()
    {
        if (caster.getLand() == prefLand) {
            return Math.round(damage * landBonus);
        }
        return Math.round(damage);
    }

    /*
        returns damage over time dealt by the spell in a round
     */
    public int getDotDamage()
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
            int dmg = Math.round(dotDamage * landBonus);
            return Math.round(dmg * fmm);
        }
        return Math.round(dotDamage * fmm);
    }

    /*
        returns number of rounds the spell applies the DoT effect
     */
    public int getDotTimer()
    {
        return dotTimer;
    }

    /*
        returns number of rounds the spell immobilizes a champion
     */
    public int getRootTimer()
    {
        return rootTimer;
    }
}
