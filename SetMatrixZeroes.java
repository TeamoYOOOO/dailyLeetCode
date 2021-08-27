public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    boolean fr = false,fc = false;//为了防止第一排或者第一列有0 没法分辨 true就是代表有0 最后要把这一排/列全部更新为0
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        if(matrix[i][j] == 0) {
          if(i == 0) fr = true;
          if(j == 0) fc = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for(int i = 1; i < matrix.length; i++) {
      for(int j = 1; j < matrix[0].length; j++) {
        if(matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if(fr) {
      for(int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if(fc) {
      for(int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }


  // public void setZeroes(int[][] matrix) {
  //     for(int x = 0; x < matrix.length; x++){
  //         for(int y = 0; y < matrix[x].length; y++){
  //             if(matrix[x][y] == 0){
  //                 row.add(x);
  //                 col.add(y);
  //             }
  //         }
  //     }
  //     for(int x = 0; x < matrix.length; x++){
  //         for(int y = 0; y < matrix[x].length; y++){
  //             if(row.contains(x) || col.contains(y)){
  //                 matrix[x][y] = 0;
  //             }
  //         }
  //     }
  // }
}
