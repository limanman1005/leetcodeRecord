package mySummary.Dfs;

/**
 * ClassName: WordSearch
 * Description:
 * date: 19/5/2022 上午2:01
 *
 * @author liyh
 */
public class WordSearch {
}
class Solution79 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, board, word, 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int idx){
        if(idx >= word.length()){
            return true;
        }
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for(int k = 0; k < 4; ++k){
            int nx = i + dx[k];
            int ny = i + dy[k];
            if(isInBoard(nx, ny, board) && board[nx][ny] == word.charAt(idx)){
                return dfs(nx, ny, board, word, idx + 1);
            }
        }
        return false;
    }

    private boolean isInBoard(int nx, int ny, char[][] board){
        if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length){
            return true;
        }
        return false;
    }
}
