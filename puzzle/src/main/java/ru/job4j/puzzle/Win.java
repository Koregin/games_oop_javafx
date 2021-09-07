package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        int row = 0;
        int col = 0;
        //Ищем единицу в массиве
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        //
        if(checkHorizont(board, row) || checkVert(board, col)){
            rsl = true;
        }
        return rsl;
    }
    private static boolean checkHorizont(int[][] board, int r) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[r][j] != 1) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private static boolean checkVert(int[][] board, int c) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

}
