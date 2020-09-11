package angels;

import champions.Champion;

public class DarkAngel extends Angel {

    public DarkAngel()
    {
        super("DarkAngel");
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
