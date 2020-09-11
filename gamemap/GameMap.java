package gamemap;

import angels.AngelFactory;
import angels.AngelWithPosition;
import observer.Observer;
import champions.Champion;
import champions.ChampionFactory;
import champions.ChampionWithPosition;
import main.Constants;
import spells.Effects;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public final class GameMap {
    private static GameMap instance = null;
    private Cell[][] table;
    private Vector<ChampionWithPosition> players;
    private Vector<String> allMoves;
    private Vector<Vector<AngelWithPosition>> allAngels;
    private Observer greatMag;

    private GameMap(final Scanner read, final BufferedWriter writerino)
    {
        allMoves = new Vector<String>();
        allAngels = new Vector<Vector<AngelWithPosition>>();
        greatMag = Observer.getInstance(writerino);
        int n = read.nextInt();
        int m = read.nextInt();
        table = new Cell[n][m];
        read.nextLine();
        for (int i = 0; i < n; ++i) {
            String line = read.nextLine();
            for (int j = 0; j < m; ++j) {
                table[i][j] = new Cell();
                table[i][j].setType(line.charAt(j));
            }
        }
        ChampionFactory championFactory = ChampionFactory.getInstance();
        players = new Vector<ChampionWithPosition>();
        int p = read.nextInt();
        for (int i = 0; i < p; ++i) {
            char champ = read.next().charAt(0);
            int x = read.nextInt();
            int y = read.nextInt();
            players.add(new ChampionWithPosition(championFactory.getChampion(champ), x, y));
            players.get(i).getChamp().setLand(table[x][y].getType());
        }
    }

    public void readMoves(final Scanner read, final int roundNR)
    {
        for (int i = 0; i < roundNR; ++i) {
            String moves = read.nextLine();
            allMoves.add(moves);
        }
    }

    public void readAngels(final Scanner read, final int roundNR)
    {
        for (int i = 0; i < roundNR; ++i) {
            String line = read.nextLine();
            allAngels.add(getRoundAngels(line));
        }
    }

    public Vector<AngelWithPosition> getRoundAngels(final String line)
    {
        AngelFactory angelFactory = AngelFactory.getInstance();
        Vector<AngelWithPosition> roundAngels = new Vector<AngelWithPosition>();
        if (line.charAt(0) == '0') {
            return roundAngels;
        }
        int i = 0;
        while (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
            ++i;
        }
        int angelNR = Integer.parseInt(line.substring(0, i));
        for (int j = 0; j < angelNR; ++j) {
            ++i;
            int start = i;
            while (line.charAt(i) != ',') {
                ++i;
            }
            String angelName = line.substring(start, i);
            ++i;
            start = i;
            while (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                ++i;
            }
            int x = Integer.parseInt(line.substring(start, i));
            ++i;
            start = i;
            while (i < line.length() && line.charAt(i) >= '0'
                && line.charAt(i) <= '9') {
                ++i;
            }
            int y = Integer.parseInt(line.substring(start, i));
            roundAngels.add(new AngelWithPosition(angelFactory.getAngel(angelName), x, y));
        }
        return roundAngels;
    }

    public void round(final int round) throws IOException
    {
        greatMag.update(round + 1);
        String moves = allMoves.get(round);
        for (int i = 0; i < players.size(); ++i) {
            Champion me = players.get(i).getChamp();
            if (me.isAlive()) {
                me.flashbackDMG();
                players.get(i).move(moves.charAt(i), table);
                me.flashbackROOT();
                Cell workingCell = table[players.get(i).getX()][players.get(i).getY()];

                if (workingCell.getChampionID().isEmpty()) {
                    workingCell.addChampionID(i);
                } else {
                    workingCell.addChampionID(i);
                    for (int j = 0; j < workingCell.getChampionID().size() - 1;
                         ++j) {
                        Champion enemy = players.get(
                                                    workingCell.getChampionID().get(j))
                                             .getChamp();

                        if (me.isAlive() && enemy.isAlive()) {
                            me.incFights();
                            enemy.incFights();

                            Effects received = me.fight(enemy);
                            Effects dealt = enemy.fight(me);
                            me.refreshStats(received);
                            enemy.refreshStats(dealt);

                            int oldLevelEnemy = enemy.getLevel();
                            int oldLevelMe = me.getLevel();
                            if (!me.isAlive()) {
                                int gain = Math.max(0, Constants.EXP - Constants.EXP_MULT * (oldLevelEnemy - oldLevelMe));
                                enemy.gainExp(gain);
                                greatMag.update(enemy, workingCell.getChampionID().get(j),
                                    me, i);
                            }
                            if (!enemy.isAlive()) {
                                int gain = Math.max(0, Constants.EXP - Constants.EXP_MULT * (oldLevelMe - oldLevelEnemy));
                                me.gainExp(gain);
                                greatMag.update(me, i, enemy,
                                    workingCell.getChampionID().get(j));
                            }

                            greatMag.update(enemy, workingCell.getChampionID().get(j),
                                oldLevelEnemy);
                            greatMag.update(me, i, oldLevelMe);
                        }
                    }
                }
            } else {
                me.whileDead();
                table[players.get(i).getX()][players.get(i).getY()].addChampionID(i);
            }
        }
        Vector<AngelWithPosition> roundAngels = allAngels.get(round);
        for (AngelWithPosition lucifer : roundAngels) {
            greatMag.update(lucifer);
            int x = lucifer.getX();
            int y = lucifer.getY();
            Vector<Integer> champID = table[x][y].getChampionID();

            for (Integer id : champID) {
                int oldLevel = players.get(id).getChamp().getLevel();
                if (lucifer.getAngel().bless(players.get(id).getChamp())) {
                    greatMag.update(lucifer.getAngel(), players.get(id).getChamp(), id);
                    greatMag.update(players.get(id).getChamp(), id, oldLevel);
                }
            }
        }
        greatMag.update();
        for (int i = 0; i < players.size(); ++i) {
            table[players.get(i).getX()][players.get(i).getY()].resetChampionID();
        }
    }

    public void print(final BufferedWriter writer) throws IOException
    {
        writer.write("~~ Results ~~\n");
        for (ChampionWithPosition player : players) {
            player.status(writer);
        }
    }

    public static GameMap getInstance(final Scanner read, final BufferedWriter writer)
    {
        if (instance == null) {
            instance = new GameMap(read, writer);
        }
        return instance;
    }

    public Vector<ChampionWithPosition> getPlayers()
    {
        return players;
    }
}
