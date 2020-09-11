package angels;

public final class AngelFactory {
    private static AngelFactory instance = null;

    private static class AngelType {
        public static final String DAMAGE = "DamageAngel";
        public static final String DARK = "DarkAngel";
        public static final String DOOMER = "TheDoomer";
        public static final String DRACULA = "Dracula";
        public static final String GOOD = "GoodBoy";
        public static final String LEVEL = "LevelUpAngel";
        public static final String LIFE = "LifeGiver";
        public static final String SMALL = "SmallAngel";
        public static final String SPAWNER = "Spawner";
        public static final String XP = "XPAngel";
    }

    private AngelFactory()
    {
    }

    public static AngelFactory getInstance()
    {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public static Angel getAngel(final String type) throws IllegalStateException
    {
        switch (type) {
        case AngelType.DAMAGE:
            return new DamageAngel();
        case AngelType.DARK:
            return new DarkAngel();
        case AngelType.DOOMER:
            return new Doomer();
        case AngelType.DRACULA:
            return new Dracula();
        case AngelType.GOOD:
            return new Goodboy();
        case AngelType.LEVEL:
            return new LevelUpAngel();
        case AngelType.LIFE:
            return new LifeGiver();
        case AngelType.SMALL:
            return new SmallAngel();
        case AngelType.SPAWNER:
            return new Spawner();
        case AngelType.XP:
            return new XPAngel();
        default:
            throw new IllegalStateException("Wrong angel type");
        }
    }
}
