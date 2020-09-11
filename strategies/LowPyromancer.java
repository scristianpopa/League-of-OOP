package strategies;

import champions.Champion;
import main.Constants;

public class LowPyromancer implements Strategy {
    public final void modify(final Champion champion)
    {
        champion.gainStratBuff(Constants.L_P_COEF, Constants.L_P_HP);
    }
}
