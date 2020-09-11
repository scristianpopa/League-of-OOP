package observer;

import angels.Angel;
import angels.BadAngel;
import angels.AngelWithPosition;
import champions.Champion;
import gamemap.GameMap;

import java.io.BufferedWriter;
import java.io.IOException;

public final class Observer {
    private static Observer instance = null;
    private GameMap gameMap;
    private BufferedWriter writer;

    private Observer(final BufferedWriter writerino)
    {
        writer = writerino;
    }

    public static Observer getInstance(final BufferedWriter writerino)
    {
        if (instance == null) {
            instance = new Observer(writerino);
        }
        return instance;
    }

    private String championName(final char name)
    {
        switch (name) {
        case ChampionType.KNIGHT:
            return "Knight ";
        case ChampionType.ROGUE:
            return "Rogue ";
        case ChampionType.WIZARD:
            return "Wizard ";
        case ChampionType.PYROMANCER:
            return "Pyromancer ";
        default:
            break;
        }
        return "no such champion";
    }

    private static class ChampionType {
        public static final char KNIGHT = 'K';
        public static final char ROGUE = 'R';
        public static final char WIZARD = 'W';
        public static final char PYROMANCER = 'P';
    }

    /*
        prints the round number
     */

    public void update(final int roundNr) throws IOException
    {
        writer.write("~~ Round " + roundNr + " ~~\n");
    }

    /*
        prints the message when an angel buffs a champion
     */

    public void update(final Angel angel, final Champion champ,
        final int id) throws IOException
    {
        writer.write(angel.getType());
        boolean bad = BadAngel.contains(angel.getType());
        if (bad) {
            writer.write(" hit ");
        } else {
            writer.write(" helped ");
        }
        writer.write(championName(champ.getType()) + id + "\n");
        if (angel.getType() == "Spawner") {
            writer.write("Player " + championName(champ.getType()) + id
                + " was brought to life by an angel\n");
            return;
        }
        if (bad && !champ.isAlive()) {
            writer.write("Player " + championName(champ.getType()) + id
                + " was killed by an angel\n");
        }
    }

    /*
        prints the spawn message for angels
     */

    public void update(final AngelWithPosition angel) throws IOException
    {
        writer.write("Angel " + angel.getAngel().getType()
            + " was spawned at " + angel.getX() + " " + angel.getY() + "\n");
    }

    /*
        prints the level up messages for champions
     */

    public void update(final Champion champ, final int id,
        final int oldLevel) throws IOException
    {
        String name = championName(champ.getType());
        for (int i = oldLevel + 1; i <= champ.getLevel(); ++i) {
            writer.write(name + id + " reached level " + i + "\n");
        }
    }

    /*
        prints the kill message when a champion is killed by another champion
     */

    public void update(final Champion win, final int winID,
        final Champion lose, final int loseID) throws IOException
    {
        writer.write("Player " + championName(lose.getType()) + loseID
            + " was killed by " + championName(win.getType()) + winID + "\n");
    }

    public void update() throws IOException
    {
        writer.write('\n');
    }
}
