package angels;

import champions.Champion;

public class Doomer extends Angel {

    public Doomer()
    {
        super("TheDoomer");
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
