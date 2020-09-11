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
import strategies.LowWizard;
import strategies.MediumWizard;
import main.Constants;
import spells.Effects;
import spells.Deflect;
import spells.Drain;

public final class Wizard extends Champion {
    public Wizard(final int hp, final int hpGrowth)
    {
        super('W', hp, hpGrowth);
    }

    @Override
    public Effects getEffects(final Knight enemy)
    {
        Drain drain = new Drain(this, enemy);
        Deflect deflect = new Deflect(this, enemy);
        return new Effects(drain.getDamage() + deflect.getDamage(),
            drain.getUnracistDamage() + deflect.getUnracistDamage(),
            0, 0, 0);
    }

    @Override
    public Effects getEffects(final Rogue enemy)
    {
        Drain drain = new Drain(this, enemy);
        Deflect deflect = new Deflect(this, enemy);
        return new Effects(drain.getDamage() + deflect.getDamage(),
            drain.getUnracistDamage() + deflect.getUnracistDamage(),
            0, 0, 0);
    }

    @Override
    public Effects getEffects(final Wizard enemy)
    {
        Drain drain = new Drain(this, enemy);
        Deflect deflect = new Deflect(this, enemy);
        return new Effects(drain.getDamage() + deflect.getDamage(),
            drain.getUnracistDamage() + deflect.getUnracistDamage(),
            0, 0, 0);
    }

    @Override
    public Effects getEffects(final Pyromancer enemy)
    {
        Drain drain = new Drain(this, enemy);
        Deflect deflect = new Deflect(this, enemy);
        return new Effects(drain.getDamage() + deflect.getDamage(),
            drain.getUnracistDamage() + deflect.getUnracistDamage(),
            0, 0, 0);
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
        gainBuff(Constants.DAMAGEANGEL_WIZARD);
    }

    @Override
    public void reveiveBlessing(final DarkAngel darkAngel)
    {
        gainHP(Constants.DARKANGEL_WIZARD);
    }

    @Override
    public void reveiveBlessing(final Dracula dracula)
    {
        gainHP(Constants.DRACULA_HP_WIZARD);
        gainBuff(Constants.DRACULA_DMG_WIZARD);
    }

    @Override
    public void reveiveBlessing(final Goodboy goodboy)
    {
        gainHP(Constants.GOODBOY_HP_WIZARD);
        gainBuff(Constants.GOODBOY_DMG_WIZARD);
    }

    @Override
    public void reveiveBlessing(final LevelUpAngel levelUpAngel)
    {
        gainBuff(Constants.LEVELUPANGEL_WIZARD);
        autoLevelUp();
    }

    @Override
    public void reveiveBlessing(final LifeGiver lifeGiver)
    {
        gainHP(Constants.LIFEGIVER_WIZARD);
    }

    @Override
    public void reveiveBlessing(final SmallAngel smallAngel)
    {
        gainHP(Constants.SMALLANGEL_HP_WIZARD);
        gainBuff(Constants.SMALLANGEL_DMG_WIZARD);
    }

    @Override
    public void reveiveBlessing(final Spawner spawner)
    {
        setAlive(true);
        gainHP(Constants.SPAWNER_WIZARD);
    }

    @Override
    public void reveiveBlessing(final XPAngel xpAngel)
    {
        gainExp(Constants.XPANGEL_WIZARD);
    }

    @Override
    public void applyStrategy()
    {
        if (getCurrHP() < getMaxHP() / Constants.LOW_W) {
            strategy = new LowWizard();
            strategy.modify(this);
            return;
        }
        if (getCurrHP() < getMaxHP() / Constants.MED_W) {
            strategy = new MediumWizard();
            strategy.modify(this);
        }
    }
}
