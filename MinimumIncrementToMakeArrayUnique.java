public class MinimumIncrementToMakeArrayUnique {
  public int minIncrementForUnique(int[] A) {
    // if(A.length== 0) return 0;//edge case
    // Arrays.sort(A);
    // int i = A[0];
    // int res = 0;
    // for(int x = 0; x < A.length; x++){
    //     if(A[x] < i) res += i-A[x];//注意要检查condition 比这个数大/等于都不考虑
    //     i = Math.max(A[x], i);
    //     i++;
    // }
    // return res;


    //这种写法不用考虑空的arr的edge case, 本质就是每个比前面的数大1就好
    Arrays.sort(A);
    int res = 0;
    for(int x = 1; x < A.length; x++){
      if(A[x] <= A[x-1]){//前面的数可能改完会比后面的数大 所以是<=
        res += A[x-1] - A[x] + 1;
        A[x] = A[x-1]+1;
      }
    }
    return res;



    //!!!!!!!!!!不对!!!!!!! case [0,2,2] 只能increase所以必须是023 我这个解会出来0
    // Arrays.sort(A);
    // int res = 0;
    // for(int x = 0; x < A.length; x++){
    //     if(A[x]<A[0]+x) res += (A[0]+x)-A[x];//注意要检查condition 比这个数大/等于都不考虑
    // }
    // return res;
  }
}
