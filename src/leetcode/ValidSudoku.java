class Solution {

    public boolean isValidSudoku(char[][] board) {

        // check row
        for (int i=0; i<board.length; ++i) {
            boolean[] f = new boolean[10];
            for (int j=0; j<board[i].length; ++j) {
                if (board[i][j] == '.') continue;
                if (f[board[i][j] - '0']) return false;
                f[board[i][j] - '0'] = true;
            }
        }

        // check column
        for (int j=0; j<board.length; ++j) {
            boolean[] ff = new boolean[10];
            for (int k=0; k<board.length; ++k) {
                if (board[k][j] == '.')  continue;
                if (ff[board[k][j] - '0']) return false;
                ff[board[k][j] - '0'] = true;
            }
        }

        // check block
        for (int i=0; i<board.length; i=i+3) {
            for (int j=0; j<board[i].length; j=j+3) {
                int rowOffset = i/3;
                int colOffset = j/3;
                if (!checkBlock(board, rowOffset, colOffset)) {
                    return false;
                }
            }
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
}
