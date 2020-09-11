package main;

import gamemap.GameMap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public final class Main {

    private Main() {}

    public static void main(final String[] args) throws FileNotFoundException, IOException
    {
        File in = new File(args[0]);
        Scanner read = new Scanner(in);
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        GameMap gameMap = GameMap.getInstance(read, writer);
        int roundNR = read.nextInt();
        read.nextLine();
        gameMap.readMoves(read, roundNR);
        gameMap.readAngels(read, roundNR);
        for (int i = 0; i < roundNR; ++i) {
            gameMap.round(i);
        }
        gameMap.print(writer);

        writer.close();
    }
}
