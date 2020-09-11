package angels;

import champions.Champion;

public class SmallAngel extends Angel {

    public SmallAngel()
    {
        super("SmallAngel");
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
