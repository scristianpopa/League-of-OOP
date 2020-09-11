package angels;

public final class AngelWithPosition {
    private Angel angel;
    private int x;
    private int y;

    public AngelWithPosition(final Angel angel, final int x, final int y)
    {
        this.angel = angel;
        this.x = x;
        this.y = y;
    }

    public Angel getAngel()
    {
        return angel;
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
