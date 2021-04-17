public class UniquePath2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] map = new int[m][n];
    for(int x = 0; x < m; x++){
      for(int y = 0; y < n; y++){
        if(x == 0 && y == 0){
          if(obstacleGrid[0][0] == 1) return 0;
          map[x][y] = 1;
        }else if(obstacleGrid[x][y] == 1){
          map[x][y] = 0;
        }else if(x == 0){
          map[x][y] = map[x][y-1];
        }else if(y == 0){
          map[x][y] = map[x-1][y];
        }else{
          map[x][y] = map[x-1][y] + map[x][y-1];
        }
      }
    }
    return map[m-1][n-1];
  }
}
