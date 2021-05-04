public class JumpGame3 {
  //w/o (extra space + helper method)
  public boolean canReach(int[] arr, int st) {
    if (st >= 0 && st < arr.length && arr[st] < arr.length) {
      int jump = arr[st];
      arr[st] += arr.length;
      return jump == 0 || canReach(arr, st + jump) || canReach(arr, st - jump);
    }
    return false;
  }


  //w/ helper method + auxiliary space
//     public boolean canReach(int[] arr, int start) {
//         int[] dp = new int[arr.length];
//         helper(arr, start, dp);
//         for(int x = 0; x < dp.length; x++){
//             if(dp[x] == -1) return true;
//         }
//         return false;
//     }

//     private void helper(int[] arr, int i, int[] dp){
//         if(i < 0 || i >= arr.length || dp[i] > 0) return;
//         if(arr[i] == 0){
//             dp[i] = -1;
//             return;
//         }
//         dp[i]++;
//         helper(arr, i-arr[i], dp);
//         helper(arr, i+arr[i], dp);
//     }
}
