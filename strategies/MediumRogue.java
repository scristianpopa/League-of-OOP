package strategies;

import champions.Champion;
import main.Constants;

public class MediumRogue implements Strategy {
    public final void modify(final Champion champion)
    {
        champion.gainStratBuff(Constants.M_R_COEF, Constants.M_R_HP);
    }
}
