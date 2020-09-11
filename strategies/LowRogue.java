package strategies;

import champions.Champion;
import main.Constants;

public class LowRogue implements Strategy {
    public final void modify(final Champion champion)
    {
        champion.gainStratBuff(Constants.L_R_COEF, Constants.L_R_HP);
    }
}
