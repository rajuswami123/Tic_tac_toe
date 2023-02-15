package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Tictactoe {
    public int checkHorizontal(char[] a) {
        int flag = 0;
        for (int i = 1; i <= 2; i += 1) {
            if (a[i] != a[i - 1]) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public int checkVertical(int columnIndex, char[][] a) {
        int flag = 0;
        for (int i = 1; i <= 2; i += 1) {
            if (a[i][columnIndex] != a[i - 1][columnIndex]) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public int checkLeftDiagonal(int rowIndex, int columnIndex, char[][] a) {
        int flag = 0;
        for (int i = 1; i <= 2; i += 1, rowIndex -= 1, columnIndex += 1) {
            if (a[rowIndex][columnIndex] != a[rowIndex - 1][columnIndex + 1]) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public int checkRightDiagonal(char[][] a) {
        int flag = 0;
        for (int i = 1; i <= 2; i += 1) {
            if (a[i][i] != a[i - 1][i - 1]) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public int checkWin(int rowIndex, int columnIndex, char[][] a) {
        int hor;
        int ver;
        int rDig = -1;
        int lDig = -1;
        hor = checkHorizontal(a[rowIndex]);
        ver = checkVertical(columnIndex, a);
        if (rowIndex == 1 && columnIndex == 1) {
            rDig = checkRightDiagonal(a);
            lDig = checkLeftDiagonal(2, 0, a);
        } else if (rowIndex == columnIndex) {
            rDig = checkRightDiagonal(a);
        } else {
            lDig = checkLeftDiagonal(2, 0, a);
        }
        if (hor == 0 || ver == 0 || rDig == 0 || lDig == 0) {
            return 0;
        }
        return 1;
    }
}

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