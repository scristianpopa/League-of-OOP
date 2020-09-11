package angels;

public enum BadAngel {
    DarkAngel,
    Dracula,
    TheDoomer;

    public static boolean contains(final String s)
    {
        for (BadAngel name : values()) {
            if (name.name().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
