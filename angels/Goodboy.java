package angels;

import champions.Champion;

public class Goodboy extends Angel {

    public Goodboy()
    {
        super("GoodBoy");
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
