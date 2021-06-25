public class SurroundedRegions {
  public void solve(char[][] board) {
    int m = board.length, n = board[0].length;
    for(int x = 0; x < m; x++){
      if(board[x][0] == 'O') helper(board, x, 0);
      if(board[x][n-1] == 'O') helper(board, x, n-1);
    }
    for(int x = 0; x < n; x++){
      if(board[0][x] == 'O') helper(board, 0, x);
      if(board[m-1][x] == 'O') helper(board, m-1, x);
    }
    for(int x = 0; x < m; x++){
      for(int y = 0; y < n; y++){
        if(board[x][y] == 'O')
          board[x][y] = 'X';
        if(board[x][y] == '@')
          board[x][y] = 'O';
      }
    }
  }
  private void helper(char[][] board, int x, int y){
    if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == 'X' || board[x][y] == '@'){//注意改过的也要return！！ 不然会stack overflow
      return;
    }
    board[x][y] = '@';
    helper(board, x-1, y);
    helper(board, x, y-1);
    helper(board, x+1, y);
    helper(board, x, y+1);
  }
}
