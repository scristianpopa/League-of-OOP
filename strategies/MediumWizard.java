package strategies;

import champions.Champion;
import main.Constants;

public class MediumWizard implements Strategy {
    public final void modify(final Champion champion)
    {
        champion.gainStratBuff(Constants.M_W_COEF, Constants.M_W_HP);
    }
}
