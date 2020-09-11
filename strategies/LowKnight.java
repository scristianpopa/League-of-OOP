package strategies;

import champions.Champion;
import main.Constants;

public class LowKnight implements Strategy {
    public final void modify(final Champion champion)
    {
        champion.gainStratBuff(Constants.L_K_COEF, Constants.L_K_HP);
    }
}
