package champions;

import gamemap.Cell;

import java.io.BufferedWriter;
import java.io.IOException;

public final class ChampionWithPosition {
    private Champion champ;
    private int x;
    private int y;

    public ChampionWithPosition(final Champion champ, final int x, final int y)
    {
        this.champ = champ;
        this.x = x;
        this.y = y;
    }

    public void move(final char direction, final Cell[][] table)
    {
        if (champ.getRootRounds() == 0) {
            champ.applyStrategy();
            switch (direction) {
            case 'U':
                --x;
                champ.setLand(table[x][y].getType());
                break;
            case 'D':
                ++x;
                champ.setLand(table[x][y].getType());
                break;
            case 'L':
                --y;
                champ.setLand(table[x][y].getType());
                break;
            case 'R':
                ++y;
                champ.setLand(table[x][y].getType());
                break;
            default:
                break;
            }
        }
    }

    public void status(final BufferedWriter writer) throws IOException
    {
        writer.write(champ.getType());
        if (!champ.isAlive()) {
            writer.write(" dead\n");
            return;
        }
        writer.write(" " + champ.getLevel() + " " + champ.getCurrExp() + " "
            + champ.getCurrHP() + " " + x + " " + y + "\n");
    }

    public Champion getChamp()
    {
        return champ;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
