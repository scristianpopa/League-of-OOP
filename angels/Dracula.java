package angels;

import champions.Champion;

public class Dracula extends Angel {

    public Dracula()
    {
        super("Dracula");
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
