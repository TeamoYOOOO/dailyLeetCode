public class MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    for(int x = 0; x < grid.length; x++){
      for(int y = 0; y < grid[0].length; y++){
        if(grid[x][y] == 1){
          int curr = helper(grid, x, y);
          max = Math.max(max, curr);
        }
      }
    }
    return max;
  }

  private int helper(int[][] grid, int x, int y){
    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0){
      return 0;
    }
    grid[x][y] = 0;
    return helper(grid, x-1, y) + helper(grid, x, y-1) + helper(grid, x+1, y) + helper(grid, x, y+1) + 1;
  }
}
