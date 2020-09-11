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
import strategies.LowPyromancer;
import strategies.MediumPyromancer;
import main.Constants;
import spells.Effects;
import spells.Fireblast;
import spells.Ignite;

public final class Pyromancer extends Champion {
    public Pyromancer(final int hp, final int hpGrowth)
    {
        super('P', hp, hpGrowth);
    }

    @Override
    public Effects getEffects(final Knight enemy)
    {
        Fireblast fireblast = new Fireblast(this, enemy);
        Ignite ignite = new Ignite(this, enemy);
        return new Effects(fireblast.getDamage() + ignite.getDamage(),
            fireblast.getUnracistDamage() + ignite.getUnracistDamage(),
            ignite.getDotDamage(), ignite.getDotTimer(), 0);
    }

    @Override
    public Effects getEffects(final Rogue enemy)
    {
        Fireblast fireblast = new Fireblast(this, enemy);
        Ignite ignite = new Ignite(this, enemy);
        return new Effects(fireblast.getDamage() + ignite.getDamage(),
            fireblast.getUnracistDamage() + ignite.getUnracistDamage(),
            ignite.getDotDamage(), ignite.getDotTimer(), 0);
    }

    @Override
    public Effects getEffects(final Wizard enemy)
    {
        Fireblast fireblast = new Fireblast(this, enemy);
        Ignite ignite = new Ignite(this, enemy);
        return new Effects(fireblast.getDamage() + ignite.getDamage(),
            fireblast.getUnracistDamage() + ignite.getUnracistDamage(),
            ignite.getDotDamage(), ignite.getDotTimer(), 0);
    }

    @Override
    public Effects getEffects(final Pyromancer enemy)
    {
        Fireblast fireblast = new Fireblast(this, enemy);
        Ignite ignite = new Ignite(this, enemy);
        return new Effects(fireblast.getDamage() + ignite.getDamage(),
            fireblast.getUnracistDamage() + ignite.getUnracistDamage(),
            ignite.getDotDamage(), ignite.getDotTimer(), 0);
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
        gainBuff(Constants.DAMAGEANGEL_PYROMANCER);
    }

    @Override
    public void reveiveBlessing(final DarkAngel darkAngel)
    {
        gainHP(Constants.DARKANGEL_PYROMANCER);
    }

    @Override
    public void reveiveBlessing(final Dracula dracula)
    {
        gainHP(Constants.DRACULA_HP_PYROMANCER);
        gainBuff(Constants.DRACULA_DMG_PYROMANCER);
    }

    @Override
    public void reveiveBlessing(final Goodboy goodboy)
    {
        gainHP(Constants.GOODBOY_HP_PYROMANCER);
        gainBuff(Constants.GOODBOY_DMG_PYROMANCER);
    }

    @Override
    public void reveiveBlessing(final LevelUpAngel levelUpAngel)
    {
        gainBuff(Constants.LEVELUPANGEL_PYROMANCER);
        autoLevelUp();
    }

    @Override
    public void reveiveBlessing(final LifeGiver lifeGiver)
    {
        gainHP(Constants.LIFEGIVER_PYROMANCER);
    }

    @Override
    public void reveiveBlessing(final SmallAngel smallAngel)
    {
        gainHP(Constants.SMALLANGEL_HP_PYROMANCER);
        gainBuff(Constants.SMALLANGEL_DMG_PYROMANCER);
    }

    @Override
    public void reveiveBlessing(final Spawner spawner)
    {
        setAlive(true);
        gainHP(Constants.SPAWNER_PYROMANCER);
    }

    @Override
    public void reveiveBlessing(final XPAngel xpAngel)
    {
        gainExp(Constants.XPANGEL_PYROMANCER);
    }

    @Override
    public void applyStrategy()
    {
        if (getCurrHP() < getMaxHP() / Constants.LOW_P) {
            strategy = new LowPyromancer();
            strategy.modify(this);
            return;
        }
        if (getCurrHP() < getMaxHP() / Constants.MED_P) {
            strategy = new MediumPyromancer();
            strategy.modify(this);
        }
    }
}
