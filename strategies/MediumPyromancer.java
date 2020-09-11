package strategies;

import champions.Champion;
import main.Constants;

public class MediumPyromancer implements Strategy {
    public final void modify(final Champion champion)
    {
        champion.gainStratBuff(Constants.M_P_COEF, Constants.M_P_HP);
    }
}
