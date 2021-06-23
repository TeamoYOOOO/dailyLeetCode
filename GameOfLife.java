public class GameOfLife {
  public void gameOfLife(int[][] board) {
    int[][] res = new int[board.length][board[0].length];
    for(int x = 0; x < board.length; x++){
      for(int y = 0; y < board[0].length; y++){
        int count = count(board, x, y);
        if(board[x][y] == 1){
          if(count > 3 || count < 2)
            res[x][y] = 0;
          else
            res[x][y] = 1;
        }else if(board[x][y] == 0 && count == 3){
          res[x][y] = 1;
        }

      }
    }
    for(int x = 0; x < board.length; x++){
      for(int y = 0; y < board[0].length; y++){
        board[x][y] = res[x][y];
      }
    }
  }
  private int count(int[][] board, int x, int y){
    int count = 0;
    if(x-1 >= 0 && y-1 >= 0 && board[x-1][y-1] == 1) count++;
    if(x-1 >= 0 && board[x-1][y] == 1) count++;
    if(x-1 >= 0 && y+1 < board[x].length && board[x-1][y+1] == 1) count++;
    if(y-1 >= 0 && board[x][y-1] == 1) count++;
    if(y+1 < board[x].length && board[x][y+1] == 1) count++;
    if(x+1 < board.length && y-1 >= 0 && board[x+1][y-1] == 1) count++;
    if(x+1 < board.length && board[x+1][y] == 1) count++;
    if(x+1 < board.length && y+1 < board[x].length && board[x+1][y+1] == 1) count++;
    return count;
  }
}
