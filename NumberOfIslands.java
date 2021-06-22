public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int count = 0;
    for(int x = 0; x < grid.length; x++){
      for(int y = 0; y < grid[0].length; y++){
        if(grid[x][y] == '1'){
          count++;
          helper(grid, x, y);
        }
      }
    }
    return count;
  }

  private void helper(char[][] grid, int x, int y){
    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'){
      return;
    }
    grid[x][y] = '0';
    helper(grid, x-1, y);
    helper(grid, x, y-1);
    helper(grid, x+1, y);
    helper(grid, x, y+1);
  }
}
