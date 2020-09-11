package angels;

public enum GoodAngel {
    DamageAngel,
    GoodBoy,
    LevelUpAngel,
    LifeGiver,
    SmallAngel,
    Spawner,
    XPAngel;

    public static boolean contains(final String s)
    {
        for (GoodAngel name : values()) {
            if (name.name().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
