public class UniquePath1 {
  public int uniquePaths(int m, int n) {
    int[][] map = new int[m][n];
    for(int x = 0; x < m; x++){
      for(int y = 0; y < n; y++){
        if(x == 0 || y == 0){
          map[x][y] = 1;
        }else{
          map[x][y] = map[x-1][y] + map[x][y-1];
        }
      }
    }
    return map[m-1][n-1];
  }
}
