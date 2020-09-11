package angels;

import champions.Champion;

public class Spawner extends Angel {

    public Spawner()
    {
        super("Spawner");
    }

    @Override
    public final boolean bless(final Champion champion)
    {
        if (!champion.isAlive()) {
            champion.reveiveBlessing(this);
            return true;
        }
        return false;
    }
}
