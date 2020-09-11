package strategies;

import champions.Champion;
import main.Constants;

public class LowWizard implements Strategy {
    public final void modify(final Champion champion)
    {
        champion.gainStratBuff(Constants.L_W_COEF, Constants.L_W_HP);
    }
}
