package spells;

public final class Effects {
    private int damage;
    private float unracistDamage;
    private int dotDamage;
    private int dotTimer;
    private int rootTimer;

    public Effects()
    {
    }

    public Effects(final int damage, final float unracistDamage,
        final int dotDamage, final int dotTimer, final int rootTimer)
    {
        this.damage = damage;
        this.unracistDamage = unracistDamage;
        this.dotDamage = dotDamage;
        this.dotTimer = dotTimer;
        this.rootTimer = rootTimer;
    }

    public int getDamage()
    {
        return damage;
    }

    public float getUnracistDamage()
    {
        return unracistDamage;
    }

    public int getDotDamage()
    {
        return dotDamage;
    }

    public int getDotTimer()
    {
        return dotTimer;
    }

    public int getRootTimer()
    {
        return rootTimer;
    }
}
