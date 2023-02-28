package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger("com.api.jar");
        char[][] a = new char[3][3];
        Tictactoe t = new Tictactoe();
        char p1 = 'x';
        char p2 = 'O';
        char p;
        int rowIndex = -1;
        int columnIndex = -1;
        int count = 0;
        while (count < 9) {
            p = p2;
            if (count % 2 == 0)
                p = p1;
            char finalP = p;
            String s;
            logger.info("  0 1 2\n");
            for (int i = 0; i < 3; i++) {
                s = i + " ";
                logger.info(s);
                for (int j = 0; j < 3; j++) {
                    s = a[i][j] + " ";
                    logger.info(s);
                }
                logger.info("\n");
            }
            boolean player = true;
            while(player){

                logger.log(Level.INFO, () -> "Player " + finalP + " turn : ");
                logger.info("Enter row Index : ");
                rowIndex = sc.nextInt();
                logger.info("Enter column Index : ");
                columnIndex = sc.nextInt();
                if (a[rowIndex][columnIndex] == 0)
                    player = false;
            }
            a[rowIndex][columnIndex] = p;
            if (t.checkWin(rowIndex, columnIndex, a) == 0) {
                logger.log(Level.INFO,()-> "Player "+finalP+" Win");
                break;
            }
            logger.info("continue---------");
            count += 1;
        }
    }
}