package angels;

import champions.Champion;

public class DamageAngel extends Angel {

    public DamageAngel()
    {
        super("DamageAngel");
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
