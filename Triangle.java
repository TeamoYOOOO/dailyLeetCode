import java.util.List;

public class Triangle {
  //自己写的 从上往下 额外的int[][] 记录当前最小值
  public int minimumTotal(List<List<Integer>> triangle) {
    int m = triangle.size(), n = triangle.get(m-1).size();
    int min = Integer.MAX_VALUE;
    int[][] dp = new int[m][n];
    for(int x = 0; x < m; x++){
      for(int y = 0; y < triangle.get(x).size(); y++){
        if(y == 0){
          dp[x][y] = x == 0? triangle.get(x).get(y) : dp[x-1][y] + triangle.get(x).get(y);
        }else if(y == triangle.get(x).size()-1){
          dp[x][y] = dp[x-1][y-1] + triangle.get(x).get(y);
        }else{
          dp[x][y] = Math.min(dp[x-1][y-1], dp[x-1][y]) + triangle.get(x).get(y);
        }
      }
    }
    for(int x = 0; x < dp[0].length; x++){
      min = Math.min(dp[dp.length-1][x], min);
    }
    return min;
  }


//  public int minimumTotal(List<List<Integer>> triangle) {
//    //从下往上 这样不用最后遍历一遍 最后一排找最小
//    //直接在原有的list上改 不需要额外的memory
//    for(int i=triangle.size()-2;i>=0;i--){
//      for(int j=0;j<=i;j++){
//        int self = triangle.get(i).get(j);
//        int res = Math.min(triangle.get(i+1).get(j)+self, triangle.get(i+1).get(j+1)+self);
//        triangle.get(i).set(j,res);
//      }
//    }
//    return triangle.get(0).get(0);
//  }
}
