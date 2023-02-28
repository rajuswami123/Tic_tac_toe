package org.example;

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
