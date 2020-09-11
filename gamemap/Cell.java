package gamemap;

import java.util.Vector;

public final class Cell {
    private char type;
    private Vector<Integer> championID;

    public Cell()
    {
        this.championID = new Vector<Integer>();
    }

    public char getType()
    {
        return type;
    }

    public void setType(final char type)
    {
        this.type = type;
    }

    public Vector<Integer> getChampionID()
    {
        return championID;
    }

    public void addChampionID(final int id)
    {
        this.championID.add(id);
    }

    public void resetChampionID()
    {
        this.championID.clear();
    }
}
