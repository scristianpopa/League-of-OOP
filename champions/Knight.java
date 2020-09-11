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
import strategies.LowKnight;
import strategies.MediumKnight;
import main.Constants;
import spells.Effects;
import spells.Execute;
import spells.Slam;

public final class Knight extends Champion {
    public Knight(final int hp, final int hpGrowth)
    {
        super('K', hp, hpGrowth);
    }

    @Override
    public Effects getEffects(final Knight enemy)
    {
        Execute execute = new Execute(this, enemy);
        Slam slam = new Slam(this, enemy);
        return new Effects(execute.getDamage() + slam.getDamage(),
            execute.getUnracistDamage() + slam.getUnracistDamage(),
            0, 0, slam.getRootTimer());
    }

    @Override
    public Effects getEffects(final Rogue enemy)
    {
        Execute execute = new Execute(this, enemy);
        Slam slam = new Slam(this, enemy);
        return new Effects(execute.getDamage() + slam.getDamage(),
            execute.getUnracistDamage() + slam.getUnracistDamage(),
            0, 0, slam.getRootTimer());
    }

    @Override
    public Effects getEffects(final Wizard enemy)
    {
        Execute execute = new Execute(this, enemy);
        Slam slam = new Slam(this, enemy);
        return new Effects(execute.getDamage() + slam.getDamage(),
            execute.getUnracistDamage() + slam.getUnracistDamage(),
            0, 0, slam.getRootTimer());
    }

    @Override
    public Effects getEffects(final Pyromancer enemy)
    {
        Execute execute = new Execute(this, enemy);
        Slam slam = new Slam(this, enemy);
        return new Effects(execute.getDamage() + slam.getDamage(),
            execute.getUnracistDamage() + slam.getUnracistDamage(),
            0, 0, slam.getRootTimer());
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
        gainBuff(Constants.DAMAGEANGEL_KNIGHT);
    }

    @Override
    public void reveiveBlessing(final DarkAngel darkAngel)
    {
        gainHP(Constants.DARKANGEL_KNIGHT);
    }

    @Override
    public void reveiveBlessing(final Dracula dracula)
    {
        gainHP(Constants.DRACULA_HP_KNIGHT);
        gainBuff(Constants.DRACULA_DMG_KNIGHT);
    }

    @Override
    public void reveiveBlessing(final Goodboy goodboy)
    {
        gainHP(Constants.GOODBOY_HP_KNIGHT);
        gainBuff(Constants.GOODBOY_DMG_KNIGHT);
    }

    @Override
    public void reveiveBlessing(final LevelUpAngel levelUpAngel)
    {
        gainBuff(Constants.LEVELUPANGEL_KNIGHT);
        autoLevelUp();
    }

    @Override
    public void reveiveBlessing(final LifeGiver lifeGiver)
    {
        gainHP(Constants.LIFEGIVER_KNIGHT);
    }

    @Override
    public void reveiveBlessing(final SmallAngel smallAngel)
    {
        gainHP(Constants.SMALLANGEL_HP_KNIGHT);
        gainBuff(Constants.SMALLANGEL_DMG_KNIGHT);
    }

    @Override
    public void reveiveBlessing(final Spawner spawner)
    {
        setAlive(true);
        gainHP(Constants.SPAWNER_KNIGHT);
    }

    @Override
    public void reveiveBlessing(final XPAngel xpAngel)
    {
        gainExp(Constants.XPANGEL_KNIGHT);
    }

    @Override
    public void applyStrategy()
    {
        if (getCurrHP() < getMaxHP() / Constants.LOW_K) {
            strategy = new LowKnight();
            strategy.modify(this);
            return;
        }
        if (getCurrHP() < getMaxHP() / Constants.MED_K) {
            strategy = new MediumKnight();
            strategy.modify(this);
        }
    }
}
