package angels;

import champions.Champion;

public class LevelUpAngel extends Angel {

    public LevelUpAngel()
    {
        super("LevelUpAngel");
    }

    @Override
    public final boolean bless(final Champion champion)
    {
        if (champion.isAlive()) {
            champion.reveiveBlessing(this);
            return true;
        }
        return false;
    }
}
