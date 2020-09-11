package angels;

import champions.Champion;

public class XPAngel extends Angel {

    public XPAngel()
    {
        super("XPAngel");
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
