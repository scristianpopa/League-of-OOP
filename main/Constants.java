package main;

public final class Constants {
    public static final int LEVEL0_EXP = 250;
    public static final int LEVEL_UP_EXP = 50;

    // PYROMANCER ABILITIES
    public static final int FIREBLAST_BASE = 350;
    public static final int FIREBLAST_GROWTH = 50;

    public static final int IGNITE_BASE = 150;
    public static final int IGNITE_GROWTH = 20;
    public static final int IGNITE_DOT_BASE = 50;
    public static final int IGNITE_DOT_GROWTH = 30;
    public static final int IGNITE_TIMER = 2;

    public static final char VOLCANIC = 'V';
    public static final float P_TERRAIN_BONUS = 1.25f;

    public static final float P_K_BONUS = 1.2f;
    public static final float P_R_BONUS = 0.8f;
    public static final float P_W_BONUS = 1.05f;
    public static final float P_P_BONUS = 0.9f;

    // KNIGHT ABILITIES
    public static final int EXECUTE_BASE = 200;
    public static final int EXECUTE_GROWTH = 30;
    public static final float EXECUTE_LIMIT_BASE = 0.2f;
    public static final float EXECUTE_LIMIT_GROWTH = 0.01f;
    public static final float EXECUTE_LIMIT_MAX = 0.4f;

    public static final int SLAM_BASE = 100;
    public static final int SLAM_GROWTH = 40;

    public static final char LAND = 'L';
    public static final float L_TERRAIN_BONUS = 1.15f;

    public static final float EXECUTE_K_BONUS = 1f;
    public static final float EXECUTE_R_BONUS = 1.15f;
    public static final float EXECUTE_W_BONUS = 0.8f;
    public static final float EXECUTE_P_BONUS = 1.1f;

    public static final float SLAM_K_BONUS = 1.2f;
    public static final float SLAM_R_BONUS = 0.8f;
    public static final float SLAM_W_BONUS = 1.05f;
    public static final float SLAM_P_BONUS = 0.9f;

    // WIZARD ABILITIES
    public static final float DRAIN_BASE = 0.2f;
    public static final float DRAIN_GROWTH = 0.05f;
    public static final float DRAIN_HP_LIMIT = 0.3f;

    public static final float DEFLECT_BASE = 0.35f;
    public static final float DEFLECT_GROWTH = 0.02f;
    public static final float DEFLECT_MAX = 0.7f;

    public static final char DESERT = 'D';
    public static final float D_TERRAIN_BONUS = 1.1f;

    public static final float DRAIN_K_BONUS = 1.2f;
    public static final float DRAIN_R_BONUS = 0.8f;
    public static final float DRAIN_W_BONUS = 1.05f;
    public static final float DRAIN_P_BONUS = 0.9f;

    public static final float DEFLECT_K_BONUS = 1.4f;
    public static final float DEFLECT_R_BONUS = 1.2f;
    public static final float DEFLECT_W_BONUS = 0f;
    public static final float DEFLECT_P_BONUS = 1.3f;

    // ROGUE ABILITIES

    public static final int BACKSTAB_BASE = 200;
    public static final int BACKSTAB_GROWTH = 20;
    public static final float BACKSTAB_CRIT = 1.5f;
    public static final int BACKSTAB_RESET = 3;

    public static final int PARALYSIS_BASE = 40;
    public static final int PARALYSIS_GROWTH = 10;
    public static final int PARALYSIS_SMALL = 3;
    public static final int PARALYSIS_BIG = 6;

    public static final char WOODS = 'W';
    public static final float W_TERRAIN_BONUS = 1.15f;

    public static final float BACKSTAB_K_BONUS = 0.9f;
    public static final float BACKSTAB_R_BONUS = 1.2f;
    public static final float BACKSTAB_W_BONUS = 1.25f;
    public static final float BACKSTAB_P_BONUS = 1.25f;

    public static final float PARALYSIS_K_BONUS = 0.8f;
    public static final float PARALYSIS_R_BONUS = 0.9f;
    public static final float PARALYSIS_W_BONUS = 1.25f;
    public static final float PARALYSIS_P_BONUS = 1.2f;

    // Champion types
    public static final char KNIGHT = 'K';
    public static final char ROGUE = 'R';
    public static final char WIZARD = 'W';
    public static final char PYROMANCER = 'P';

    // Exp
    public static final int EXP = 200;
    public static final int EXP_MULT = 40;

    // DamageAngel
    public static final float DAMAGEANGEL_KNIGHT = 0.15f;
    public static final float DAMAGEANGEL_ROGUE = 0.3f;
    public static final float DAMAGEANGEL_WIZARD = 0.4f;
    public static final float DAMAGEANGEL_PYROMANCER = 0.2f;

    // DarkAngel
    public static final int DARKANGEL_KNIGHT = -40;
    public static final int DARKANGEL_ROGUE = -10;
    public static final int DARKANGEL_WIZARD = -20;
    public static final int DARKANGEL_PYROMANCER = -30;

    // Dracula
    public static final int DRACULA_HP_KNIGHT = -60;
    public static final int DRACULA_HP_ROGUE = -35;
    public static final int DRACULA_HP_WIZARD = -20;
    public static final int DRACULA_HP_PYROMANCER = -40;

    public static final float DRACULA_DMG_KNIGHT = -0.2f;
    public static final float DRACULA_DMG_ROGUE = -0.1f;
    public static final float DRACULA_DMG_WIZARD = -0.4f;
    public static final float DRACULA_DMG_PYROMANCER = -0.3f;

    // Goodboy
    public static final int GOODBOY_HP_KNIGHT = 20;
    public static final int GOODBOY_HP_ROGUE = 40;
    public static final int GOODBOY_HP_WIZARD = 50;
    public static final int GOODBOY_HP_PYROMANCER = 30;

    public static final float GOODBOY_DMG_KNIGHT = 0.4f;
    public static final float GOODBOY_DMG_ROGUE = 0.4f;
    public static final float GOODBOY_DMG_WIZARD = 0.3f;
    public static final float GOODBOY_DMG_PYROMANCER = 0.5f;

    // LevelUpAngel
    public static final float LEVELUPANGEL_KNIGHT = 0.1f;
    public static final float LEVELUPANGEL_ROGUE = 0.15f;
    public static final float LEVELUPANGEL_WIZARD = 0.25f;
    public static final float LEVELUPANGEL_PYROMANCER = 0.2f;

    // LifeGiver
    public static final int LIFEGIVER_KNIGHT = 100;
    public static final int LIFEGIVER_ROGUE = 90;
    public static final int LIFEGIVER_WIZARD = 120;
    public static final int LIFEGIVER_PYROMANCER = 80;

    // SmallAngel
    public static final int SMALLANGEL_HP_KNIGHT = 10;
    public static final int SMALLANGEL_HP_ROGUE = 20;
    public static final int SMALLANGEL_HP_WIZARD = 25;
    public static final int SMALLANGEL_HP_PYROMANCER = 15;

    public static final float SMALLANGEL_DMG_KNIGHT = 0.1f;
    public static final float SMALLANGEL_DMG_ROGUE = 0.05f;
    public static final float SMALLANGEL_DMG_WIZARD = 0.1f;
    public static final float SMALLANGEL_DMG_PYROMANCER = 0.15f;

    // Spawner
    public static final int SPAWNER_KNIGHT = 200;
    public static final int SPAWNER_ROGUE = 180;
    public static final int SPAWNER_WIZARD = 120;
    public static final int SPAWNER_PYROMANCER = 150;

    // XPAngel
    public static final int XPANGEL_KNIGHT = 45;
    public static final int XPANGEL_ROGUE = 40;
    public static final int XPANGEL_WIZARD = 60;
    public static final int XPANGEL_PYROMANCER = 50;

    // Strategies

    public static final float L_K_COEF = -0.2f;
    public static final int L_K_HP = 4;

    public static final int LOW_K = 3;
    public static final int MED_K = 2;

    public static final float M_K_COEF = 0.5f;
    public static final int M_K_HP = -5;

    public static final float L_P_COEF = -0.3f;
    public static final int L_P_HP = 3;

    public static final int LOW_P = 4;
    public static final int MED_P = 3;

    public static final float M_P_COEF = 0.7f;
    public static final int M_P_HP = -4;

    public static final float L_R_COEF = -0.1f;
    public static final int L_R_HP = 2;

    public static final int LOW_R = 7;
    public static final int MED_R = 5;

    public static final float M_R_COEF = 0.4f;
    public static final int M_R_HP = -7;

    public static final float L_W_COEF = -0.2f;
    public static final int L_W_HP = 5;

    public static final int LOW_W = 4;
    public static final int MED_W = 2;

    public static final float M_W_COEF = 0.6f;
    public static final int M_W_HP = -10;

    private Constants() {}
}
