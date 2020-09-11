package angels;

import champions.Champion;

public class LifeGiver extends Angel {

    public LifeGiver()
    {
        super("LifeGiver");
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
