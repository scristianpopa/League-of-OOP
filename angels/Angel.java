package angels;

import champions.Champion;

public abstract class Angel {
    private String type;

    public Angel(final String name)
    {
        type = name;
    }

    /*
        return type of angel
     */
    public String getType()
    {
        return type;
    }

    public abstract boolean bless(Champion champion);
}
