package champions;

public final class ChampionFactory {
    private static ChampionFactory instance = null;

    private static class ChampionType {
        public static final char KNIGHT = 'K';
        public static final char ROGUE = 'R';
        public static final char WIZARD = 'W';
        public static final char PYROMANCER = 'P';
    }

    private static class ChampionHP {
        public static final int KNIGHT = 900;
        public static final int ROGUE = 600;
        public static final int WIZARD = 400;
        public static final int PYROMANCER = 500;
    }

    private static class ChampionHPGrowth {
        public static final int KNIGHT = 80;
        public static final int ROGUE = 40;
        public static final int WIZARD = 30;
        public static final int PYROMANCER = 50;
    }

    private ChampionFactory()
    {
    }

    public static ChampionFactory getInstance()
    {
        if (instance == null) {
            instance = new ChampionFactory();
        }
        return instance;
    }

    public static Champion getChampion(final char type) throws IllegalStateException
    {
        switch (type) {
        case ChampionType.KNIGHT:
            return new Knight(ChampionHP.KNIGHT, ChampionHPGrowth.KNIGHT);
        case ChampionType.ROGUE:
            return new Rogue(ChampionHP.ROGUE, ChampionHPGrowth.ROGUE);
        case ChampionType.WIZARD:
            return new Wizard(ChampionHP.WIZARD, ChampionHPGrowth.WIZARD);
        case ChampionType.PYROMANCER:
            return new Pyromancer(ChampionHP.PYROMANCER, ChampionHPGrowth.PYROMANCER);
        default:
            throw new IllegalStateException("Wrong champion type");
        }
    }
}
