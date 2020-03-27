class Solution {

    public void solveSudoku(char[][] board) {
        if (board == null)
            return;
        for (int i=0; i<81; ++i) {
            if (board[i/9][i-9*(i/9)] == '.') {
                find(board, i);
                return;
            }
        }
    }

    public boolean find(char[][] board, int n) {
        int i = n/9;
        int j = n - 9*i;	   

        for (int k=1; k<=9; ++k) {
            board[i][j] = (char)(k+'0');

            if (isValidSudoku(board)) {
                return true;
            }

            if ( !checkRow(board, i) || !checkColumn(board, j) || !checkBlock(board, i/3, j/3) ) {
                continue;
            }

            for (int t=n+1; t<81; ++t) {
                if (board[t/9][t-9*(t/9)] == '.') {
                    if (find(board, t)) return true;
                    else board[t/9][t-9*(t/9)] = '.';
                    break;
                }
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {

        // check row
        for (int i=0; i<board.length; ++i) {
            boolean[] f = new boolean[10];
            for (int j=0; j<board[i].length; ++j) {
                if (board[i][j] == '.') return false;
                if (f[board[i][j] - '0']) return false;
                f[board[i][j] - '0'] = true;
            }
        }

        // check column
        for (int j=0; j<board.length; ++j) {
            boolean[] ff = new boolean[10];
            for (int k=0; k<board.length; ++k) {
                if (board[k][j] == '.') return false;
                if (ff[board[k][j] - '0']) return false;
                ff[board[k][j] - '0'] = true;
            }
        }

        // check block
        for (int i=0; i<board.length; i=i+3) {
            for (int j=0; j<board[i].length; j=j+3) {
                int rowOffset = i/3;
                int colOffset = j/3;
                if (!checkBlock1(board, rowOffset, colOffset)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkColumn(char[][] board, int column) {
        boolean[] ff = new boolean[10];

        for (int i=0; i<board.length; ++i) {
            if (board[i][column] == '.')  continue;
            if (ff[board[i][column] - '0']) return false;
            ff[board[i][column] - '0'] = true;
        }
        return true;
    }

    public boolean checkRow(char[][]board, int row) {
        boolean[] ff = new boolean[10];

        for (int j=0; j<board.length; ++j) {
            if (board[row][j] == '.')  continue;
            if (ff[board[row][j] - '0']) return false;
            ff[board[row][j] - '0'] = true;
        }
        return true;
    }

    public boolean checkBlock(char[][]board, int rowOffset, int colOffset) {
        int startIdx = rowOffset * 3;
        int startJdx = colOffset * 3;
        List<Character> list = new ArrayList<>();
        for (int i=startIdx; i < startIdx+3; ++i) {
            for (int j=startJdx; j<startJdx+3; ++j) {
                if (board[i][j] == '.') continue;
                if (list.contains(board[i][j])) return false;
                list.add(board[i][j]);
            }
        }

        return true;
    }

    public boolean checkBlock1(char[][]board, int rowOffset, int colOffset) {
        int startIdx = rowOffset * 3;
        int startJdx = colOffset * 3;
        List<Character> list = new ArrayList<>();
        for (int i=startIdx; i < startIdx+3; ++i) {
            for (int j=startJdx; j<startJdx+3; ++j) {
                if (board[i][j] == '.') return false;
                if (list.contains(board[i][j])) return false;
                list.add(board[i][j]);
            }
        }

        return true;
    }
}
