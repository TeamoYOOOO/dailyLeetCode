public class WordSearch {
  public boolean exist(char[][] board, String word) {
    boolean res = false;
    for(int x = 0; x < board.length; x++){
      for(int y = 0; y < board[0].length; y++){
        if(board[x][y] == word.charAt(0)){
          res = res || helper(board, x, y, 0, word);
        }
      }
    }
    return res;
  }

  private boolean helper(char[][] board, int x, int y, int i, String word){
    if(i == word.length()) return true;
    if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(i)){
      return false;
    }
    char curr = board[x][y];
    board[x][y] = '@';//需要backtracking一下 不然会影响到后面的检查
    boolean res = helper(board, x-1, y, i+1, word) || helper(board, x, y-1, i+1, word) || helper(board, x+1, y, i+1, word) || helper(board, x, y+1, i+1, word);
    board[x][y] = curr;
    return res;
  }
}
