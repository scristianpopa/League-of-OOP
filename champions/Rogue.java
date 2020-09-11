package champions;

import angels.DamageAngel;
import angels.DarkAngel;
import angels.Dracula;
import angels.Goodboy;
import angels.SmallAngel;
import angels.Spawner;
import angels.XPAngel;
import angels.LevelUpAngel;
import angels.LifeGiver;
import strategies.LowRogue;
import strategies.MediumRogue;
import main.Constants;
import spells.Effects;
import spells.Backstab;
import spells.Paralysis;

public final class Rogue extends Champion {
    private int fights;

    public Rogue(final int hp, final int hpGrowth)
    {
        super('R', hp, hpGrowth);
        fights = -1;
    }

    public int getFights()
    {
        return fights;
    }

    @Override
    public void incFights()
    {
        ++fights;
    }

    @Override
    public Effects getEffects(final Knight enemy)
    {
        Backstab backstab = new Backstab(this, enemy);
        Paralysis paralysis = new Paralysis(this, enemy);
        return new Effects(backstab.getDamage() + paralysis.getDamage(),
            backstab.getUnracistDamage() + paralysis.getUnracistDamage(),
            paralysis.getDotDamage(), paralysis.getDotTimer(), paralysis.getRootTimer());
    }

    @Override
    public Effects getEffects(final Rogue enemy)
    {
        Backstab backstab = new Backstab(this, enemy);
        Paralysis paralysis = new Paralysis(this, enemy);
        return new Effects(backstab.getDamage() + paralysis.getDamage(),
            backstab.getUnracistDamage() + paralysis.getUnracistDamage(),
            paralysis.getDotDamage(), paralysis.getDotTimer(), paralysis.getRootTimer());
    }

    @Override
    public Effects getEffects(final Wizard enemy)
    {
        Backstab backstab = new Backstab(this, enemy);
        Paralysis paralysis = new Paralysis(this, enemy);
        return new Effects(backstab.getDamage() + paralysis.getDamage(),
            backstab.getUnracistDamage() + paralysis.getUnracistDamage(),
            paralysis.getDotDamage(), paralysis.getDotTimer(), paralysis.getRootTimer());
    }

    @Override
    public Effects getEffects(final Pyromancer enemy)
    {
        Backstab backstab = new Backstab(this, enemy);
        Paralysis paralysis = new Paralysis(this, enemy);
        return new Effects(backstab.getDamage() + paralysis.getDamage(),
            backstab.getUnracistDamage() + paralysis.getUnracistDamage(),
            paralysis.getDotDamage(), paralysis.getDotTimer(), paralysis.getRootTimer());
    }

    @Override
    public Effects fight(final Knight enemy)
    {
        return enemy.getEffects(this);
    }

    @Override
    public Effects fight(final Rogue enemy)
    {
        return enemy.getEffects(this);
    }

    @Override
    public Effects fight(final Wizard enemy)
    {
        return enemy.getEffects(this);
    }

    @Override
    public Effects fight(final Pyromancer enemy)
    {
        return enemy.getEffects(this);
    }

    @Override
    public void reveiveBlessing(final DamageAngel damageAngel)
    {
        gainBuff(Constants.DAMAGEANGEL_ROGUE);
    }

    @Override
    public void reveiveBlessing(final DarkAngel darkAngel)
    {
        gainHP(Constants.DARKANGEL_ROGUE);
    }

    @Override
    public void reveiveBlessing(final Dracula dracula)
    {
        gainHP(Constants.DRACULA_HP_ROGUE);
        gainBuff(Constants.DRACULA_DMG_ROGUE);
    }

    @Override
    public void reveiveBlessing(final Goodboy goodboy)
    {
        gainHP(Constants.GOODBOY_HP_ROGUE);
        gainBuff(Constants.GOODBOY_DMG_ROGUE);
    }

    @Override
    public void reveiveBlessing(final LevelUpAngel levelUpAngel)
    {
        gainBuff(Constants.LEVELUPANGEL_ROGUE);
        autoLevelUp();
    }

    @Override
    public void reveiveBlessing(final LifeGiver lifeGiver)
    {
        gainHP(Constants.LIFEGIVER_ROGUE);
    }

    @Override
    public void reveiveBlessing(final SmallAngel smallAngel)
    {
        gainHP(Constants.SMALLANGEL_HP_ROGUE);
        gainBuff(Constants.SMALLANGEL_DMG_ROGUE);
    }

    @Override
    public void reveiveBlessing(final Spawner spawner)
    {
        setAlive(true);
        gainHP(Constants.SPAWNER_ROGUE);
    }

    @Override
    public void reveiveBlessing(final XPAngel xpAngel)
    {
        gainExp(Constants.XPANGEL_ROGUE);
    }

    @Override
    public void applyStrategy()
    {
        if (getCurrHP() < getMaxHP() / Constants.LOW_R) {
            strategy = new LowRogue();
            strategy.modify(this);
            return;
        }
        if (getCurrHP() < getMaxHP() / Constants.MED_R) {
            strategy = new MediumRogue();
            strategy.modify(this);
        }
    }
}
