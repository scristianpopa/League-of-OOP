package strategies;

import champions.Champion;
import main.Constants;

public class MediumKnight implements Strategy {
    public final void modify(final Champion champion)
    {
        champion.gainStratBuff(Constants.M_K_COEF, Constants.M_K_HP);
    }
}
