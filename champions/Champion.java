package champions;

import angels.DamageAngel;
import angels.DarkAngel;
import angels.Dracula;
import angels.Doomer;
import angels.Goodboy;
import angels.SmallAngel;
import angels.Spawner;
import angels.XPAngel;
import angels.LevelUpAngel;
import angels.LifeGiver;
import strategies.Strategy;
import main.Constants;
import spells.Effects;

import java.util.ArrayList;
import java.util.List;

public abstract class Champion {
    private char type;
    private int maxHP;
    private int currHP;
    private int hpGrowth;
    private int level;
    private int currExp;
    private char land;
    private int receiveDot;
    private int dotRounds;
    private int rootRounds;
    private boolean alive;
    private List<Float> angelBuff;
    private List<Float> stratBuff;
    protected Strategy strategy;

    public Champion(final char type, final int hp, final int hpGrowth)
    {
        this.type = type;
        this.maxHP = hp;
        this.currHP = hp;
        this.hpGrowth = hpGrowth;
        level = 0;
        currExp = 0;
        receiveDot = 0;
        dotRounds = 0;
        rootRounds = 0;
        alive = true;
        angelBuff = new ArrayList<Float>();
        stratBuff = new ArrayList<Float>();
    }

    /*
        applies the dot of previous fights
     */

    public void flashbackDMG()
    {
        if (dotRounds > 0) {
            --dotRounds;
            currHP -= receiveDot;
            if (currHP <= 0) {
                setAlive(false);
            }
        }
    }

    /*
        pass root rounds while alive
     */

    public void flashbackROOT()
    {
        if (rootRounds > 0) {
            --rootRounds;
        }
    }

    /*
        pass dot rounds and root rounds while dead
     */

    public void whileDead()
    {
        if (rootRounds > 0) {
            --rootRounds;
        }
        if (dotRounds > 0) {
            --dotRounds;
        }
    }

    /*
        gain amount exp
     */

    public void gainExp(final int amount)
    {
        currExp += amount;
        if (currExp < Constants.LEVEL0_EXP) {
            return;
        }
        int oldLevel = level;
        level = Math.max((currExp - Constants.LEVEL0_EXP) / Constants.LEVEL_UP_EXP + 1, 0);
        maxHP += hpGrowth * (level - oldLevel);
        if (this.isAlive() && oldLevel != level) {
            currHP = maxHP;
        }
    }

    /*
        level up till next level
     */

    public void autoLevelUp()
    {
        if (level == 0) {
            gainExp(Constants.LEVEL0_EXP - currExp);
        } else {
            int gain = Constants.LEVEL_UP_EXP - currExp % Constants.LEVEL_UP_EXP;
            gainExp(gain);
        }
    }

    /*
        gain amount hp
     */

    public final void gainHP(final int amount)
    {
        currHP = Math.min(maxHP, currHP + amount);
        currHP = Math.max(0, currHP);
        if (currHP == 0) {
            setAlive(false);
        }
    }

    /*
        gain a new angel buff
     */

    public final void gainBuff(final float amount)
    {
        angelBuff.add(amount);
    }

    /*
        used for the strategy modifications
     */

    public final void gainStratBuff(final float coefAmount, final int hpModif)
    {
        stratBuff.add(coefAmount);
        if (hpModif > 0) {
            currHP = (currHP * (hpModif + 1)) / hpModif;
        } else {
            int hpModifNew = -1 * hpModif;
            currHP = (currHP * (hpModifNew - 1)) / hpModifNew;
        }
    }

    public abstract void applyStrategy();

    /*
        applies the effects of the current round fight
        it refreshes the DoT and root timer and applies the damage received
     */
    public void refreshStats(final Effects effects)
    {
        if (effects.getRootTimer() > 0) {
            rootRounds = effects.getRootTimer();
        }
        if (effects.getDotTimer() > 0) {
            dotRounds = effects.getDotTimer();
            receiveDot = effects.getDotDamage();
        }
        currHP -= effects.getDamage();
        if (currHP <= 0) {
            setAlive(false);
        }
    }

    public void incFights()
    {
    }

    public abstract Effects getEffects(Knight enemy);

    public abstract Effects getEffects(Rogue enemy);

    public abstract Effects getEffects(Wizard enemy);

    public abstract Effects getEffects(Pyromancer enemy);

    public abstract Effects fight(Knight enemy);

    public abstract Effects fight(Rogue enemy);

    public abstract Effects fight(Wizard enemy);

    public abstract Effects fight(Pyromancer enemy);

    /*
        calls the appropiate fight method
     */
    public Effects fight(final Champion enemy)
    {
        switch (enemy.getType()) {
        case Constants.KNIGHT:
            return fight((Knight)enemy);
        case Constants.ROGUE:
            return fight((Rogue)enemy);
        case Constants.WIZARD:
            return fight((Wizard)enemy);
        case Constants.PYROMANCER:
            return fight((Pyromancer)enemy);
        default:
            return new Effects();
        }
    }

    public abstract void reveiveBlessing(DamageAngel damageAngel);

    public abstract void reveiveBlessing(DarkAngel darkAngel);

    public abstract void reveiveBlessing(Dracula dracula);

    public abstract void reveiveBlessing(Goodboy goodboy);

    public abstract void reveiveBlessing(LevelUpAngel levelUpAngel);

    public abstract void reveiveBlessing(LifeGiver lifeGiver);

    public abstract void reveiveBlessing(SmallAngel smallAngel);

    public abstract void reveiveBlessing(Spawner spawner);

    /*
        get killed
     */

    public void reveiveBlessing(final Doomer doomer)
    {
        setAlive(false);
    }

    public abstract void reveiveBlessing(XPAngel xpAngel);

    public final char getType()
    {
        return type;
    }

    public final int getLevel()
    {
        return level;
    }

    public final int getCurrExp()
    {
        return currExp;
    }

    public final char getLand()
    {
        return land;
    }

    public final boolean isAlive()
    {
        return alive;
    }

    public final void setLand(final char land)
    {
        this.land = land;
    }

    public final int getMaxHP()
    {
        return maxHP;
    }

    public final int getCurrHP()
    {
        return currHP;
    }

    public final int getRootRounds()
    {
        return rootRounds;
    }

    public final void setAlive(final boolean alive)
    {
        if (!alive) {
            currHP = 0;
        }
        this.alive = alive;
    }

    /*
        angel buffs getter
     */

    public List<Float> getAngelBuff()
    {
        return angelBuff;
    }

    /*
        strategy buffs getter
     */

    public List<Float> getStratBuff()
    {
        return stratBuff;
    }
}
